import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();

        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Antoich Peverell");
        dumbledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 10, 20);
        Date depositStart = calendar.getTime();
        dumbledore.setDepositStartDate(depositStart);
        calendar.set(2020, 10, 20);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(depositEnd);
        dumbledore.setDepositAmount(new BigDecimal("2000.24"));
        dumbledore.setDepositCharge(new BigDecimal("0.2"));
        dumbledore.setDepositExpired(false);

        em.getTransaction().begin();
        em.persist(dumbledore);
        em.getTransaction().commit();

        em.close();
        entityManagerFactory.close();

    }
}
