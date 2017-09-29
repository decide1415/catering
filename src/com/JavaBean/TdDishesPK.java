package com.JavaBean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by decide on 2017/9/30.
 */
public class TdDishesPK implements Serializable {
    private String name;
    private Timestamp time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        TdDishesPK that = (TdDishesPK) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
