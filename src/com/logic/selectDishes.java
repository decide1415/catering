package com.logic;

import com.JavaBean.TdDishes;
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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by decide on 2017/10/8.
 */
public class selectDishes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String time = req.getParameter("time")+" 00:00:00";
        Session session = HibernateUtils.getSession();
        Query query = session.createQuery("from TdDishes where time = ?");
        query.setDate(0,stringTOdate(time));
        List<TdDishes> dishesList = query.list();
        String jsonstr = JSON.toJSONString(dishesList);

        PrintWriter pw = resp.getWriter();
        pw.write(jsonstr);
        pw.flush();
        pw.close();
    }
    private Date stringTOdate(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        java.util.Date d = new java.util.Date();
        try {
            d=  sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(d.getTime());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
