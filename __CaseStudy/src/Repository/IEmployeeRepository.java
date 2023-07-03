package Repository;

import Module.Employee;

import java.util.ArrayList;

public interface IEmployeeRepository {
    ArrayList<Employee> findAll();
    int sizeFile();
    void write(ArrayList<Employee> employees);
}
