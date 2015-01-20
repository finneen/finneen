package cn.yaofeng.finneen.system.resource.service;

import cn.yaofeng.finneen.core.service.BaseService;
import cn.yaofeng.finneen.system.resource.entity.Resource;

import java.util.List;

/**
 * Created by Finneen on 2015/1/20.
 */
public interface ResourceService extends BaseService<Resource, Long> {
    
    public List<Resource> findByPid(Long pid);
    
}
