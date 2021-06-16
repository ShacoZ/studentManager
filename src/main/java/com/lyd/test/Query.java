package com.lyd.test;

import com.lyd.bean.Student;
import com.lyd.bean.User;
import com.lyd.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Query extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String name = req.getParameter("name");
        String sql = "select * from stu where name='" + name + "' and t_id='" + user.getId() +"'";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            ArrayList<Student> students = new ArrayList<>();
            while (rs.next()){
                Student student = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("sex"), rs.getInt("age"));
                students.add(student);
            }

            session.setAttribute("stuList",students);
            session.setAttribute("msg","");
            req.getRequestDispatcher("main.jsp").forward(req,resp);
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
