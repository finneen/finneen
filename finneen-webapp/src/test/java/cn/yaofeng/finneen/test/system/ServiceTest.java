package cn.yaofeng.finneen.test.system;

import cn.yaofeng.finneen.core.log.BaseLogger;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.resource.service.ResourceService;
import cn.yaofeng.finneen.system.user.service.UserService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Finneen on 2015/1/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ServiceTest extends BaseLogger {
    
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;
    
    @Test
    public void testResource() {
        List<Resource> resourceList = resourceService.findByPid(null);
        logger.info("{}", resourceList);
    }
}
