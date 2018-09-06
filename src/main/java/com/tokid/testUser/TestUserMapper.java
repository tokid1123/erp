package com.tokid.testUser;

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface TestUserMapper extends BaseMapper<TestUser> {

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;
}
