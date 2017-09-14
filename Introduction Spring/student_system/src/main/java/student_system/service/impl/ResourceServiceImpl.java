package student_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_system.entities.Resource;
import student_system.repository.ResourceRepository;
import student_system.service.api.ResourceService;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public void deleteResource(Resource resource) {
            resourceRepository.delete(resource);
    }

    @Override
    public void saveResource(Resource resource) {
            resourceRepository.save(resource);
    }
}
