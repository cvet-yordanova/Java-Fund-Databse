package softuni.dto.export_posts_without_comments_json;


import com.google.gson.annotations.Expose;
import softuni.entites.Picture;
import softuni.entites.User;

public class ExportPostsWithoutCommentsJsonDto {

    @Expose
    private Integer id;

    @Expose
    private String userUsername;

    @Expose
    private String picturePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
