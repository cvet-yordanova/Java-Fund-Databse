package softuni.service.api;


import softuni.entites.Game;
import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.bindingModels.user.RegisterUser;
import softuni.models.viewModels.game.OwnedGame;

import java.util.Set;

public interface UserService {
    public void persist(RegisterUser registerUser);
    LoggedInUser logIn(String username, String password);
    public Set<OwnedGame> listOwnedGames();
    void addGameToShoppingCart(ShoppingCartGame game);
    void buyGames();
}
