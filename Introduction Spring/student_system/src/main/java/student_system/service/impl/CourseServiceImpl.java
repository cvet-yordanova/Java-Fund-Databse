package student_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_system.entities.Course;
import student_system.repository.CourseRepository;
import student_system.service.api.CourseService;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Course course) {
            courseRepository.delete(course);
    }

    @Override
    public void saveCourse(Course course) {
            courseRepository.save(course);
    }

    @Override
    public List<Course> findByStartDateBeforeAndEndDateAfter(Date date1, Date date2) {
        return courseRepository.findByStartDateBeforeAndEndDateAfter(date1, date2);
    }
}
