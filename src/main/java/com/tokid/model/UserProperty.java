package com.tokid.model;
/*
* @Description: TODO
* @author king
* @date 2017/11/15 15:17
*/

import com.tokid.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="user_property")
public class UserProperty extends BaseModel {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long propertyId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
