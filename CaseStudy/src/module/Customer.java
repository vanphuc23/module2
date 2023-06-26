package module;

import java.time.LocalDate;

public class Customer {
    private int clientCode;
    private String fullName;
    private LocalDate date;
    private String gioitinh;
    private long cmnd;
    private long phoneNumber;
    private String email;
    private String clientType;
    private String address;

    public Customer() {
    }

    public Customer(int clientCode, String fullName, LocalDate date, String gioitinh, long cmnd, long phoneNumber, String email, String clientType, String address) {
        this.clientCode = clientCode;
        this.fullName = fullName;
        this.date = date;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientType = clientType;
        this.address = address;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
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

    public void setCmnd(long cmnd) {
        this.cmnd = cmnd;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return this.clientCode+" "+this.fullName;
    }
}
