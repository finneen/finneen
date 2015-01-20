package cn.yaofeng.finneen.system.resource.service;

import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Finneen on 2015/1/20.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findOne(Long id) {
        return resourceRepository.findOne(id);
    }

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> findByPid(Long pid) {
        Resource parent = new Resource();
        
        if (pid == null || pid == 0) {
            parent = resourceRepository.findOne(1L);
        } else {
            parent = resourceRepository.findOne(pid);
            
        }
        
        return resourceRepository.findResourcesByParent(parent);
    }
}
