package Service;

import Module.Employee;

import java.util.ArrayList;
import Exception.NotFoundEmployeeException;

public interface IEmployeeService {
    void display();

    ArrayList<Employee> addEmployee();

    void editEmployee();

    void deleteEmployee();

    void searchEmployee() throws NotFoundEmployeeException;
}
