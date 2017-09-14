package softuni.commands;


import softuni.entites.Game;
import softuni.enums.Role;
import softuni.models.bindingModels.game.EditGame;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class EditGameCommand extends Command{

    public EditGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) throws ParseException {

        if(Session.getLoggedInUser() == null){
            return "No user logged in";
        }

        if(Session.getLoggedInUser().getRole() != Role.ADMIN){
            return "Only admins can edit games.";
        }
        EditGame editGame = super.getGameService().editGameFindById(Long.parseLong(params[0]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for (String param : params) {

            if(param.matches("[1-9]+")){
                continue;
            }
            String[] data = param.split("=");
            String fieldName = data[0];
            String fieldValue = data[1];

            switch(fieldName){
                case "title":editGame.setTitle(fieldValue);
                break;
                case "price":editGame.setPrice(new BigDecimal(fieldValue));
                break;
                case "size":editGame.setSize(Double.parseDouble(fieldValue));
                break;
                case "trailer":editGame.setTrailer(fieldValue);
                break;
                case "thumbnail":editGame.setThumbnailURL(fieldValue);
                break;
                case "description":editGame.setDescription(fieldValue);
                break;
                case "releaseDate":editGame.setReleaseDate(simpleDateFormat.parse(fieldValue));
                break;
            }
        }

        super.getGameService().editGame(editGame);
        return "Game edited.";
    }
}
