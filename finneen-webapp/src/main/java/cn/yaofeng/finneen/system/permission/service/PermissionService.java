package cn.yaofeng.finneen.system.permission.service;

import cn.yaofeng.finneen.system.permission.entity.Permission;
import cn.yaofeng.finneen.system.permission.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Finneen on 2015/1/12.
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
