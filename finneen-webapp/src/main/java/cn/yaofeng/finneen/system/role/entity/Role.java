package cn.yaofeng.finneen.system.role.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;
import cn.yaofeng.finneen.system.permission.entity.Permission;
import cn.yaofeng.finneen.system.user.entity.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Finneen on 2015/1/10.
 */
@Entity
@Table(name = "t_sys_role")
public class Role extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String roleName;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_sys_role_perm", joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "perm_id"))
    private Set<Permission> permissions = new HashSet<Permission>();

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
