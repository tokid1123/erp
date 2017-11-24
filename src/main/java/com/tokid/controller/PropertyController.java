package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 14:41
*/

import com.tokid.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

}
