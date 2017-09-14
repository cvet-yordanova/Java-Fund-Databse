package softuni.commands;


import softuni.service.api.GameService;
import softuni.service.api.UserService;

public abstract class Command implements Executable{

    private UserService userService;
    private GameService gameService;

    protected Command(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    protected UserService getUserService() {
        return userService;
    }

    protected void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected GameService getGameService() {
        return gameService;
    }

    protected void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
