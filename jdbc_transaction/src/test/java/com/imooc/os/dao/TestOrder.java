package com.imooc.os.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// jdbc实现事务管理
public class TestOrder {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/os?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private String userName = "root";
    private String password = "123456";

    @Test
    public void addOrder() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into orders values('100002', '100004', 2, 2499, now(), null, null, '程明杨', '13576768787', '西安', '代发货')");
            statement.execute("update products set stock = stock - 2 where id = '100004'");
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


