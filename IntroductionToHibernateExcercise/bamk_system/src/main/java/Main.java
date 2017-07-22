import entites.Account;
import entites.BasicAccount;
import entites.CheckingAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Account account1 = new CheckingAccount(1l,new BigDecimal("100"),10d);
        Account account2 = new CheckingAccount(2l,new BigDecimal("200"),20d);

        em.getTransaction().begin();
//        em.persist(account1);
//        em.persist(account2);

        account1.depositMoney(new BigDecimal("5"));

        Account a = em.find(BasicAccount.class,1l);
        a.depositMoney(new BigDecimal("10"));
        em.persist(a);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
