package Repository;

import Module.TaiKhoanTietKiem;
import Util.readFileTKTK;
import Util.writeFileAll;
import Util.writeFileTKTK;

import java.util.ArrayList;

public class TKTKRepository implements iTKTKRepository {
    @Override
    public ArrayList<TaiKhoanTietKiem> display() {
        return readFileTKTK.readTKTK();
    }

    @Override
    public void writeTK(ArrayList<TaiKhoanTietKiem> arrayList) {
        writeFileTKTK.writeTKTK(arrayList);
        writeFileAll.writeAll();
    }
}
