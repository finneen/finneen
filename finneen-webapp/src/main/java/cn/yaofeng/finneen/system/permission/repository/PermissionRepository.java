package cn.yaofeng.finneen.system.permission.repository;

import cn.yaofeng.finneen.system.permission.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Finneen on 2015/1/11.
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
