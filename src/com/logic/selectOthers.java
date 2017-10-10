package com.logic;

import com.JavaBean.TdTrade;
import com.Uitl.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by decide on 2017/10/8.
 */
public class selectOthers implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String time = req.getParameter("time")+" 00:00:00";
        String type = req.getParameter("type");
        String user = req.getParameter("user");
        Session hibsession = HibernateUtils.getSession();
        Query query = hibsession.createQuery("from TdTrade where time = ?and userId = ?and canteentype = ?" );
        query.setDate(0,stringTOdate(time));
        query.setString(1,user);
       query.setString(2,type);
       List<TdTrade> tradelist =  query.list();
       hibsession.close();
       req.setAttribute("tradelist",tradelist);


        filterChain.doFilter(req,resp);
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
    public void destroy() {

    }
}
