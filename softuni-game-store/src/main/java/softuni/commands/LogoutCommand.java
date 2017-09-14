package softuni.commands;


import softuni.models.bindingModels.user.LoggedInUser;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

public class LogoutCommand extends Command{

    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser() == null){
            return "Cannot logout. No user was logged in.";
        }

        LoggedInUser loggedInUser = Session.getLoggedInUser();
        Session.setLoggedInUser(null);
        return String .format("User %s successfully logged out.", loggedInUser.getFullName());
    }
}
