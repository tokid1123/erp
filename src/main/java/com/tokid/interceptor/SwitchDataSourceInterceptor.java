package com.tokid.interceptor;

import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.ServiceException;
import com.tokid.base.utils.MapUtils;
import com.tokid.base.utils.StringUtils;
import com.tokid.dynamic.CDataSourceService;
import com.tokid.dynamic.DataSourceContextHolder;
import com.tokid.dynamic.DynamicDataSource;
import com.tokid.model.CDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class SwitchDataSourceInterceptor implements HandlerInterceptor {

    @Resource
    private DynamicDataSource dynamicDataSource;
    @Autowired
    private CDataSourceService dataSourceService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("切换到客户数据库--->client");
        String dbId = UserLoginUtils.getDBID();
        if (StringUtils.isBlank(dbId)) {
            throw new ServiceException("amt_user表中db_id不能为空");
        }
//        cDataSource.setDbName("test");
//        cDataSource.setPassword("macroYEE123");
//        cDataSource.setUsername("sa");
//        cDataSource.setUrl("120.79.32.10:1433;DatabaseName=test");
//        cDataSource.setId(dbId);
        //用通用mapper的selectOne和selectId出问题
        Map<String, Object> map = MapUtils.newHashMap();
        map.put("id", dbId);
        List<Map<String, Object>> list = dataSourceService.getList(map);
        if (list == null || list.size() <=0) {
            throw new ServiceException("客户数据库为空，且确保客户数据库已创建");
        }
        CDataSource cDataSource = MapUtils.toObject(CDataSource.class, list.get(0));
        String dbName = cDataSource.getDbName();
        //判断是否已存在数据库，不存在则添加然后切换到客户数据库
        if (!DynamicDataSource.datasourcePoolMap.containsKey(dbName))
            dynamicDataSource.addDatasource(cDataSource);
        DataSourceContextHolder.setDataSourceType(dbName);

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
