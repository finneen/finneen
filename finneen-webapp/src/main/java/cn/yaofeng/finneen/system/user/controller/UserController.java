package cn.yaofeng.finneen.system.user.controller;

import cn.yaofeng.finneen.system.user.entity.User;
import cn.yaofeng.finneen.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Finneen on 2015/1/12.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public Object list() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public User get(@PathVariable Long id) {
        return userService.findOne(id);
    }
}
