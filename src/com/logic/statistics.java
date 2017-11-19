package com.logic;

import com.Uitl.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

/**
 * Created by decide on 2017/10/12.
 */
public class statistics extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CP:CP,
//                ZS:ZS,
//                TYPE:type,
//                USER:user,
//                TIME:time
        String CP = req.getParameter("CP");
        String ZS = req.getParameter("ZS");
        String TYPE = req.getParameter("TYPE");
        String USER = req.getParameter("USER");
        String TIME = req.getParameter("TIME")+" 00:00:00";
        System.out.println(CP+ZS+TYPE+USER+TIME);
        Session session = HibernateUtils.getSession();
        SQLQuery query = session.createSQLQuery("select count(a.eattype) AS item from (select * from td_trade where time = ?and user_id = ?and canteentype = ?)a WHERE dishestype = ? AND eattype = ?");
        query.setDate(0,stringTOdate(TIME));
        query.setString(1,USER);
        query.setString(2,TYPE);
        query.setString(3,CP);
        query.setString(4,ZS);
        String item =   query.list().get(0).toString();
        PrintWriter pw = resp.getWriter();
        pw.write(item);
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
}
