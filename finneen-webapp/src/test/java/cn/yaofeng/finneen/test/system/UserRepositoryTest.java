package cn.yaofeng.finneen.test.system;

import cn.yaofeng.finneen.secutiry.utils.SecUtils;
import cn.yaofeng.finneen.system.permission.entity.Permission;
import cn.yaofeng.finneen.system.permission.repository.PermissionRepository;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.resource.repository.ResourceRepository;
import cn.yaofeng.finneen.system.role.entity.Role;
import cn.yaofeng.finneen.system.role.repository.RoleRepository;
import cn.yaofeng.finneen.system.user.entity.User;
import cn.yaofeng.finneen.system.user.repository.UserRepository;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

/**
 * Created by Finneen on 2015/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    public void testSaveUser() {
        /*User user = new User();
        user.setUserName("管理员");
        user.setAccount("admin");*/

        User user = userRepository.findOne(1L);
        user.setPassword(SecUtils.encoderByMd5With32Bit("admin"));

        User result = userRepository.save(user);
        Assert.assertEquals(user, result);
    }

    @Test
    public void testSaveResource() {
        Resource resource = new Resource();
        resource.setResourceName("用户管理");
        resource.setIdentify("user");
        resource.setUrl("/user/list");

        resourceRepository.save(resource);
    }

    @Test
    public void testSavePermission() {
        Permission permission = new Permission();
        permission.setPermissionName("perm-2");

        //Permission permission = permissionRepository.findOne(4L);
        Resource resource = resourceRepository.findOne(1L);

        permission.addResource(resource);

        permissionRepository.save(permission);
    }

    @Test
    public void testDelResource() {
        Permission permission = permissionRepository.findOne(2L);

        Resource resource = resourceRepository.findOne(1L);


        permission.getResources().remove(resource);

        permissionRepository.save(permission);//解除关系
        resourceRepository.delete(1L);//删除数据
    }

    @Test
    public void testSaveRolePermission() {

        Permission permission = permissionRepository.findOne(4L);

        Role role = new Role();
        role.setRoleName("role");
        role.addPermission(permission);

        roleRepository.save(role);
    }

    @Test
    public void testSaveUserRole() {
        //user 为关系维护方

        User user = userRepository.findOne(1L);

        //roleRepository.save(role);

        Role r = roleRepository.findOne(1L);
        /*Role r = new Role();
        r.setRoleName("rol-1");*/

        //user.addRole(r);
        r.addUser(user);

        roleRepository.save(r);

    }


    @Test
    public void findUser() {
        User u = userRepository.findByAccount("admin");
        logger.info("user:{}", u);


        //logger.info("role:{}", ((Role)(u.getRoles().toArray()[0])).getRoleName());
    }

    @Test
    public void findPerm() {
        List<Permission> list = permissionRepository.findAll();
        logger.info("perms: {}" , ReflectionToStringBuilder.toString(list));
    }

    @Test
    public void findStringRoleFromUser() {
        User user = userRepository.findOne(1L);
        Set<Role> roles = user.getRoles();

        Set<String> roles_str = Sets.newHashSet(Collections2.transform(roles, new Function<Role, String>() {
            @Override
            public String apply(Role input) {
                return input.getRoleName();
            }
        }));

    }
}