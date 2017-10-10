package com.logic;

import com.JavaBean.TdUser;
import com.JavaBean.Tradeitemsta;
import com.JavaBean.Tradeitemstb;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by decide on 2017/9/30.
 */
public class selectcount extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String time = req.getParameter("time");
            String type = req.getParameter("type");
            String CanteenType = ((TdUser)req.getSession().getAttribute("USER")).getCanteentype();
        String jsonstr = "";
          if("食堂一".equals(type)){

              String hql =    hql = " from Tradeitemsta where time = ?";
        List<Tradeitemsta> tradelist = new ArrayList<Tradeitemsta>();
        Session session = HibernateUtils.getSession();

        Query query = session.createQuery(hql);
        query.setDate(0,stringTOdate(time+" 00:00:00"));
        tradelist  = query.list();
  jsonstr = JSON.toJSONString(tradelist);

          }else if("食堂二".equals(type)){
              String hql =    hql = " from Tradeitemstb where time = ?";
              List<Tradeitemstb> tradelist = new ArrayList<Tradeitemstb>();
              Session session = HibernateUtils.getSession();

              Query query = session.createQuery(hql);
              query.setDate(0,stringTOdate(time+" 00:00:00"));
              tradelist  = query.list();
              jsonstr = JSON.toJSONString(tradelist);


          }



           PrintWriter pw = resp.getWriter();
        System.out.println(jsonstr);
           pw.write(jsonstr);
           pw.flush();
           pw.close();
//            if("食堂一".equals(type)){
//
//            }else if("食堂二".equals(type)) {
//
//
//            }


//        Session session  = HibernateUtils.getSession();
//        Query query = session.createQuery("from TdTradeByUser  where time = ?and canteentype = ?");
//        query.setString(0,time);
//        query.setString(1,CanteenType);
//        List<TdTradeByUser> list = query.list();
//        String jsonstr = JSON.toJSONString(list);
//        System.out.println(jsonstr);
//        PrintWriter pw= resp.getWriter();
//        pw.write(jsonstr);
//        pw.flush();
//        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
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
}
