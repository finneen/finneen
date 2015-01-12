package cn.yaofeng.finneen.system.user.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;
import cn.yaofeng.finneen.system.role.entity.Role;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Finneen on 2015/1/8.
 */
@Entity
@Table(name = "t_sys_user")
public class User extends BaseEntity<Long>{

    @Column(nullable = false, unique = true)
    private String userName;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
