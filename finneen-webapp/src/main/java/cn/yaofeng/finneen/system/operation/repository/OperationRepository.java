package cn.yaofeng.finneen.system.operation.repository;

import cn.yaofeng.finneen.system.operation.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Finneen on 2015/1/11.
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
