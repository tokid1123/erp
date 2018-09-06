package com.tokid.testUser;

import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.service.BaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class KUserService extends BaseService<KUser, Long> {


    public Object login(KUser user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        subject.login(token); // 登陆
        return Result.createSuccessResultForm(selectOne(user), ResultEnum.SUCCESS);
    }
}
