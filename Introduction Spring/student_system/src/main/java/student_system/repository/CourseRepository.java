package student_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student_system.entities.Course;
import student_system.entities.Student;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByStartDateBeforeAndEndDateAfter(Date date1, Date date2);
}
