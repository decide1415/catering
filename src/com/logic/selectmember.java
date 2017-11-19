package com.logic;

import com.JavaBean.TdMember;
import com.Uitl.HibernateUtils;
import com.alibaba.fastjson.JSON;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by decide on 2017/10/18.
 */
public class selectmember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String text = req.getParameter("text");
        Session session = HibernateUtils.getSession();
        Query query = session.createQuery("from TdMember where pyfist like ?");
        query.setString(0,text +"%");
        List<TdMember> members =  query.list();
        String json = JSON.toJSONString(members);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
