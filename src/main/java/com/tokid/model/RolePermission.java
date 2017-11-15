package com.tokid.model;
/*
* @Description: TODO
* @author king
* @date 2017/11/15 15:19
*/

import com.tokid.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="role_permission")
public class RolePermission extends BaseModel{

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
