package Module;

import java.time.LocalDate;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private String soThe;
    private long tienTK;

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(int id, String code, String name, LocalDate startDay, String soThe, long tienTK) {
        super(id, code, name, startDay);
        this.soThe = soThe;
        this.tienTK = tienTK;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public long getTienTK() {
        return tienTK;
    }

    public void setTienTK(long tienTK) {
        this.tienTK = tienTK;
    }

    @Override
    public String toString() {
        return super.toString() + this.soThe + ", " + this.tienTK;
    }
}
