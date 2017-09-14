package photography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photography.entities.DSLRCamera;
import photography.repositories.DSLRCameraRepository;
import photography.service.api.DSLRCameraService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DSLRCameraServiceImpl implements DSLRCameraService {

    @Autowired
    private final DSLRCameraRepository dSLRCameraRepository;

    public DSLRCameraServiceImpl(DSLRCameraRepository dSLRCameraRepository) {
        this.dSLRCameraRepository = dSLRCameraRepository;
    }

    @Override
    public List<DSLRCamera> findAll() {
        return this.dSLRCameraRepository.findAll();
    }

    @Override
    public DSLRCamera findOne(Long aLong) {
        return this.dSLRCameraRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.dSLRCameraRepository.delete(aLong);
    }

    @Override
    public void delete(DSLRCamera entity) {
            this.dSLRCameraRepository.delete(entity);
    }

    //--------------------------------------------------------------------
}