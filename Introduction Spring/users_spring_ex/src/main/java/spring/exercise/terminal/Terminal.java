package spring.exercise.terminal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.exercise.entites.User;
import spring.exercise.services.api.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private final UserService userService;

    public Terminal(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {

        insertNewUser();

        findUserByEmailProvider();

        deleteInactiveUsers();


    }

    private void deleteInactiveUsers() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
        List<User> inactiveUsers = userService.findByLastTimeLoggedInBefore(format.parse("12/12/2017"));

        for (User inactiveUser : inactiveUsers) {
            inactiveUser.setDeleted(true);
            userService.persist(inactiveUser);
        }
        System.out.println(inactiveUsers.size()+" users have been deleted.");
    }

    private void findUserByEmailProvider() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter mail provider:");
        String emailProvider = reader.readLine();
        List<User> users = userService.findAll();
        for (User user1 : users) {
            if(user1.getEmail().substring(user1.getEmail().indexOf("@")+1).equals(emailProvider)){
                System.out.println(user1.getUsername()+" "+user1.getEmail());
            }
        }
    }

    private void insertNewUser() {

            User user = new User();
            user.setUsername("stef4o");
            user.setEmail("-stefo@gmail.com");
            user.setPassword("asdfgA!12");
            user.setAge(20);

            userService.persist(user);

    }


}
