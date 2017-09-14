package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Lens;
import softuni.repository.LensRepository;
import softuni.services.api.LensService;

@Service
@Transactional
public class LensServiceImpl implements LensService{

    @Autowired
    private final LensRepository lensRepository;

    public LensServiceImpl(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    @Override
    public void save(Lens lens) {
        this.lensRepository.save(lens);
    }
}
