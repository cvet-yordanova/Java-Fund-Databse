package softuni.models.bindingModels.user;


import softuni.enums.Role;
import softuni.models.bindingModels.game.ShoppingCartGame;
import softuni.models.viewModels.game.OwnedGame;

import java.util.Set;

public class LoggedInUser {
    private Long id;
    private Role role;
    private String fullName;
    private Set<OwnedGame> boughtGames;
    private Set<ShoppingCartGame> shoppingCartGames;


    public LoggedInUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<OwnedGame> getOwnedGames() {
        return boughtGames;
    }

    public void setOwnedGames(Set<OwnedGame> ownedGames) {
        this.boughtGames = ownedGames;
    }

    public Set<OwnedGame> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<OwnedGame> boughtGames) {
        this.boughtGames = boughtGames;
    }

    public Set<ShoppingCartGame> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<ShoppingCartGame> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }
}
