package softuni.commands;


import softuni.models.viewModels.game.OwnedGame;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.text.ParseException;
import java.util.Set;

public class OwnedGamesCommand extends Command{

    public OwnedGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) throws ParseException {

        if(Session.getLoggedInUser() == null){
            return "You should be logged in to see your games.";
        }

       return Session.getLoggedInUser().getOwnedGames().toString();

    }
}
