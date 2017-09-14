package student_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_system.entities.Homework;
import student_system.repository.HomeworkRepository;
import student_system.service.api.HomeworkService;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService{

    @Autowired
    private final HomeworkRepository homeworkRepository;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }


    @Override
    public List<Homework> findAll() {
        return homeworkRepository.findAll();
    }

    @Override
    public void deleteHomework(Homework homework) {
        homeworkRepository.delete(homework);
    }

    @Override
    public void saveHomework(Homework homework) {
            homeworkRepository.save(homework);
    }
}
