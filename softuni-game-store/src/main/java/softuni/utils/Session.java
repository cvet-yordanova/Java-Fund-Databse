package softuni.utils;


import softuni.models.bindingModels.user.LoggedInUser;

public class Session {

    private static LoggedInUser currentLoggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return currentLoggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        Session.currentLoggedInUser = loggedInUser;
    }
}
