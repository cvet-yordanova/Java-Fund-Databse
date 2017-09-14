package user;


import entites.account.BasicAccount;
import exception.CustomException;
import exception.InvalidEmail;
import exception.InvalidPassword;
import exception.InvalidUsername;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    List<BasicAccount> bankAccounts;

    public User() {
    }

    public User(String username, String email, String password) throws CustomException {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.bankAccounts = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws CustomException {

        if(!username.matches("^[^\\d]+[a-zA-z0-9]+$")|| username.length() < 3){
            if(username.length() < 3){
                throw new InvalidUsername("Username must be at least 3 characters!");
            }
            if(username.matches("^[\\d]+[a-zA-z0-9]+$")){
                throw new InvalidUsername("Username cannot start with digits!");
            }
            else {
                throw new InvalidUsername("Username can contain only letters and digits!");
            }
        }
        this.username = username;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws CustomException {

        if(!email.matches("^[a-z0-9-_]+(?:\\.[a-z0-9_-]+)*" +
                "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"))
        {
            throw new InvalidEmail("Please enter valid email");
        }

        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws CustomException{

        boolean checkUppercase = password.matches(".*[A-Z].*");
        boolean checkLowercase = password.matches(".*[a-z].*");
        boolean checkDigit = password.matches(".*[0-9].*");
        boolean checkLength = password.length() > 6;

        boolean[] checks = {checkUppercase,checkLowercase,checkDigit,checkLength};
        String[] errorMessages = {"Password must contain at least one uppercase letter!",
        "Password must contain at least one lowercase letter!",
        "Password must contain at least one digit!",
        "Password must be at least 6 characters long!"};


        if(!(checkUppercase && checkLowercase && checkDigit && checkLength)){
            StringBuilder message = new StringBuilder();

            for (int i = 0; i < errorMessages.length; i++) {
                if(!checks[i]){
                    message.append(errorMessages[i]);
                }
            }
            throw  new InvalidPassword(message.toString());
        }
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    public List<BasicAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BasicAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
