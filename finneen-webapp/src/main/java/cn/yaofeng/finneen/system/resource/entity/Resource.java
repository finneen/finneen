package cn.yaofeng.finneen.system.resource.entity;

import cn.yaofeng.finneen.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Finneen on 2015/1/11.
 */
@Entity
@Table(name = "t_sys_resource")
public class Resource extends BaseEntity<Long> {

    /**
     * 资源名称，非空唯一
     */
    @Column(nullable = false, unique = true)
    private String resourceName;

    /**
     * 资源标识
     */
    private String identify;

    /**
     * 资源对应url
     */
    private String url;

    /**
     * 资源对应父id
     */
    private String pid;

    /**
     * 对资源的描述
     */
    private Integer description;

    /**
     * 资源类型：
     * <P>1:menu</P>
     * <p>2:button</p>
     */
    private Short type;

    /**
     * 排序，数字越小，排名越高
     */
    private Integer sort;

    /**
     * 资源对应图标
     */
    private String icon;

    /**
     * 资源的状态
     * <p>1:显示</p>
     * <p>2:不显示</p>
     * <p>3:删除</p>
     */
    private Integer state;


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
