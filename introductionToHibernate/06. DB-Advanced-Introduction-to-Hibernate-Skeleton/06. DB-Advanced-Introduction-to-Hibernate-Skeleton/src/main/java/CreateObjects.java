import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CreateObjects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee manager = (Employee) entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.id = 1")
                .getSingleResult();

        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address addressOne = new Address();
        addressOne.setTown(burgas);
        addressOne.setText("Mladost");

        Address addressTwo = new Address();
        addressTwo.setTown(burgas);
        addressTwo.setText("G.M. DImitrov");

        Address addressThree = new Address();
        addressThree.setTown(burgas);
        addressThree.setText("Liulin");

        Date date = new Date();

        Employee employeeOne =  new Employee();
        employeeOne.setFirstName("Atanas");
        employeeOne.setMiddleName("Topalov");
        employeeOne.setLastName("Petrov");
        employeeOne.setJobTitle("Java");
        employeeOne.setDepartment(training);
        employeeOne.setManager(manager);
        employeeOne.setHireDate(new Timestamp(date.getTime()));
        employeeOne.setSalary(new BigDecimal("43000000"));
        employeeOne.setAddress(addressOne);

        Employee employeeTwo =  new Employee();
        employeeTwo.setFirstName("Mitko");
        employeeTwo.setMiddleName("Krystev");
        employeeTwo.setLastName("Petrov");
        employeeTwo.setJobTitle("Java");
        employeeTwo.setDepartment(training);
        employeeTwo.setManager(manager);
        employeeTwo.setHireDate(new Timestamp(date.getTime()));
        employeeTwo.setSalary(new BigDecimal("67000000"));
        employeeTwo.setAddress(addressThree);

        Employee employeeThree =  new Employee();
        employeeThree.setFirstName("Konstantin");
        employeeThree.setMiddleName("Topalov");
        employeeThree.setLastName("Duichinski");
        employeeThree.setJobTitle("Java");
        employeeThree.setDepartment(training);
        employeeThree.setManager(manager);
        employeeThree.setHireDate(new Timestamp(date.getTime()));
        employeeThree.setSalary(new BigDecimal("2400000"));
        employeeThree.setAddress(addressOne);

        Employee employeeFour =  new Employee();
        employeeFour.setFirstName("Dimcho");
        employeeFour.setMiddleName("D");
        employeeFour.setLastName("Debelqnov");
        employeeFour.setJobTitle("Java");
        employeeFour.setDepartment(training);
        employeeFour.setManager(manager);
        employeeFour.setHireDate(new Timestamp(date.getTime()));
        employeeFour.setSalary(new BigDecimal("8900000"));
        employeeFour.setAddress(addressOne);

        Employee employeeFive =  new Employee();
        employeeFive.setFirstName("Hose");
        employeeFive.setMiddleName("T");
        employeeFive.setLastName("Rodriges");
        employeeFive.setJobTitle("Java");
        employeeFive.setDepartment(training);
        employeeFive.setManager(manager);
        employeeFive.setHireDate(new Timestamp(date.getTime()));
        employeeFive.setSalary(new BigDecimal("56000000"));
        employeeFive.setAddress(addressThree);

        entityManager.getTransaction().begin();

        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(addressOne);
        entityManager.persist(addressThree);

        entityManager.persist(employeeOne);
        entityManager.persist(employeeTwo);
        entityManager.persist(employeeThree);
        entityManager.persist(employeeFour);
        entityManager.persist(employeeFive);

        entityManager.getTransaction().commit();

        entityManager.close();;
        entityManagerFactory.close();

    }
}
