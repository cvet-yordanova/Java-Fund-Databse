package student_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_system.entities.Student;
import student_system.repository.StudentRepository;
import student_system.service.api.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Student student) {
            studentRepository.delete(student);
    }

    @Override
    public void saveStudent(Student student) {
            studentRepository.save(student);
    }
}
