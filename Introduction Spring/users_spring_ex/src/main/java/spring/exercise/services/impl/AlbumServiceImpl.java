package spring.exercise.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.entites.Album;
import spring.exercise.repositories.AlbumRepository;
import spring.exercise.services.api.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }
}
