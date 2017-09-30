package com.logic;

import com.JavaBean.TdUser;
import com.Uitl.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by decide on 2017/9/27.
 */
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String Password = req.getParameter("Password");
        System.out.println("------>name:"+name+"password:"+Password);
        Session session = HibernateUtils.getSession();

        Query query = session.createQuery("from TdUser  where name=? and password =?");
        query.setString(0, name);
        query.setString(1, Password);

        List<TdUser> userList = query.list();

        if (userList != null && userList.size() >0) {
            //查询到用户数据
            TdUser user = userList.get(0);
            req.getSession().setAttribute("USER", user);
            String type = user.getType();
            if("canteen".equals(type)){
                resp.sendRedirect("Page/canteenmain.jsp");
            }else if("user".equals(type)){
                resp.sendRedirect("Page/usermain.jsp");

            }
           // resp.sendRedirect("Page/main.jsp");

        } else {
            //未查询到用户数据处理
            req.setAttribute("ERR", true);
            resp.sendRedirect("login.jsp?errcode=ture");


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
