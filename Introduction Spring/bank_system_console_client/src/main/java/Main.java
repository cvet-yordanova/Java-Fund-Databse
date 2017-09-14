import com.sun.org.apache.bcel.internal.generic.GOTO;
import entites.account.Account;
import entites.account.BasicAccount;
import entites.account.CheckingAccount;
import entites.account.SavingAccount;
import exception.CustomException;
import org.hibernate.boot.jaxb.SourceType;
import sun.misc.BASE64Decoder;
import user.User;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException,SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean performAction = true;
        boolean isUserLoggedIn = false;
        String response = "";

        User loggedUser = null;

       // String regOrLogin = reader.readLine();

        while (performAction) {

            if(!isUserLoggedIn) {

                System.out.println("For Register enter 1  /  For Login enter 2");
                String regOrLogin = reader.readLine();

                switch (regOrLogin) {

                    case "1":
                        System.out.println("Enter username.");
                        String newUsername = reader.readLine();
                        System.out.println("Enter password.");
                        String newPassword = reader.readLine();
                        System.out.println("Enter valid email.");
                        String newEmail = reader.readLine();

                        try {
                            User newUser = new User(newUsername, newEmail, newPassword);
                            em.getTransaction().begin();
                            em.persist(newUser);
                            em.getTransaction().commit();
                            System.out.println("Successful registration!");
                        } catch (CustomException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Register again? Yes/No");
                            String answer = reader.readLine().toLowerCase();
                            if (answer.equals("yes")) {
                                performAction = true;
                                isUserLoggedIn = false;
                            } else {
                                performAction = false;
                                isUserLoggedIn = false;
                            }
                            continue;
                        }
//                        finally {
//                            em.close();
//                        }
                        break;
                    case "2":
                        System.out.println("Enter username.");
                        String username = reader.readLine();
                        System.out.println("Enter password.");
                        String password = reader.readLine();

                        Query findUser = em.createQuery("SELECT u FROM User as u WHERE u.username = :username AND u.password = :password ");
                        findUser.setParameter("username",username);
                        findUser.setParameter("password",password);

                        try{
                            loggedUser = (User)findUser.getSingleResult();
                            System.out.println("Successfully logged in!");
                            isUserLoggedIn = true;
                            performAction = true;
                            continue;
                        }catch (Exception s) {
                            System.out.println("Nqma takyv potrebitel!");
                            System.out.println("Log again? Yes/No");
                             response = reader.readLine().toLowerCase();

                            System.out.println("Continue? Yes/No");
                            response = reader.readLine().toLowerCase();
                            if(response.equals("yes")){
                                performAction = true;
                                continue;
                            }
                            else {
                                performAction = false;
                                continue;
                            }
                        }

                    //End case
                } //End switch
            } //End if (isUserLogged)

            else {
                System.out.println("For Logout enter 1\n" +
                        "For Add Saving Account enter 2\n" +
                        "For Add Checking Account enter 3\n" +
                        "For ListAccounts enter 4\n" +
                        "For Deposit money enter 5\n" +
                        "For WithDraw money enter 6\n" +
                        "For DeductFee enter 7\n" +
                        "For Add interest enter 8\n");
                String action = reader.readLine();

                switch (action){
                    case "1":
                        isUserLoggedIn = false;
                        loggedUser = null;
                        System.out.println("Continue? Yes/No");
                         response = reader.readLine().toLowerCase();
                        if(response.equals("yes")){
                            performAction = true;
                            continue;
                        }
                        else {
                            performAction = false;
                            continue;
                        }
                    case "2":
                        System.out.println("Enter initial balance.");
                        BigDecimal initialBalance = new BigDecimal(reader.readLine());
                        System.out.println("Enter interest rate.");
                        Double interestRate = Double.parseDouble(reader.readLine());

                        try{BasicAccount newSavingAccount = new SavingAccount("random",initialBalance,interestRate);
                        loggedUser.getBankAccounts().add(newSavingAccount);
                        newSavingAccount.setUser(loggedUser);
                        em.getTransaction().begin();
                        em.persist(newSavingAccount);
                        em.persist(loggedUser);
                        em.getTransaction().commit();
                        System.out.println("Successfully added saving account");
                            System.out.println("Continue? Yes/No");
                            response = reader.readLine().toLowerCase();
                            if(response.equals("yes")){
                                performAction = true;
                                continue;
                            }
                            else {
                                performAction = false;
                                continue;
                            }
                        }catch (Exception e){
                            System.out.println("Adding saving account failed");
                            System.out.println("Continue? Yes/No");
                            response = reader.readLine().toLowerCase();
                            if(response.equals("yes")){
                                performAction = true;
                                continue;
                            }
                            else {
                                performAction = false;
                                continue;
                            }
                            //todo iska li da prodylji
                        }
                    case "3":
                        System.out.println("Enter initial balance.");
                        BigDecimal balance = new BigDecimal(reader.readLine());
                        System.out.println("Enter fee.");
                        Double fee = Double.parseDouble(reader.readLine());

                        try{BasicAccount newCheckingAccount = new CheckingAccount("random",balance,fee);
                            loggedUser.getBankAccounts().add(newCheckingAccount);
                            newCheckingAccount.setUser(loggedUser);
                            em.getTransaction().begin();
                            em.persist(newCheckingAccount);
                            em.persist(loggedUser);
                            em.getTransaction().commit();
                            System.out.println("Successfully added saving account");}catch (Exception e){
                            System.out.println("Adding checking account failed. Try again ? Yes/No");

                            System.out.println("Continue? Yes/No");
                            response = reader.readLine().toLowerCase();
                            if(response.equals("yes")){
                                performAction = true;
                                continue;
                            }
                            else {
                                performAction = false;
                                continue;
                            }
                            //todo iska li da prodylji
                        }
                    case "4":

                        System.out.println("Saving accounts: ");
                        loggedUser
                                .getBankAccounts()
                                .stream()
                                .filter(a -> a.getClass()
                                        .getSimpleName().equals("SavingAccount"))
                                .forEach( a -> System.out.printf("-- %s $%s\n",a.getAccountNumber(),a.getBalance()));

                        System.out.println("Checking accounts: ");
                        loggedUser
                                .getBankAccounts()
                                .stream()
                                .filter(a -> a.getClass()
                                        .getSimpleName().equals("CheckingAccount"))
                                .forEach( a -> System.out.printf("-- %s $%s\n",a.getAccountNumber(),a.getBalance()));

                        System.out.println("Continue? Yes/No");
                        response = reader.readLine().toLowerCase();
                        if(response.equals("yes")){
                            performAction = true;
                            continue;
                        }
                        else {
                            performAction = false;
                            continue;
                        }
                    case "5":

                        System.out.println("Enter account number.");
                        String accountNumber = reader.readLine();
                        System.out.println("Enter money to deposit.");
                        BigDecimal moneyDeposit = new BigDecimal(reader.readLine());

                        Query findAccountQuery = em.createQuery("SELECT b FROM BasicAccount as b WHERE b.accountNumber = :accountNumber");
                        findAccountQuery.setParameter("accountNumber",accountNumber);

                        BasicAccount currentAccount = (BasicAccount) findAccountQuery.getSingleResult();
                        currentAccount.depositMoney(moneyDeposit);

                        em.getTransaction().begin();
                        em.persist(currentAccount);
                        em.getTransaction().commit();

                        System.out.println("Continue? Yes/No");
                        response = reader.readLine().toLowerCase();
                        if(response.equals("yes")){
                            performAction = true;
                            continue;
                        }
                        else {
                            performAction = false;
                            continue;
                        }
                    case "6":
                        System.out.println("Enter account number.");
                        String numAccount = reader.readLine();
                        System.out.println("Enter money to withdraw.");
                        BigDecimal moneyWithdraw = new BigDecimal(reader.readLine());

                        Query findAccount = em.createQuery("SELECT b FROM BasicAccount as b WHERE b.accountNumber = :accountNumber");
                        findAccount.setParameter("accountNumber",numAccount);

                        BasicAccount account = (BasicAccount) findAccount.getSingleResult();
                        account.withDrawMoney(moneyWithdraw);

                        em.getTransaction().begin();
                        em.persist(account);
                        em.getTransaction().commit();

                        System.out.println("Continue? Yes/No");
                        response = reader.readLine().toLowerCase();
                        if(response.equals("yes")){
                            performAction = true;
                            continue;
                        }
                        else {
                            performAction = false;
                            continue;
                        }
                }
                break;

            }
        } // End while
    }
}
