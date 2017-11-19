package com.JavaBean;

/**
 * Created by decide on 2017/10/18.
 */
public class TdMember {
    private int id;
    private String name;
    private String py;
    private String pyfist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getPyfist() {
        return pyfist;
    }

    public void setPyfist(String pyfist) {
        this.pyfist = pyfist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdMember tdMember = (TdMember) o;

        if (id != tdMember.id) return false;
        if (name != null ? !name.equals(tdMember.name) : tdMember.name != null) return false;
        if (py != null ? !py.equals(tdMember.py) : tdMember.py != null) return false;
        if (pyfist != null ? !pyfist.equals(tdMember.pyfist) : tdMember.pyfist != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (py != null ? py.hashCode() : 0);
        result = 31 * result + (pyfist != null ? pyfist.hashCode() : 0);
        return result;
    }
}
