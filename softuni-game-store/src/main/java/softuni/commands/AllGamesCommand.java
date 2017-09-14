package softuni.commands;


import softuni.models.viewModels.game.GameView;
import softuni.service.api.GameService;
import softuni.service.api.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class AllGamesCommand extends Command{

    public AllGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        List<GameView> listGameViews = super.getGameService().getAll();
        return listGameViews.stream().map(a -> a.toString()).collect(Collectors.joining("\n"));
    }
}
