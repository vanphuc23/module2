package Repository;

import Module.TaiKhoanTietKiem;

import java.util.ArrayList;

public interface iTKTKRepository {
    ArrayList<TaiKhoanTietKiem> display();
    void writeTK(ArrayList<TaiKhoanTietKiem> arrayList);
}
