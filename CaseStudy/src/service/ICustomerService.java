package service;

import module.Customer;
import module.Employee;

import java.util.LinkedList;

public interface ICustomerService {
    void display();
    LinkedList<Customer> addCustomer();
    LinkedList<Customer> editCustomer();
}
