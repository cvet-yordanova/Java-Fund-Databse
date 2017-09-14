package softuni.models.bindingModels.user;


import softuni.validators.Password;
import softuni.validators.PasswordMatcher;

import javax.validation.constraints.Pattern;

@PasswordMatcher
public class RegisterUser {

    @Pattern(regexp = ".+[@].+", message = "Invalid Email")
    private String email;
    @Password
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
