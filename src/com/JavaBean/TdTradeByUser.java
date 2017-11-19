package com.JavaBean;

import java.sql.Date;

/**
 * Created by decide on 2017/10/11.
 */
public class TdTradeByUser {
    private int userId;
    private Date time;
    private int count;
    private int cotTcAbySta;
    private int cotTcBbySta;
    private int cotTcAbyStb;
    private int cotTcBbyStb;
    private String userName;
    private int cotTcCbySta;
    private int cotTcCbyStb;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCotTcAbySta() {
        return cotTcAbySta;
    }

    public void setCotTcAbySta(int cotTcAbySta) {
        this.cotTcAbySta = cotTcAbySta;
    }

    public int getCotTcBbySta() {
        return cotTcBbySta;
    }

    public void setCotTcBbySta(int cotTcBbySta) {
        this.cotTcBbySta = cotTcBbySta;
    }

    public int getCotTcAbyStb() {
        return cotTcAbyStb;
    }

    public void setCotTcAbyStb(int cotTcAbyStb) {
        this.cotTcAbyStb = cotTcAbyStb;
    }

    public int getCotTcBbyStb() {
        return cotTcBbyStb;
    }

    public void setCotTcBbyStb(int cotTcBbyStb) {
        this.cotTcBbyStb = cotTcBbyStb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCotTcCbySta() {
        return cotTcCbySta;
    }

    public void setCotTcCbySta(int cotTcCbySta) {
        this.cotTcCbySta = cotTcCbySta;
    }

    public int getCotTcCbyStb() {
        return cotTcCbyStb;
    }

    public void setCotTcCbyStb(int cotTcCbyStb) {
        this.cotTcCbyStb = cotTcCbyStb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdTradeByUser that = (TdTradeByUser) o;

        if (userId != that.userId) return false;
        if (count != that.count) return false;
        if (cotTcAbySta != that.cotTcAbySta) return false;
        if (cotTcBbySta != that.cotTcBbySta) return false;
        if (cotTcAbyStb != that.cotTcAbyStb) return false;
        if (cotTcBbyStb != that.cotTcBbyStb) return false;
        if (cotTcCbySta != that.cotTcCbySta) return false;
        if (cotTcCbyStb != that.cotTcCbyStb) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + cotTcAbySta;
        result = 31 * result + cotTcBbySta;
        result = 31 * result + cotTcAbyStb;
        result = 31 * result + cotTcBbyStb;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + cotTcCbySta;
        result = 31 * result + cotTcCbyStb;
        return result;
    }
}
