package Repository;

import Module.TaiKhoanThanhToan;
import Util.readFileTKTT;
import Util.writeFileAll;
import Util.writeFileTKTT;

import java.util.ArrayList;

public class TKTTRepository implements iTKTTRepository {
    @Override
    public ArrayList<TaiKhoanThanhToan> findAll() {
        return readFileTKTT.readTKTT();
    }

    @Override
    public void write(ArrayList<TaiKhoanThanhToan> arrayList) {
        writeFileTKTT.writeTKTT(arrayList);
        writeFileAll.writeAll();
    }
}
