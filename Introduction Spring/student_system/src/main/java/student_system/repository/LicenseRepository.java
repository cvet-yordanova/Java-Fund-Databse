package student_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_system.entities.License;

import javax.persistence.Entity;
import javax.persistence.Table;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
}
