package com.lyd.test;

import com.lyd.bean.Student;
import com.lyd.util.DBUtil;
import com.lyd.bean.User;
import com.lyd.util.QueryUserAll;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        req.getRequestDispatcher("manager_login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn=null;
        Statement st = null;
        ResultSet rs = null;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            conn = DBUtil.getConn();
            st = conn.createStatement();
            String sql = "select * from user where username='" + username + "'";
            rs = st.executeQuery(sql);
            User user = new User();
            if (rs.next()){
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            HttpSession session = req.getSession();
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                session.setAttribute("user",user);  // 设置登录用户
                QueryUserAll queryUserAll = new QueryUserAll(); // 查询登录用户的所有的学生
                ArrayList<Student> students = queryUserAll.QueryStudent(user);
                session.setAttribute("stuList",students);
                session.setAttribute("msg","");
                req.getRequestDispatcher("content.jsp").forward(req,resp);
            } else {
                session.setAttribute("msg","用户名密码不正确！");
                req.getRequestDispatcher("manager_login.jsp").forward(req,resp);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn,st,rs);
        }
    }
}
