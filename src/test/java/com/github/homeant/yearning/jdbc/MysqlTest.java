package com.github.homeant.yearning.jdbc;

import com.alibaba.fastjson.JSON;
import lombok.extern.apachecommons.CommonsLog;
import org.testng.annotations.*;

import java.sql.*;

@CommonsLog
public class MysqlTest {

    private Connection conn;

    @BeforeTest
    public void init() throws SQLException {

        // 打开链接
        conn = DriverManager.getConnection("jdbc:mysql://172.16.0.115:3306/supplier?useSSL=false&characterEncoding=utf8&useCompress=true&serverTimezone=Asia/Shanghai", "app", "Yc)E7aqYU6)AjW");
    }

    @AfterTest
    public void al() throws SQLException {
        if(conn!=null) {
            conn.close();
        }
    }


    @Test
    public void catalogTest() throws SQLException {
        log.info("catalog:"+conn.getMetaData().getCatalogTerm());
        log.info("schema:"+conn.getMetaData().getSchemaTerm());
        log.info("procedure:"+conn.getMetaData().getProcedureTerm());
        ResultSet rs = conn.getMetaData().getCatalogs();
        while (rs.next()) {
            log.info(rs.getString(1));
        }
        // 完成后关闭
        rs.close();
    }

    @Test
    public void schemaTest() throws SQLException {
        ResultSet rs = conn.getMetaData().getSchemas("information_schema","%");
        while (rs.next()){
            log.info(rs);
        }
        rs.close();
        ResultSet resultSet = conn.getMetaData().getSchemas("supplier", "%");
        while (resultSet.next()){
            log.info(resultSet);
        }
    }

    @Test
    public void selectTest() throws SQLException {
        Statement statement = conn.createStatement();
        boolean flag =statement.execute("select * from iss_order limit 1");
        if(flag){
            ResultSet resultSet = statement.getResultSet();
            resultSet.getType();
            while (resultSet.next()){
                log.info("result:"+resultSet.getString(1));
            }
        }
    }


}
