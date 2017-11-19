package com.JavaBean;

import java.io.Serializable;

/**
 * Created by decide on 2017/10/18.
 */
public class TdMemberPK implements Serializable {
    private int id;
    private String py;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdMemberPK that = (TdMemberPK) o;

        if (id != that.id) return false;
        if (py != null ? !py.equals(that.py) : that.py != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (py != null ? py.hashCode() : 0);
        return result;
    }
}
