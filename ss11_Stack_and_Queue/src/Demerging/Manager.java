package Demerging;

public class Manager {
    private String fullname;
    private String gioitinh;
    private int date;

    public Manager() {
    }

    public Manager(String fullname, String gioitinh, int date) {
        this.fullname = fullname;
        this.gioitinh = gioitinh;
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return fullname+" "+gioitinh+" "+date;
    }
}
