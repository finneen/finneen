package cn.yaofeng.finneen.test.system;

import cn.yaofeng.finneen.system.permission.entity.Permission;
import cn.yaofeng.finneen.system.permission.repository.PermissionRepository;
import cn.yaofeng.finneen.system.role.entity.Role;
import cn.yaofeng.finneen.system.role.repository.RoleRepository;
import cn.yaofeng.finneen.system.user.entity.User;
import cn.yaofeng.finneen.system.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("admin");

        User result = userRepository.save(user);
        Assert.assertEquals(user, result);
    }

    @Test
    public void testSavePermission() {
        Permission permission = new Permission();
        permission.setPermissionName("perm");

        permissionRepository.save(permission);
    }

    @Test
    public void testSaveRolePermission() {

        Permission permission = permissionRepository.findOne(1L);

        Role role = new Role();
        role.setRoleName("role");
        role.addPermission(permission);

        roleRepository.save(role);
    }

    @Test
    public void testSaveUserRole() {
        //user 为关系维护方

        //User user = userRepository.findOne(1L);
        User user = new User();
        user.setUserName("finneen");

        //roleRepository.save(role);

        Role r = roleRepository.findOne(1L);

        user.addRole(r);
        userRepository.save(user);

    }


    @Test
    public void findUser() {
        User u = userRepository.findOne(1L);
        logger.info("user:{}", u);


        logger.info("role:{}", ((Role)(u.getRoles().toArray()[0])).getRoleName());
    }
}
