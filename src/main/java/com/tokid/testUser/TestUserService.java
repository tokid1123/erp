package com.tokid.testUser;

import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.model.CUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
