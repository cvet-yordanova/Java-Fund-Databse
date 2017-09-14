package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Supplier;
import softuni.models.view_models.SupplierViewDto;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long>{
    List<Supplier> findAllByUsesImportedParts(Boolean usesImportedParts);
}