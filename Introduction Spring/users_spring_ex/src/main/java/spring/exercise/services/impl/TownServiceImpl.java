package spring.exercise.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.entites.Town;
import spring.exercise.repositories.TownRepository;
import spring.exercise.services.api.TownService;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void save(Town town) {
        townRepository.save(town);
    }
}
