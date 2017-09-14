package spring.exercise.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.entites.Picture;
import spring.exercise.repositories.PictureRepository;
import spring.exercise.services.api.PictureService;

@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }
}
