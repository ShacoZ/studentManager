package com.lyd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBUtil {
    public static String db_url = "jdbc:mysql://localhost:3306/lyd?useUnicode=true&characterEncoding=utf-8";
    public static String user = "root";
    public static String password = "";

    public static Connection getConn(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(db_url,user,password);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn,Statement stmt){
        try{
            if(stmt!=null){
                stmt.close();
            }if(conn!=null){
                conn.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void close(Connection conn,Statement stmt,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }if(conn!=null){
                conn.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}