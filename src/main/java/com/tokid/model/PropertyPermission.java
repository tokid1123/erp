package com.tokid.model;
/*
* @Description:
* @author king
* @date 2017/11/15 15:19
*/

import com.tokid.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="property_permission")
public class PropertyPermission extends BaseModel{

    private static final long serialVersionUID = 1L;

    private Long propertyId;

    private Long permissionId;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
