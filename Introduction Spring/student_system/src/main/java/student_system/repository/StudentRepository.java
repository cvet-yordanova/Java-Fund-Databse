package student_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_system.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
