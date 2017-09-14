package softuni.dto.export_popular_users_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entites.User;

import java.util.Set;

public class ExportPopularUserJsonDto {

    private Set<User> followers;
    @Expose
    private String username;
    @Expose
    @SerializedName(value = "followers")
    private Integer countFollowers;

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountFollowers() {
        return countFollowers;
    }

    public void setCountFollowers(Integer countFollowers) {
        this.countFollowers = countFollowers;
    }
}
