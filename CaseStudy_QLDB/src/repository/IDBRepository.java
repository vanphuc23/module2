package repository;

import module.DanhBa;

import java.util.ArrayList;

public interface IDBRepository {
    ArrayList<DanhBa> findAll();
    void write(ArrayList<DanhBa> arrayList);
    void writeFileNew(ArrayList<DanhBa> arrayList);
    ArrayList<DanhBa> readFileNew();
}
