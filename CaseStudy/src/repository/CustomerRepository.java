package repository;

import module.Customer;

import java.time.LocalDate;
import java.util.LinkedList;

public class CustomerRepository implements ICustomerRepository{
    static LinkedList<Customer> customers=new LinkedList<>();
    static {
        customers.add(new Customer(1, "Nguyễn Văn A", LocalDate.of(2000, 2, 5), "Nam", 123456, 0123456, "abc@gmail.com", "God", "ĐN"));
        customers.add(new Customer(2, "Nguyễn Văn B", LocalDate.of(2001, 3, 6), "Nữ", 6534124, 64563, "abc@gmail.com", "Platinium", "QN"));
        customers.add(new Customer(3, "Nguyễn Văn C", LocalDate.of(2002, 4, 7), "Nam", 76352, 6753, "abc@gmail.com", "Diamond", "HN"));
    }

    @Override
    public LinkedList<Customer> findAll() {
        return customers;
    }
}
