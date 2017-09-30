package com.JavaBean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by decide on 2017/9/30.
 */
public class TdTradePK implements Serializable {
    private String membername;
    private Date time;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdTradePK tdTradePK = (TdTradePK) o;

        if (membername != null ? !membername.equals(tdTradePK.membername) : tdTradePK.membername != null) return false;
        if (time != null ? !time.equals(tdTradePK.time) : tdTradePK.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = membername != null ? membername.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
