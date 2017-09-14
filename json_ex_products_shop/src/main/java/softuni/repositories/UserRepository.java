package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entites.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT DISTINCT u FROM User AS u INNER JOIN u.boughtProducts AS p " +
            "WHERE u.boughtProducts.size >=1 AND p.buyer IS NOT null " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findUsersWithSoldProducts();

    @Query("SELECT DISTINCT u FROM User AS u INNER JOIN u.soldProducts AS p " +
            "WHERE u.soldProducts.size >=1 ORDER BY u.soldProducts.size " +
            "DESC, u.lastName")
    List<User> findUserWithSoldProductsOrder();
}
