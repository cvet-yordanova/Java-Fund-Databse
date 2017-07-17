import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class latest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Project> projects = entityManager.createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC")
                .setMaxResults(10)
                .getResultList();

        projects
                .stream()
                .sorted((a,b) -> a.getName().compareTo(b.getName()))
                .forEach(a -> {
                    System.out.println("Name: "+a.getName());
                    System.out.println("Description: "+a.getDescription());
                    System.out.println("Start Data: "+(new SimpleDateFormat("yyyy\\MM\\dd").format(a.getStartDate())));
                    if(a.getEndDate() != null ) {
                        System.out.println("Start Data: " + (new SimpleDateFormat("yyyy\\MM\\dd").format(a.getEndDate())));
                    }
                    else {
                        System.out.println("Start Data: null");
                    }
                    System.out.println("---------");
                } );

        entityManager.close();
        entityManagerFactory.close();
    }
}
