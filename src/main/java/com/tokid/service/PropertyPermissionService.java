package com.tokid.service;
/*
* @Description:
* @author king
* @date 2017/11/24 14:44
*/

import com.tokid.base.service.BaseService;
import com.tokid.model.PropertyPermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropertyPermissionService extends BaseService<PropertyPermission, Long> {

    @Transactional
    public Integer saveList(Long propertyId, List<PropertyPermission> list) {
        PropertyPermission propertyPermission = new PropertyPermission();
        propertyPermission.setPropertyId(propertyId);
        List<PropertyPermission> selectList = this.select(propertyPermission);
        if (selectList != null && selectList.size() > 0) {
            this.deleteList(selectList);
        }
        for (PropertyPermission permission : list) {
            permission.setPropertyId(propertyId);
        }
        return this.insertList(list);
    }

}
