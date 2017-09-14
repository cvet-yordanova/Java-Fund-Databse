package softuni.commands;


import org.springframework.data.jpa.repository.Modifying;
import softuni.enums.Role;
import softuni.models.bindingModels.game.DeleteGame;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;


public class DeleteGameCommand extends Command{

    public DeleteGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        if(Session.getLoggedInUser() == null){
            return "No user logged in";
        }

        if(Session.getLoggedInUser().getRole() != Role.ADMIN){
            return "Only admins can delete games.";
        }

        DeleteGame deleteGame = super.getGameService().deleteGameFindById(Long.parseLong(params[0]));
        super.getGameService().deleteGame(deleteGame);
        return String.format("Game %s deleted",deleteGame.getTitle());
    }
}
