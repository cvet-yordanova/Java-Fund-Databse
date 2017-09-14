package student_system.service.api;


import student_system.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void deleteStudent(Student student);
    void saveStudent(Student student);
}
