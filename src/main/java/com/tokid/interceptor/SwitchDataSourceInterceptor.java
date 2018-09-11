package com.tokid.interceptor;

import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.ServiceException;
import com.tokid.dynamic.CDataSourceService;
import com.tokid.dynamic.DataSourceContextHolder;
import com.tokid.dynamic.DynamicDataSource;
import com.tokid.model.CDataSource;
import org.apache.shiro.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SwitchDataSourceInterceptor implements HandlerInterceptor {

    @Resource
    private DynamicDataSource dynamicDataSource;
    @Autowired
    private CDataSourceService dataSourceService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("切换到客户数据库--->client");
//        Integer dbId = UserLoginUtils.getDBID();
//        CDataSource cDataSource = dataSourceService.selectById(dbId);
//        if (cDataSource == null) {
//            throw new ServiceException("dataSource is null,please check your database");
//        }
//        String dbName = cDataSource.getDbName();
//        //判断是否已存在数据库，不存在则添加然后切换到客户数据库
//        if (!DynamicDataSource.datasourcePoolMap.containsKey(dbName))
//            dynamicDataSource.addDatasource(cDataSource);
//        DataSourceContextHolder.setDataSourceType(dbName);
//
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("切回主数据库 --->  master");
        DataSourceContextHolder.setDataSourceType(DynamicDataSource.MASTERDB);
    }
}
