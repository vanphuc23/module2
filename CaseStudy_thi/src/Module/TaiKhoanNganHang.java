package Module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TaiKhoanNganHang {
    private int id;
    private String code;
    private String name;
    private LocalDate startDay;

    public TaiKhoanNganHang() {
    }

    public TaiKhoanNganHang(int id, String code, String name, LocalDate startDay) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.startDay = startDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.id + ", " + this.code + ", " + this.name + ", " + formatter.format(this.startDay) + ", ";
    }
}
