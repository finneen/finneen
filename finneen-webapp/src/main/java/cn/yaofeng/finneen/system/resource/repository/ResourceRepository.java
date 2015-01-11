package cn.yaofeng.finneen.system.resource.repository;

import cn.yaofeng.finneen.system.resource.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Finneen on 2015/1/11.
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
