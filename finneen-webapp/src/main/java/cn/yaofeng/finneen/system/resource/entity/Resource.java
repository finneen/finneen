package cn.yaofeng.finneen.system.resource.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Finneen on 2015/1/11.
 */
@Entity
@Table(name = "t_resource")
public class Resource extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String resourceName;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
