package service;

import module.Employee;

import java.util.LinkedList;

public interface IEmployeeService {
    void display();
    LinkedList<Employee> addEmployee();
    LinkedList<Employee> editEmployee();
}
