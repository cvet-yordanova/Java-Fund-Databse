package softuni.service.api;


import softuni.entites.Game;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.game.DeleteGame;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.models.viewModels.game.GameDetailsView;
import softuni.models.viewModels.game.GameView;
import softuni.models.viewModels.game.OwnedGame;

import java.util.List;

public interface GameService {
    public void AddGame(AddGame addGame);
    List<GameView> getAll();
    void editGame(EditGame editGame);
    EditGame editGameFindById(Long id);
    DeleteGame deleteGameFindById(Long id);
    void deleteGame(DeleteGame deleteGame);
    GameDetailsView findGameDetailsByTitle(String title);
    ShoppingCartGame getShoppingCartGameByTitle(String title);
    Game findGameByTitle(String title);
}
