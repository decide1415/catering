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
public class login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("name");
        String userpassword = req.getParameter("password");
        Session session = HibernateUtils.getSession();
        Query query =  session.createQuery("from  TdUser where TdUser .name = ? and TdUser .password = ?");
        query.setString(0,username);
        query.setString(1,userpassword);
        List<TdUser> users = query.list();
        if(users!=null&&users.size()>=1){
            //用户查询结果不为空 切一至少一条记录

                req.getSession().setAttribute("USER",users.get(0));
                resp.sendRedirect("/Page/main.jsp");
        }
        else {


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
