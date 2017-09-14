package student_system.service.api;


import student_system.entities.Resource;

import java.util.List;

public interface ResourceService
{
    List<Resource> findAll();
    void deleteResource(Resource resource);
    void saveResource(Resource resource);
}
