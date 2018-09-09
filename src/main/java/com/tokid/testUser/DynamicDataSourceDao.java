package com.tokid.testUser;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZHAOTING001 on 2017/2/23.
 */
@Repository
public interface DynamicDataSourceDao {

    String SELECT = "SELECT datasource_name AS datasourceName," +
            "  url AS url," +
            "  username AS username," +
            "  password AS password " +
            "FROM ting_admin_datasource WHERE status=0";

    @Select(SELECT)
    List<AdminDataSource> listAdminDataSource();

}
