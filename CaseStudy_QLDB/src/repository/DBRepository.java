package repository;

import module.DanhBa;
import util.ReadFileDB;
import util.ReadFileNew;
import util.WritFileDB;
import util.WriteFileNew;

import java.util.ArrayList;

public class DBRepository implements IDBRepository{
    @Override
    public ArrayList<DanhBa> findAll() {
        return ReadFileDB.readFile();
    }

    @Override
    public void write(ArrayList<DanhBa> arrayList) {
        WritFileDB.writeFile(arrayList);
    }

    @Override
    public void writeFileNew(ArrayList<DanhBa> arrayList) {
        WriteFileNew.writeNew(arrayList);
    }

    @Override
    public ArrayList<DanhBa> readFileNew() {
        return ReadFileNew.readNew();
    }
}
