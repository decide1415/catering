package com.JavaBean;

import java.sql.Date;

/**
 * Created by decide on 2017/9/30.
 */
public class TdTradeByUser {
    private int userId;
    private Date time;
    private Integer t1Count;
    private Integer t2Count;
    private String canteentype;

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

    public Integer getT1Count() {
        return t1Count;
    }

    public void setT1Count(Integer t1Count) {
        this.t1Count = t1Count;
    }

    public Integer getT2Count() {
        return t2Count;
    }

    public void setT2Count(Integer t2Count) {
        this.t2Count = t2Count;
    }

    public String getCanteentype() {
        return canteentype;
    }

    public void setCanteentype(String canteentype) {
        this.canteentype = canteentype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdTradeByUser that = (TdTradeByUser) o;

        if (userId != that.userId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (t1Count != null ? !t1Count.equals(that.t1Count) : that.t1Count != null) return false;
        if (t2Count != null ? !t2Count.equals(that.t2Count) : that.t2Count != null) return false;
        if (canteentype != null ? !canteentype.equals(that.canteentype) : that.canteentype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (t1Count != null ? t1Count.hashCode() : 0);
        result = 31 * result + (t2Count != null ? t2Count.hashCode() : 0);
        result = 31 * result + (canteentype != null ? canteentype.hashCode() : 0);
        return result;
    }
}
