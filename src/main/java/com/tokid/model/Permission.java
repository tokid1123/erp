package com.tokid.model;
/*
* @Description: TODO
* @author king
* @date 2017/11/15 15:14
*/

import javax.persistence.Table;

@Table(name="permission")
public class Permission {

    private static final long serialVersionUID = 1L;

    private String resourceType;//资源类型{button, menu}
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

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
}
