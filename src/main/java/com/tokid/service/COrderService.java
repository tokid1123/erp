package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:21
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.COrderMapper;
import com.tokid.model.COrder;
import org.springframework.beans.factory.annotation.Autowired;

public class COrderService extends BaseService<COrder, Long> {

    @Autowired
    private COrderMapper cOrderMapper;

}
