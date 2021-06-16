package com.lyd.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.lyd.bean.*;


public class QueryUserAll {
    public ArrayList<Student> QueryStudent(User user) throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select * from stu where t_id='" + user.getId() + "'";
        conn = DBUtil.getConn();
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        ArrayList<Student> stuList = new ArrayList<>();
        while (rs.next()){
            Student student = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("sex"), rs.getInt("age"));
            stuList.add(student);
        }

        return stuList;
    }

}
