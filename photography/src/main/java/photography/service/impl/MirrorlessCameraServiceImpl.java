package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.entities.MirrorlessCamera;
import photography.repositories.MirrorlessCameraRepository;
import photography.service.api.MirrorlessCameraService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MirrorlessCameraServiceImpl implements MirrorlessCameraService {

    @Autowired
    private final MirrorlessCameraRepository mirrorlessCameraRepository;

    public MirrorlessCameraServiceImpl(MirrorlessCameraRepository mirrorlessCameraRepository) {
        this.mirrorlessCameraRepository = mirrorlessCameraRepository;
    }

    @Override
    public List<MirrorlessCamera> findAll() {
        return this.mirrorlessCameraRepository.findAll();
    }

    @Override
    public MirrorlessCamera findOne(Long aLong) {
        return this.mirrorlessCameraRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.mirrorlessCameraRepository.delete(aLong);
    }

    @Override
    public void delete(MirrorlessCamera entity) {
            this.mirrorlessCameraRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}