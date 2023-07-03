package Module;

public class Employee {
    private int employeeCode;
    private String fullName;
    private String date;
    private String gioitinh;
    private String cmnd;
    private String phone;
    private String email;
    private String level;
    private String location;
    private long wage;

    public Employee() {
    }

    public Employee(int employeeCode, String fullName, String date, String gioitinh, String cmnd, String phone, String email, String level, String location, long wage) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
        return this.employeeCode+", "+this.fullName+", "+this.date+", "+this.gioitinh+", "+this.cmnd+", "+this.phone+", "+this.email+", "+this.level+", "+this.location+", "+this.wage;
    }
}
