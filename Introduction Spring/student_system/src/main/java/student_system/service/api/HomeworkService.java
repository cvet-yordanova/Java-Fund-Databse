package student_system.service.api;


import student_system.entities.Homework;

import java.util.List;

public interface HomeworkService {
    List<Homework> findAll();
    void deleteHomework(Homework homework);
    void saveHomework(Homework homework);
}
