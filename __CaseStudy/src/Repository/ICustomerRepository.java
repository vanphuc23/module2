package Repository;


import Module.Customer;

import java.util.ArrayList;

public interface ICustomerRepository {
    ArrayList<Customer> findAll();
    int sizeFile();
    void write(ArrayList<Customer> customers);
}
