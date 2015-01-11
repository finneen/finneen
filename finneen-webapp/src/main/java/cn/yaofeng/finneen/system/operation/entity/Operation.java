package cn.yaofeng.finneen.system.operation.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Finneen on 2015/1/11.
 */
@Entity
@Table(name = "t_operation")
public class Operation extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String operationName;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
