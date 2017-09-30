package com.logic;

import com.JavaBean.TdTrade;
import com.JavaBean.TdTradeByUser;
import com.JavaBean.TdUser;
import com.Uitl.HibernateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by decide on 2017/9/30.
 */
public class addusertable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemA = 0;
        int itemB = 0;

    String tablejson = req.getParameter("tablejson");
    String time = req.getParameter("time");
    String type = req.getParameter("type");
      TdUser user = (TdUser) req.getSession().getAttribute("USER");
        System.out.println(tablejson);
        System.out.println("======>"+time);
        time +=" 00:00:00";
        List<TdTrade> tradeList = new ArrayList<TdTrade>();

        JSONArray jsonArray = JSON.parseArray(tablejson);
        for (int i = 0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                TdTrade t = new TdTrade();
                t.setUserId(user.getId());
                t.setCanteentype(jsonObject.getString("canteentype"));
                t.setDishestype(type);
                t.setMembername(jsonObject.getString("membername"));
                t.setTime(stringTOdate(time));
                t.setEattype(jsonObject.getString("eattype"));
            System.out.println(jsonObject.getString("canteentype"));
                if("食堂一".equals(jsonObject.getString("canteentype"))){
                    itemA+=1;

                }else if("食堂二".equals(jsonObject.getString("canteentype"))){
                        itemB+=1;

            }
                tradeList.add(t);


        }

        TdTradeByUser t1 = new TdTradeByUser();
        t1.setCanteentype("食堂一");
        t1.setUserId(user.getId());
        t1.setTime(stringTOdate(time));
        TdTradeByUser t2 = new TdTradeByUser();
        t2.setCanteentype("食堂二");
        t2.setUserId(user.getId());
        t2.setTime(stringTOdate(time));
        if("套餐一".equals(type)){
        t1.setT1Count(itemA);
        t1.setT2Count(0);
        t2.setT1Count(itemB);
        t2.setT2Count(0);
        }else if("套餐二".equals(type)){
            t1.setT1Count(0);
            t1.setT2Count(itemA);
            t1.setT1Count(0);
            t1.setT2Count(itemB);

        }
        System.out.println("T1------>"+t1.toString());
        System.out.println("T2------>"+t2.toString());
        System.out.println("食堂一");


        Session s1 = HibernateUtils.getSession();
        Query q1 = s1.createQuery("from TdTradeByUser where userId = ? and time = ? and canteentype=?");
        q1.setInteger(0,user.getId());
        q1.setDate(1,stringTOdate(time));
        q1.setString(2,"食堂一");
        List<TdTradeByUser> ll =   q1.list();
        s1.clear();
      if(ll.size()>0){
        Transaction tt = s1.beginTransaction();
          s1.clear();

          s1.update(t1);

          s1.flush();

         tt.commit();

      }else  {
          Transaction tt = s1.beginTransaction();
          s1.clear();
    s1.save(t1);
          s1.flush();
          tt.commit();
      }
        s1.close();

      Session s2 = HibernateUtils.getSession();
      Query q2 = s2.createQuery("from TdTradeByUser where userId = ? and time = ? and canteentype=?");
        q2.setInteger(0,user.getId());
        q2.setDate(1,stringTOdate(time));
        q2.setString(2,"食堂二");
        List<TdTradeByUser> l2 =   q2.list();

        if(l2.size()>0){
       Transaction tt = s2.beginTransaction();
            s2.clear();
       s2.update(t2);
       s2.flush();
       tt.commit();


        }else  {
            Transaction tt = s2.beginTransaction();
            s2.clear();
            s2.save(t2);
            s2.flush();
            tt.commit();

        }
s2.close();


      //  List<TdTradeByUser> tbu = query.list();

//        if(tbu!=null&&tbu.size()>=2){
//            session.update(UA);
//            session.update(UB);
//
//        }else if(tbu!=null&&tbu.size()==1) {
//
//                if("???".equals(tbu.get(0).getCanteentype())){
//                        session.update(UA);
//                        session.save(UB);
//
//                }else if("???".equals(tbu.get(0).getCanteentype())){
//                        session.save(UA);
//                        session.update(UB);
//                }
//
//
//
//        }else if(tbu==null||tbu.size()==0){
//            session.save(UA);
//            session.save(UB);
//
//        }
  Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        for (TdTrade tt :tradeList){
            session.save(tt);

        }

        t.commit();
        session.close();

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
