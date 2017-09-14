package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entites.Game;
import softuni.entites.User;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.game.DeleteGame;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.viewModels.game.GameDetailsView;
import softuni.models.viewModels.game.GameView;
import softuni.models.viewModels.game.OwnedGame;
import softuni.repositories.GameRepository;
import softuni.service.api.GameService;
import softuni.utils.ModelParser;
import softuni.utils.Session;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GameServiceImpl implements GameService{

    @Autowired
    private final GameRepository gameRepositoryl;

    public GameServiceImpl(GameRepository gameRepositoryl) {
        this.gameRepositoryl = gameRepositoryl;
    }

    @Override
    public void AddGame(AddGame addGame) {
        Game game = ModelParser.getInstance().map(addGame, Game.class);
        this.gameRepositoryl.saveAndFlush(game);
    }

    @Override
    public List<GameView> getAll() {
        List<Game> listGames = gameRepositoryl.findAll();
        List<GameView> listGameViews = new ArrayList<>();

        for (Game game : listGames) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            listGameViews.add(gameView);
        }
        return listGameViews;
    }

    @Override
    public EditGame editGameFindById(Long id) {
        Game gameToEdit = gameRepositoryl.findOne(id);
        return ModelParser.getInstance().map(gameToEdit,EditGame.class);
    }

    @Override
    public void editGame(EditGame editGame) {
        Game game = ModelParser.getInstance().map(editGame, Game.class);
        this.gameRepositoryl.saveAndFlush(game);
    }

    @Override
    public DeleteGame deleteGameFindById(Long id) {
        Game game = gameRepositoryl.findOne(id);
        return ModelParser.getInstance().map(game,DeleteGame.class);
    }

    @Override
    public void deleteGame(DeleteGame deleteGame) {
        Game gameToDelete = ModelParser.getInstance().map(deleteGame,Game.class);
        gameRepositoryl.delete(gameToDelete);
        gameRepositoryl.flush();
    }

    @Override
    public GameDetailsView findGameDetailsByTitle(String title) {
        Game game = gameRepositoryl.findByTitle(title);
        return ModelParser.getInstance().map(game,GameDetailsView.class);
    }

    @Override
    public ShoppingCartGame getShoppingCartGameByTitle(String title) {
        Game game = gameRepositoryl.findByTitle(title);
        return ModelParser.getInstance().map(game, ShoppingCartGame.class);
    }

    @Override
    public Game findGameByTitle(String title) {
        return gameRepositoryl.findByTitle(title);
    }
}
