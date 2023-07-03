package Repository;

import Module.Employee;
import util.ReadFileEmployee;
import util.WriteFileEmployee;

import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository{
    @Override
    public ArrayList<Employee> findAll() {
        return ReadFileEmployee.ReadFile();
    }

    @Override
    public int sizeFile() {
        return ReadFileEmployee.ReadFile().size();
    }

    @Override
    public void write(ArrayList<Employee> employees) {
        WriteFileEmployee.WriteFile(employees);
    }
}
