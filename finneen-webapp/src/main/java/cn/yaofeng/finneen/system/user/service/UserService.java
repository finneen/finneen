package cn.yaofeng.finneen.system.user.service;

import cn.yaofeng.finneen.system.user.entity.User;

import java.util.List;

/**
 * Created by Finneen on 2015/1/10.
 */
public interface UserService {

    public User save(User u);

    List<User> findAll();
}
