package com.yc.annotion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: Maven_1
 * @description: wu
 * @author: oyx
 * @create: 2021-03-29 21:11
 */
@DBConnection(url = "jdbc:mysql://localhost:3306/test",driverClass = "com.mysql.jdbc.Driver")
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class c=Test.class;
        DBConnection dbc= (DBConnection) c.getDeclaredAnnotation(DBConnection.class);
        String driverClass= dbc.driverClass();
        String url=dbc.url();
        String user=dbc.user();
        String password=dbc.password();

        Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,user,password);
        System.out.println(con);
    }




}
