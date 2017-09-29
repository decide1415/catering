package com.logic;

import com.JavaBean.TdDishes;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by decide on 2017/9/29.
 */
public class addDishesTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String tablejson =  req.getParameter("tablejson");
      List<TdDishes> tablelist = new ArrayList<TdDishes>();
        JSONArray jsonArray = JSON.parseArray(tablejson);
            for (int i = 0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                TdDishes d = new TdDishes();
                System.out.println(jsonObject.getString("canteentime"));
                    d.setName(jsonObject.getString("canteenname"));
                    d.setRemarks(jsonObject.getString("canteenremarks"));
                    d.setTime(Timestamp.valueOf(jsonObject.getString("canteentime")+" 00:00:00"));
               tablelist.add(d);

            }
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
       for (TdDishes tdDishes:tablelist){
           session.save(tdDishes);

       }

       transaction.commit();
        session.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
