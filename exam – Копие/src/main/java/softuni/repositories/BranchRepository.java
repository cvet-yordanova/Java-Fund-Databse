package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Branch;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long>{

    //@Query(value = "SELECT b FROM Branch as b WHERE b.name = :name")
    Branch findBranchByName(@Param("name") String name);
    @Query("SELECT b FROM Branch AS b WHERE b.products.size >=1")
    List<Branch> findBranchByCountProductsMoreThan1();
}