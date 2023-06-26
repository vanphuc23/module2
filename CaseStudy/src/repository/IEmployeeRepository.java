package repository;

import module.Employee;

import java.util.ArrayList;
import java.util.LinkedList;

public interface IEmployeeRepository {
    LinkedList<Employee> display();
//    void writeFileEmployee();
    LinkedList<Employee> readFileEmployee();
}
