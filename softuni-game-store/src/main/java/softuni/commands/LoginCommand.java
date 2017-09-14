package softuni.commands;


import softuni.models.bindingModels.user.LoggedInUser;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

public class LoginCommand extends Command{

    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        String username = params[0];
        String password = params[1];

        LoggedInUser loggedInUser = super.getUserService().logIn(username, password);
        if(Session.getLoggedInUser() != null) {
            return "User already logged in";
        }
        if(loggedInUser == null){
            return "Incorrect email / password.";
        }

        Session.setLoggedInUser(loggedInUser);

        return String.format("Successfully logged in %s",loggedInUser.getFullName());

    }
}
