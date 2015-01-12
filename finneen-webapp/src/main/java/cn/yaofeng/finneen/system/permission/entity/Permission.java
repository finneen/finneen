package cn.yaofeng.finneen.system.permission.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Finneen on 2015/1/11.
 */
@Entity
@Table(name = "t_sys_perm")
public class Permission extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String permissionName;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "t_sys_perm_res", joinColumns = {@JoinColumn(name = "perm_id")},
        inverseJoinColumns = {@JoinColumn(name = "res_id")})
    private Set<Resource> resources = new HashSet<Resource>();

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
