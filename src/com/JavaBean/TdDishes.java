package com.JavaBean;

/**
 * Created by decide on 2017/9/28.
 */
public class TdDishes {
    private int id;
    private String name;
    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdDishes tdDishes = (TdDishes) o;

        if (id != tdDishes.id) return false;
        if (name != null ? !name.equals(tdDishes.name) : tdDishes.name != null) return false;
        if (remarks != null ? !remarks.equals(tdDishes.remarks) : tdDishes.remarks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
