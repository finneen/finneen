package cn.yaofeng.finneen.system.permission.service;

import cn.yaofeng.finneen.system.permission.entity.Permission;
import cn.yaofeng.finneen.system.permission.repository.PermissionRepository;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.role.entity.Role;
import cn.yaofeng.finneen.system.user.entity.User;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public Set<String> findPermissionsByUser(User user) {
        if(user == null) {
            return null;
        }

        Set<Role> roles = user.getRoles();
        Set<String> resource_str = null;

        for (Role role : roles) {
            Set<Permission> permissions = role.getPermissions();

            for (Permission permission : permissions) {
                Set<Resource> resources = permission.getResources();

                resource_str = Sets.newHashSet(Collections2.transform(resources, new Function<Resource, String>() {
                    @Override
                    public String apply(Resource input) {
                        return input.getUrl();
                    }
                }));
            }
        }
        return resource_str;
    }
}
