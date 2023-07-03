package Service;


import Module.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    void display();

    ArrayList<Customer> addCustomer();

    void editCustomer();

}
