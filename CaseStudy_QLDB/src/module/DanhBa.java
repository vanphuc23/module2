package module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DanhBa {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private LocalDate birthday;
    private String email;

    public DanhBa() {
    }

    public DanhBa(String phone, String group, String name, String gender, String address, LocalDate birthday, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.phone + ", " + this.group + ", " + this.name + ", " + this.gender + ", " + this.address+", "+formatter.format(this.birthday)+", "+this.email;
    }
}
