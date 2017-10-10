package com.JavaBean;

import java.sql.Date;

/**
 * Created by decide on 2017/10/9.
 */
public class Tradeitemstb {
    private int userId;
    private Date time;
    private int tcAitem;
    private int tcBitem;
    private int count;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getTcAitem() {
        return tcAitem;
    }

    public void setTcAitem(int tcAitem) {
        this.tcAitem = tcAitem;
    }

    public int getTcBitem() {
        return tcBitem;
    }

    public void setTcBitem(int tcBitem) {
        this.tcBitem = tcBitem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tradeitemstb that = (Tradeitemstb) o;

        if (userId != that.userId) return false;
        if (tcAitem != that.tcAitem) return false;
        if (tcBitem != that.tcBitem) return false;
        if (count != that.count) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + tcAitem;
        result = 31 * result + tcBitem;
        result = 31 * result + count;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
