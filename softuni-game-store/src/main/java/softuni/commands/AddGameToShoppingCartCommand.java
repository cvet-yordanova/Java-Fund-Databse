package softuni.commands;


import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.text.ParseException;

public class AddGameToShoppingCartCommand extends Command{

    public AddGameToShoppingCartCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) throws ParseException {

        if(Session.getLoggedInUser() == null){
            return "No user logged in";
        }

        if(Session.getLoggedInUser().getShoppingCartGames().stream().anyMatch(a -> a.getTitle().equals(params[0]))){
                return "This game was already added in the shopping cart.";
        }

        ShoppingCartGame shoppingCartGame = super.getGameService().getShoppingCartGameByTitle(params[0]);
        super.getUserService().addGameToShoppingCart(shoppingCartGame);
        return "Game added to shopping cart.";
    }
}
