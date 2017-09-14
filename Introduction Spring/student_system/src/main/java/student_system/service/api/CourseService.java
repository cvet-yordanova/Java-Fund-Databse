package student_system.service.api;


import student_system.entities.Course;

import java.util.Date;
import java.util.List;

public interface CourseService {
    List<Course> findAll();
    void deleteCourse(Course course);
    void saveCourse(Course course);
    List<Course> findByStartDateBeforeAndEndDateAfter(Date date1, Date date2);
}
