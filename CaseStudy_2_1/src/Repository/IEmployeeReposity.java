package Repository;

import Module.Employee;

import java.util.ArrayList;

public interface IEmployeeReposity {
    ArrayList<Employee> findAll();
    int getSize();
    ArrayList<Employee> readFromFile(ArrayList<Employee> Employee);
}
