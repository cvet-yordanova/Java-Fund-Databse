import entites.Diagnose;
import entites.Medicament;
import entites.Patient;
import entites.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Diagnose diagnose1 = new Diagnose("kintonemiq",null);
        Diagnose diagnose2 = new Diagnose("cough",null);
        Medicament medicament1 = new Medicament("Stoperan");
        Medicament medicament2 = new Medicament("Dulkolaks");
        Medicament medicament3 = new Medicament("Dufalak");
        Medicament medicament4 = new Medicament("Siropche");
        Visitation visitation1 = new Visitation(1l,LocalDate.now(),null);
        Visitation visitation2 = new Visitation(2l,LocalDate.now(),null);
        Set<Visitation> visitations1 = new HashSet<>();
        Set<Medicament> medicaments1 = new HashSet<>();
        Set<Diagnose> diagnoses1 = new HashSet<>();

        Set<Visitation> visitations2 = new HashSet<>();
        Set<Medicament> medicaments2 = new HashSet<>();
        Set<Diagnose> diagnoses2 = new HashSet<>();

        visitations1.add(visitation1);
        visitations2.add(visitation2);
        medicaments1.add(medicament1);
        medicaments1.add(medicament2);
        medicaments2.add(medicament3);
        medicaments2.add(medicament4);
        diagnoses1.add(diagnose1);
        diagnoses1.add(diagnose2);
        diagnoses2.add(diagnose2);

        Patient patient1 = new Patient("Gerasim","Gerasimov",
                "ul.Barselona Paris 34","gerasim@abv.bg",new Date(),"picture",true,visitations1,diagnoses1,medicaments1);
        Patient patient2 = new Patient("Marina","Ogretenova",
                "ul.madagaskar London 13","mar4etyy@gmail.com",new Date(),"picture",false,visitations2,diagnoses2,medicaments2);


        em.getTransaction().begin();
        em.persist(diagnose1);
        em.persist(diagnose2);
        em.persist(medicament1);
        em.persist(medicament2);
        em.persist(medicament3);
        em.persist(medicament4);
        em.persist(visitation1);
        em.persist(visitation2);
        em.persist(patient1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(patient2);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
