package cn.yaofeng.finneen.system.user.repository;

import cn.yaofeng.finneen.system.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Finneen on 2015/1/8.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByAccount(String account);

}
