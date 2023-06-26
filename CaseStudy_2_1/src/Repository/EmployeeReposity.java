package Repository;

import Module.Employee;
import util.EmployeeReadFile;
import util.EmployeeWriteFile;

import java.util.ArrayList;

public class EmployeeReposity implements IEmployeeReposity {
    static int size;
    public ArrayList<Employee> findAll() {
        return  EmployeeReadFile.ReadFile();
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public ArrayList<Employee> readFromFile(ArrayList<Employee>demo) {
        return EmployeeWriteFile.WriteFile(demo);
    }

}
