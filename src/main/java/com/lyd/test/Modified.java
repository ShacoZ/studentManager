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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modified extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        Student student = new Student(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("sex"), Integer.parseInt(req.getParameter("age")));
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        String sql = "update stu set name=?,sex=?,age=? where id=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConn();
            pst = conn.prepareStatement(sql);
            pst.setString(1,student.getName());
            pst.setString(2,student.getSex());
            pst.setInt(3,student.getAge());
            pst.setInt(4,student.getId());
            int rows = pst.executeUpdate();
            if(rows>0){
                session.setAttribute("msg","修改成功");
            }else{
                session.setAttribute("msg","修改失败");
            }
            QueryUserAll queryUserAll = new QueryUserAll();
            ArrayList<Student> students = queryUserAll.QueryStudent(user);
            session.setAttribute("stuList",students);
            req.getRequestDispatcher("main.jsp").forward(req,resp);

            pst.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
