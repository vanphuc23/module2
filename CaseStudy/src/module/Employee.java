package module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeCode;
    private String fullName;
    private LocalDate date;
    private String gioitinh;
    private long cmnd;
    private long phone;
    private String email;
    private String level;
    private String location;
    private long wage;

    public Employee() {
    }

    public Employee(int employeeCode, String fullName, LocalDate date, String gioitinh, long cmnd, long phone, String email, String level, String location, long wage) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.date = date;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.phone = phone;
        this.email = email;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public long getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.employeeCode+" "+this.fullName;
    }
}
