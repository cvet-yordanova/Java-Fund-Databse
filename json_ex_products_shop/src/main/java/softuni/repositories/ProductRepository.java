package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entites.Product;
import softuni.entites.User;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    //@Query("SELECT p FROM Product AS p WHERE p.buyer.id = null ORDER BY p.price")
    List<Product> findAllByBuyerEqualsOrderByPrice(User user);
}
