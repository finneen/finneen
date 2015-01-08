package cn.yaofeng.finneen.rest;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Finneen on 2015/1/8.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
