package com.JavaBean;

import java.sql.Date;

/**
 * Created by decide on 2017/9/30.
 */
public class TdTrade {
    private int userId;
    private String membername;
    private String dishestype;
    private Date time;
    private String canteentype;
    private String eattype;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getDishestype() {
        return dishestype;
    }

    public void setDishestype(String dishestype) {
        this.dishestype = dishestype;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCanteentype() {
        return canteentype;
    }

    public void setCanteentype(String canteentype) {
        this.canteentype = canteentype;
    }

    public String getEattype() {
        return eattype;
    }

    public void setEattype(String eattype) {
        this.eattype = eattype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdTrade tdTrade = (TdTrade) o;

        if (userId != tdTrade.userId) return false;
        if (membername != null ? !membername.equals(tdTrade.membername) : tdTrade.membername != null) return false;
        if (dishestype != null ? !dishestype.equals(tdTrade.dishestype) : tdTrade.dishestype != null) return false;
        if (time != null ? !time.equals(tdTrade.time) : tdTrade.time != null) return false;
        if (canteentype != null ? !canteentype.equals(tdTrade.canteentype) : tdTrade.canteentype != null) return false;
        if (eattype != null ? !eattype.equals(tdTrade.eattype) : tdTrade.eattype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (membername != null ? membername.hashCode() : 0);
        result = 31 * result + (dishestype != null ? dishestype.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (canteentype != null ? canteentype.hashCode() : 0);
        result = 31 * result + (eattype != null ? eattype.hashCode() : 0);
        return result;
    }
}
