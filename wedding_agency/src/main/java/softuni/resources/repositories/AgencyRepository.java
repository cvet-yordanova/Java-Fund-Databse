package softuni.resources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.dto.export_agencies_json.ExportAgenciesJsonDto;
import softuni.entities.Agency;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Long>{
    Agency findByName(String name);

    @Query("SELECT new softuni.dto.export_agencies_json.ExportAgenciesJsonDto(name, employeesCount, town) FROM Agency a ORDER BY a.employeesCount DESC, a.name")
    List<ExportAgenciesJsonDto> findAllAgenciesOrderedByEmployeesCount();

    @Query(value = "SELECT a.*\n" +
            "FROM weddings w\n" +
            "INNER JOIN agencies a\n" +
            "ON w.agency = a.id\n" +
            "GROUP BY a.id \n" +
            "HAVING COUNT(w.id >=2)", nativeQuery = true)
    List<Agency> agenciesWithEnoughWeddings();
}