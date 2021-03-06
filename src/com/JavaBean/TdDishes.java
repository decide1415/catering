package com.JavaBean;

import java.sql.Timestamp;

/**
 * Created by decide on 2017/9/30.
 */
public class TdDishes {
    private String name;
    private String remarks;
    private Timestamp time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdDishes tdDishes = (TdDishes) o;

        if (name != null ? !name.equals(tdDishes.name) : tdDishes.name != null) return false;
        if (remarks != null ? !remarks.equals(tdDishes.remarks) : tdDishes.remarks != null) return false;
        if (time != null ? !time.equals(tdDishes.time) : tdDishes.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
