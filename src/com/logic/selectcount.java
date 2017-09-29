package com.logic;

import com.JavaBean.TdTradeByUser;
import com.JavaBean.TdUser;
import com.Uitl.HibernateUtils;
import com.alibaba.fastjson.JSON;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.stat.SessionStatistics;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by decide on 2017/9/30.
 */
public class selectcount extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String time = req.getParameter("time");
            String CanteenType = ((TdUser)req.getSession().getAttribute("USER")).getCanteentype();
        Session session  = HibernateUtils.getSession();
        Query query = session.createQuery("from TdTradeByUser  where time = ?and canteentype = ?");
        query.setString(0,time);
        query.setString(1,CanteenType);
        List<TdTradeByUser> list = query.list();
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        PrintWriter pw= resp.getWriter();
        pw.write(jsonstr);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
