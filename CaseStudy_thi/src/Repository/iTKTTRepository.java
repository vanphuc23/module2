package Repository;

import Module.TaiKhoanThanhToan;

import java.util.ArrayList;

public interface iTKTTRepository {
    ArrayList<TaiKhoanThanhToan> findAll();
    void write(ArrayList<TaiKhoanThanhToan> arrayList);
}
