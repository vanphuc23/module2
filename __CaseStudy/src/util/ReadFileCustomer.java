package util;

import Module.Customer;

import java.io.*;
import java.util.ArrayList;

public class ReadFileCustomer {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\customer.csv";

    public static ArrayList<Customer> ReadFile() {
        ArrayList<Customer> customers = new ArrayList<>();
        File file = new File(PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            Customer customer;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    customer = new Customer();
                    customer.setClientCode(Integer.parseInt(strings[0]));
                    customer.setFullName(strings[1]);
                    customer.setDate(strings[2]);
                    customer.setGioitinh(strings[3]);
                    customer.setCmnd(strings[4]);
                    customer.setPhoneNumber(strings[5]);
                    customer.setEmail(strings[6]);
                    customer.setClientType(strings[7]);
                    customer.setAddress(strings[8]);
                    customers.add(customer);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
