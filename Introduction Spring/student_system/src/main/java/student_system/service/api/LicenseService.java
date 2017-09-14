package student_system.service.api;


import student_system.entities.Course;
import student_system.entities.License;

import java.util.List;

public interface LicenseService {
    List<License> findAll();
    void deleteLicense(License license);
    void saveLicense(License license);
}
