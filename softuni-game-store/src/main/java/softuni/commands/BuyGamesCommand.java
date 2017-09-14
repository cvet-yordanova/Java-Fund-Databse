package softuni.commands;


import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.text.ParseException;

public class BuyGamesCommand extends Command{

    public BuyGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) throws ParseException {

        if(Session.getLoggedInUser() == null){
            return "No user logged in";
        }

        super.getUserService().buyGames();

        return String.format("Games bought.");
    }
}
