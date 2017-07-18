import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RemoveTowns {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName = reader.readLine();

        Query addressQuery = entityManager.createQuery("SELECT a FROM Address  AS a " +
                "WHERE a.town.name = :townName");
        addressQuery.setParameter("townName",townName);
        List<Address> addresses = addressQuery.getResultList();
        List<Integer> addresseseId = new ArrayList<>();
        for (Address address : addresses) {
            addresseseId.add(address.getId());
        }

        Query updateEmployees = entityManager.createQuery("UPDATE Employee AS e SET e.address = null WHERE e.address.id  in :ids");
        updateEmployees.setParameter("ids",addresseseId);

        Query deleteAddresses = entityManager.createQuery("DELETE FROM Address WHERE id IN :addressesId");
        deleteAddresses.setParameter("addressesId",addresseseId);

        Query deleteTowns = entityManager.createQuery("DELETE FROM Town WHERE name = :townName");
        deleteTowns.setParameter("townName",townName);


        entityManager.getTransaction().begin();
        updateEmployees.executeUpdate();
        int deletedAddresses = deleteAddresses.executeUpdate();
        deleteTowns.executeUpdate();
        entityManager.getTransaction().commit();

        System.out.println(deletedAddresses +" addresses were deleted.");

        entityManager.close();
        entityManagerFactory.close();

    }

}
