import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        RoomStatus roomStatus = new RoomStatus("occupied",null);
        RoomType roomType = new RoomType("apartment",null);
        BedType bedType = new BedType("Ultra Soft","dushek dormeo with puh from guski");
        Employee employee = new Employee("Alfredo","Fernandes","Reception service",null);
        Room room = new Room(1, roomType, bedType,1.23f, roomStatus,null);
        Customer customer = new Customer(1l,"Ahmed","Duran","08975778","emergency name","98789869",null);
        Payment payment = new Payment(LocalDate.now(),customer, LocalDate.now(),LocalDate.now(),3,new BigDecimal("300"),34.23f,new BigDecimal("100"),new BigDecimal("500"),null);

        em.getTransaction().begin();
        em.persist(roomStatus);
        em.persist(roomType);
        em.persist(bedType);
        em.persist(employee);
        em.persist(room);
        em.persist(customer);
        em.persist(payment);
        em.getTransaction().commit();
        em.close();
        emf.close();




    }
}
