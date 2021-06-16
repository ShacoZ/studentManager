package com.lyd.test;

import com.lyd.bean.Student;
import com.lyd.bean.User;
import com.lyd.util.DBUtil;
import com.lyd.util.QueryUserAll;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        HttpSession session = req.getSession();
        Student student = new Student(req.getParameter("name"), req.getParameter("sex"), Integer.parseInt(req.getParameter("age")));

        String sql = "INSERT INTO `stu` ( `name`, `sex`, `age`, `t_id`) VALUES (?,?,?,'1')";

        try {
            conn = DBUtil.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,student.getName());
            pst.setString(2,student.getSex());
            pst.setInt(3,student.getAge());
            int rows = pst.executeUpdate();
            if(rows>0){
                session.setAttribute("msg","增加成功");
            }else{
                session.setAttribute("msg","增加失败");
            }
            st = conn.createStatement();
            User user = (User) session.getAttribute("user");    // 读取登陆的用户
            QueryUserAll queryUserAll = new QueryUserAll(); // 查询登录用户的所有的学生
            ArrayList<Student> students = queryUserAll.QueryStudent(user);  // 返回学生列表
            session.setAttribute("stuList",students);   // 更新session中的学生列表

            req.getRequestDispatcher("main.jsp").forward(req,resp); // 重定向到主页

            pst.close();
            conn.close();

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
