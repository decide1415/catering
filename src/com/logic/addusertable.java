package com.logic;

import com.JavaBean.TdTrade;
import com.JavaBean.TdTradeByUser;
import com.JavaBean.TdUser;
import com.Uitl.HibernateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
//  int canteen1count = 0;
//        int canteen2count = 0;
        int TC1byST1 = 0;
        int TC1byST2 = 0;int TC2byST1 = 0;int TC2byST2 = 0;


    String tablejsonTC1 = req.getParameter("tablejsonTC1");
        String tablejsonTC2 = req.getParameter("tablejsonTC2");
        System.out.println(tablejsonTC1);
        System.out.println(tablejsonTC2);
        TdUser user = (TdUser)req.getSession().getAttribute("USER");
    String time = req.getParameter("time");time +=" 00:00:00";
    List<TdTrade> tradeList  =new ArrayList<TdTrade>();
        List<TdTrade> tradeListA  =new ArrayList<TdTrade>();
     JSONArray TC1arr = JSON.parseArray(tablejsonTC1);
        JSONArray TC2arr = JSON.parseArray(tablejsonTC2);
        for(int i = 0;i<TC1arr.size();i++){
            JSONObject jobj = TC1arr.getJSONObject(i);
            TdTrade t = new TdTrade();
            t.setTime(stringTOdate(time));
            t.setUserId(user.getId());
            t.setMembername(jobj.getString("membername"));
            t.setEattype(jobj.getString("eattype"));
            t.setDishestype(jobj.getString("subtype"));
            t.setCanteentype(jobj.getString("canteentype"));
            tradeList.add(t);
            if("食堂一".equals(jobj.getString("canteentype"))){
                TC1byST1+=1;
            }else if("食堂二".equals(jobj.getString("canteentype"))){
                    TC1byST2+=1;

            }
        }
        for(int i = 0;i<TC2arr.size();i++){
            JSONObject jobj = TC2arr.getJSONObject(i);
            TdTrade t = new TdTrade();
            t.setTime(stringTOdate(time));
            t.setUserId(user.getId());
            t.setMembername(jobj.getString("membername"));
            t.setEattype(jobj.getString("eattype"));
            t.setDishestype(jobj.getString("subtype"));
            t.setCanteentype(jobj.getString("canteentype"));
            tradeListA.add(t);
            if("食堂一".equals(jobj.getString("canteentype"))){
                TC2byST1+=1;
            }else if("食堂二".equals(jobj.getString("canteentype"))){
                TC2byST2+=1;

            }
        }
        Session session = HibernateUtils.getSession();

       for (TdTrade t :tradeList){
           Transaction transaction = session.beginTransaction();
           session.save(t);
           session.flush();

           transaction.commit();
           session.clear();
       }

       session.close();
       Session se = HibernateUtils.getSession();

       for (TdTrade tt:tradeListA){
           Transaction t1 = se.beginTransaction();
           se.save(tt);
           se.flush();

           t1.commit();
           se.clear();
       }

       se.close();
        TdTradeByUser ttbu = new TdTradeByUser();
        ttbu.setTime(stringTOdate(time));
        ttbu.setUserId(user.getId());
        ttbu.setUserName(user.getName());
        ttbu.setCotTcAbySta(TC1byST1);
        ttbu.setCotTcAbyStb(TC1byST2);
        ttbu.setCotTcBbySta(TC2byST1);
        ttbu.setCotTcBbyStb(TC2byST2);
        Session session1 = HibernateUtils.getSession();
        Transaction transaction1 = session1.beginTransaction();
        session1.save(ttbu);
        transaction1.commit();
        session1.close();
    //String type = req.getParameter("type");
//    TdUser user = (TdUser)req.getSession().getAttribute("USER");
//    List<TdTrade> tradeList = new ArrayList<TdTrade>();
//    JSONArray jsonArray = JSON.parseArray(tablejson);
//      for (int a = 0;a<jsonArray.size();a++){
//            JSONObject jobj = jsonArray.getJSONObject(a);
//          TdTrade t = new TdTrade();
//                t.setUserId(user.getId());
//                t.setCanteentype(jobj.getString("canteentype"));
//                t.setDishestype(type);
//                t.setMembername(jobj.getString("membername"));
//                t.setTime(stringTOdate(time));
//                t.setEattype(jobj.getString("eattype"));
//                tradeList.add(t);
//                if("食堂一".equals(jobj.getString("canteentype"))){
//
//                    canteen1count+=1;
//                }else if("食堂二".equals(jobj.getString("canteentype"))){
//
//                    canteen2count+=1;
//                }
//
//      }
//      Session session  = HibernateUtils.getSession();
//        Transaction t1 = session.beginTransaction();
//        for(TdTrade t:tradeList){
//             session.save(t);
//
//
//        }
//        session.flush();
//        t1.commit();
//        session.close();
//
//        TdTradeByUser ttbu = new TdTradeByUser();
//        ttbu.setTime(stringTOdate(time));
//        ttbu.setUserId(user.getId());
//        ttbu.setCanteen1(canteen1count);
//        ttbu.setCanteen2(canteen2count);
//        ttbu.setDishestype(type);
//
//        Session session1 = HibernateUtils.getSession();
//        Transaction transaction = session1.beginTransaction();
//        session1.save(ttbu);
//        session1.flush();
//        transaction.commit();
//        session1.close();
//      TdUser user = (TdUser) req.getSession().getAttribute("USER");
//        System.out.println(tablejson);
//        System.out.println("======>"+time);
//        time +=" 00:00:00";
//        List<TdTrade> tradeList = new ArrayList<TdTrade>();
//
//        JSONArray jsonArray = JSON.parseArray(tablejson);
//        for (int i = 0;i<jsonArray.size();i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                TdTrade t = new TdTrade();
//                t.setUserId(user.getId());
//                t.setCanteentype(jsonObject.getString("canteentype"));
//                t.setDishestype(type);
//                t.setMembername(jsonObject.getString("membername"));
//                t.setTime(stringTOdate(time));
//                t.setEattype(jsonObject.getString("eattype"));
//            System.out.println(jsonObject.getString("canteentype"));
//                if("食堂一".equals(jsonObject.getString("canteentype"))){
//                    itemA+=1;
//
//                }else if("食堂二".equals(jsonObject.getString("canteentype"))){
//                        itemB+=1;
//
//            }
//                tradeList.add(t);
//
//
//        }
//
//        TdTradeByUser t1 = new TdTradeByUser();
//        t1.setCanteentype("食堂一");
//        t1.setUserId(user.getId());
//        t1.setTime(stringTOdate(time));
//        TdTradeByUser t2 = new TdTradeByUser();
//        t2.setCanteentype("食堂二");
//        t2.setUserId(user.getId());
//        t2.setTime(stringTOdate(time));
//        if("套餐一".equals(type)){
//        t1.setT1Count(itemA);
//        t1.setT2Count(0);
//        t2.setT1Count(itemB);
//        t2.setT2Count(0);
//        }else if("套餐二".equals(type)){
//            t1.setT1Count(0);
//            t1.setT2Count(itemA);
//            t1.setT1Count(0);
//            t1.setT2Count(itemB);
//
//        }
//        System.out.println("T1------>"+t1.toString());
//        System.out.println("T2------>"+t2.toString());
//        System.out.println("食堂一");
//
//
//        Session s1 = HibernateUtils.getSession();
//        Query q1 = s1.createQuery("from TdTradeByUser where userId = ? and time = ? and canteentype=?");
//        q1.setInteger(0,user.getId());
//        q1.setDate(1,stringTOdate(time));
//        q1.setString(2,"食堂一");
//        List<TdTradeByUser> ll =   q1.list();
//        s1.clear();
//      if(ll.size()>0){
//        Transaction tt = s1.beginTransaction();
//          s1.clear();
//
//          s1.update(t1);
//
//          s1.flush();
//
//         tt.commit();
//
//      }else  {
//          Transaction tt = s1.beginTransaction();
//          s1.clear();
//    s1.save(t1);
//          s1.flush();
//          tt.commit();
//      }
//        s1.close();
//
//      Session s2 = HibernateUtils.getSession();
//      Query q2 = s2.createQuery("from TdTradeByUser where userId = ? and time = ? and canteentype=?");
//        q2.setInteger(0,user.getId());
//        q2.setDate(1,stringTOdate(time));
//        q2.setString(2,"食堂二");
//        List<TdTradeByUser> l2 =   q2.list();
//
//        if(l2.size()>0){
//       Transaction tt = s2.beginTransaction();
//            s2.clear();
//       s2.update(t2);
//       s2.flush();
//       tt.commit();
//
//
//        }else  {
//            Transaction tt = s2.beginTransaction();
//            s2.clear();
//            s2.save(t2);
//            s2.flush();
//            tt.commit();
//
//        }
//s2.close();
//
//
//      //  List<TdTradeByUser> tbu = query.list();
//
////        if(tbu!=null&&tbu.size()>=2){
////            session.update(UA);
////            session.update(UB);
////
////        }else if(tbu!=null&&tbu.size()==1) {
////
////                if("???".equals(tbu.get(0).getCanteentype())){
////                        session.update(UA);
////                        session.save(UB);
////
////                }else if("???".equals(tbu.get(0).getCanteentype())){
////                        session.save(UA);
////                        session.update(UB);
////                }
////
////
////
////        }else if(tbu==null||tbu.size()==0){
////            session.save(UA);
////            session.save(UB);
////
////        }
//  Session session = HibernateUtils.getSession();
//        Transaction t = session.beginTransaction();
//        for (TdTrade tt :tradeList){
//            session.save(tt);
//
//        }
//
//        t.commit();
//        session.close();

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
