package Repository;

import Module.Customer;
import util.ReadFileCustomer;
import util.WriteFileCustomer;

import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public ArrayList<Customer> findAll() {
        return ReadFileCustomer.ReadFile();
    }

    @Override
    public int sizeFile() {
        return findAll().size();
    }

    @Override
    public void write(ArrayList<Customer> customers) {
        WriteFileCustomer.WriteFile(customers);
    }
}
