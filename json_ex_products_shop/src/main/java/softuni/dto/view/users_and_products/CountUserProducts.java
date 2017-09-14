package softuni.dto.view.users_and_products;


import com.google.gson.annotations.Expose;

import java.util.List;

public class CountUserProducts {

    @Expose
    private Integer usersCount;
    @Expose
    private List<UserProducts> users;

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserProducts> getUsers() {
        return users;
    }

    public void setUsers(List<UserProducts> users) {
        this.users = users;
    }
}
