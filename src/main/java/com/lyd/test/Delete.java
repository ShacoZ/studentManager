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

public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            String sql = "delete from stu where id=?";
            conn = DBUtil.getConn();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(req.getParameter("id")));
            int rows = pst.executeUpdate();
            if(rows>0){
                session.setAttribute("msg","删除成功");
            }else {
                session.setAttribute("msg","删除失败");
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
