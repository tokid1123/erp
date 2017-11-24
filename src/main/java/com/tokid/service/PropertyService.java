package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 14:42
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.PropertyMapper;
import com.tokid.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService extends BaseService<Property, Long>{

    @Autowired
    private PropertyMapper propertyMapper;
}
