package com.JavaBean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by decide on 2017/9/30.
 */
public class TdTradeByUserPK implements Serializable {
    private Date time;
    private String canteentype;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdTradeByUserPK that = (TdTradeByUserPK) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (canteentype != null ? !canteentype.equals(that.canteentype) : that.canteentype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (canteentype != null ? canteentype.hashCode() : 0);
        return result;
    }
}
