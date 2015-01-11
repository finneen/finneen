package cn.yaofeng.finneen.system.permission.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;
import cn.yaofeng.finneen.system.operation.entity.Operation;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.role.entity.Role;
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

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "permissions")
    private Set<Role> roles = new HashSet<Role>();

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
