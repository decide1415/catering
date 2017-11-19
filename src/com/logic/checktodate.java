package com.logic;

import com.Uitl.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by decide on 2017/10/13.
 */
public class checktodate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String time =   req.getParameter("time")+" 00:00:00";
//      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//      String thistime =  df.format(new Date());// new Date()为获取当前系统时间
        //select *  FROM td_dishes where '2017-10-14' > DATE_FORMAT(NOW(),'%Y-%m-%d')
//2002-10-08 14:55:38
        String is = "F";
        Session session = HibernateUtils.getSession();
        Query query  = session.createQuery("from TdDishes where time = ?");
        query.setDate(0,stringTOdate(time));
        if(query.list().size()>0){
            is = "T";

        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(is);
        printWriter.flush();
        printWriter.close();



    }

    private java.sql.Date stringTOdate(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        java.util.Date d = new java.util.Date();
        try {
            d=  sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(d.getTime());
    }


}
