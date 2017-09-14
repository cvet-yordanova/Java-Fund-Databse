package softuni.commands;


import softuni.models.viewModels.game.GameDetailsView;
import softuni.service.api.GameService;
import softuni.service.api.UserService;

import java.text.ParseException;

public class GameDetailsCommand extends Command{

    public GameDetailsCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) throws ParseException {

        GameDetailsView gameDetailsView = super.getGameService().findGameDetailsByTitle(params[0]);
        return gameDetailsView.toString();
    }
}
