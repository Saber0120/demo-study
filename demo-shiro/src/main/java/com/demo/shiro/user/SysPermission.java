package com.demo.shiro.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sheng on 2018/6/12.
 */
@Entity
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 2393102700179159538L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;// 名称

    @Column(columnDefinition = "enum('menu', 'button')")
    private String resourceType;// 资源类型(menu|button)

    private String url;// 资源路径

    private String permission;// 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private Long parentId;// 父编号

    private String parentIds;//  父编号列表

    private Boolean available = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
