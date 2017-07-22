import entities.BankAccount;
import entities.BasicBillingDetail;
import entities.CreditCard;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("PersistenceUnit");
        emf.close();

    }
}
