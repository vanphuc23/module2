package repository;

import module.Customer;

import java.util.LinkedList;

public interface ICustomerRepository {
    LinkedList<Customer> findAll();
}
