package model;

public class User {
    private String fullname;
    private String dOB;
    private String code;

    public User() {
    }

    public User(String fullname, String dOB, String code) {
        this.fullname = fullname;
        this.dOB = dOB;
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
