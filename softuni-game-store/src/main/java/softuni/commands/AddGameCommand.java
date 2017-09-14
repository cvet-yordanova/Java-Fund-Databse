package softuni.commands;


import softuni.enums.Role;
import softuni.models.bindingModels.game.AddGame;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.DataParser;
import softuni.utils.Session;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddGameCommand extends Command{

    public AddGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser() == null){
            return "No user logged in";
        }

        if(Session.getLoggedInUser().getRole() != Role.ADMIN){
            return "Only admins can add games.";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            AddGame addGame = new AddGame(params[0],
                    new BigDecimal(params[1]),
                    Double.parseDouble(params[2]),
                    params[3],
                    params[4],
                    params[5],
                    simpleDateFormat.parse(params[6]));
            if(!DataParser.checkIsValid(addGame)){
                return DataParser.getInvalidParameterMessage(addGame);
            }

            super.getGameService().AddGame(addGame);
            return String.format("Added %s ", params[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
