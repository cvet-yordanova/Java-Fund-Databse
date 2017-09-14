package student_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_system.entities.License;
import student_system.repository.LicenseRepository;
import student_system.service.api.LicenseService;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService{

    @Autowired
    private final LicenseRepository licenseRepository;

    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }


    @Override
    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    @Override
    public void deleteLicense(License license) {
            licenseRepository.delete(license);
    }

    @Override
    public void saveLicense(License license) {
        licenseRepository.save(license);
    }
}
