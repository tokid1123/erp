package com.tokid.testUser;

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestUserService extends BaseService<TestUser, Long> {

    @Autowired
    private TestUserMapper testUserMapper;

    public List<TestUser> getList(Map<String, Object> map) throws ServiceException {
        List<TestUser> list = testUserMapper.selectAll();
        return list;
    }
}
