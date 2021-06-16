package com.lyd.test;

import com.lyd.bean.Student;
import com.lyd.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class Modify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        conn = DBUtil.getConn();
        try {
            st = conn.createStatement();
            sql = "select * from stu where id="+ id;
            rs = st.executeQuery(sql);
            if(rs.next()){
                session.setAttribute("student",new Student(rs.getInt("id"), rs.getString("name"), rs.getString("sex"), rs.getInt("age")));
            }
            req.getRequestDispatcher("modify.jsp").forward(req,resp);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn,st,rs);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
