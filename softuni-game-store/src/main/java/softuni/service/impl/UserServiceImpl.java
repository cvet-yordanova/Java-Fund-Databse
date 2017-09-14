package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entites.Game;
import softuni.entites.User;
import softuni.enums.Role;
import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.viewModels.game.OwnedGame;
import softuni.repositories.GameRepository;
import softuni.utils.ModelParser;
import softuni.models.bindingModels.user.RegisterUser;
import softuni.repositories.UserRepository;
import softuni.service.api.UserService;
import softuni.utils.Session;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final GameRepository gameRepository;

    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public void persist(RegisterUser registerUser) {
            User user = ModelParser.getInstance().map(registerUser, User.class);

            if(this.userRepository.findAll().size() > 0){
                user.setRole(Role.USER);
            } else {
                user.setRole(Role.ADMIN);
            }
            this.userRepository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser logIn(String username, String password) {
        User user = userRepository.findByEmailAndPassword(username, password);
        Set<OwnedGame> ownedGames = new HashSet<>();
        Set<ShoppingCartGame> shoppingCartGamesAdd = new HashSet<>();

        LoggedInUser loggedInUser = null;

        if(user != null){
            loggedInUser = ModelParser.getInstance().map(user, LoggedInUser.class);

            if(user.getBoughtGames().size() > 0) {
                Set<Game> games = user.getBoughtGames();
                for (Game game : games) {
                    OwnedGame ownedGame = ModelParser.getInstance().map(game, OwnedGame.class);
                    ownedGames.add(ownedGame);
                }
                loggedInUser.setOwnedGames(ownedGames);

            }

            if(user.getShoppingCartGames().size() > 0) {

                Set<Game> shoppingCartGames = user.getShoppingCartGames();
                for (Game shoppingCartGame : shoppingCartGames) {
                    ShoppingCartGame shoppingCartGame1 = ModelParser.getInstance().map(shoppingCartGame, ShoppingCartGame.class);
                    shoppingCartGamesAdd.add(shoppingCartGame1);
                }
                loggedInUser.setShoppingCartGames(shoppingCartGamesAdd);

            }

        }
        return loggedInUser;
    }

    @Override
    public Set<OwnedGame> listOwnedGames() {
        LoggedInUser currentlyLoggedInUser = Session.getLoggedInUser();
        return currentlyLoggedInUser.getOwnedGames();

    }

    @Override
    public void addGameToShoppingCart(ShoppingCartGame shoppingCartGame) {
        Game game = gameRepository.findByTitle(shoppingCartGame.getTitle());
        User user = userRepository.findOne(Session.getLoggedInUser().getId());

        user.getShoppingCartGames().add(game);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void buyGames() {
        User user = userRepository.findOne(Session.getLoggedInUser().getId());
        Set<Game> gamesToBuy = user.getShoppingCartGames();
        user.getBoughtGames().addAll(gamesToBuy);
        user.getShoppingCartGames().removeAll(gamesToBuy);

        userRepository.saveAndFlush(user);
    }
}
