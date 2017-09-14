package softuni.dto.import_users_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entites.Picture;

public class ImportUserJsonDto {

    @Expose
    private String username;

    @Expose
    private String password;

    @Expose
    @SerializedName(value = "profile_picture")
    private String profilePicturePath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicturePath;
    }

    public void setProfilePicture(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
}
