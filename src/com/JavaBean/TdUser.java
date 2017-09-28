package com.JavaBean;

/**
 * Created by decide on 2017/9/28.
 */
public class TdUser {
    private int id;
    private String name;
    private String password;
    private String type;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TdUser tdUser = (TdUser) o;

        if (id != tdUser.id) return false;
        if (name != null ? !name.equals(tdUser.name) : tdUser.name != null) return false;
        if (password != null ? !password.equals(tdUser.password) : tdUser.password != null) return false;
        if (type != null ? !type.equals(tdUser.type) : tdUser.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
