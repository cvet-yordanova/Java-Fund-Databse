package Model.dao.api;

import Model.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShampooDao extends JpaRepository<BasicShampoo,Long>{

}
