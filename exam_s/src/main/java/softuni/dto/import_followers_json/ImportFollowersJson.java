package softuni.dto.import_followers_json;


import com.google.gson.annotations.Expose;

public class ImportFollowersJson {

    @Expose
    private String user;
    @Expose
    private String follower;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }
}
