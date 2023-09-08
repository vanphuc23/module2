package Module;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private long money;
    private LocalDate ngayGui;
    private String laiSuat;
    private String kiHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(int id, String code, String name, LocalDate startDay, long money, LocalDate ngayGui, String laiSuat, String kiHan) {
        super(id, code, name, startDay);
        this.money = money;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public LocalDate getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(LocalDate ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + this.money + ", " + formatter.format(this.ngayGui) + ", " + this.laiSuat + ", " + this.kiHan;
    }
}
