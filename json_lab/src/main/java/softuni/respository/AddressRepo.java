package softuni.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{
}
