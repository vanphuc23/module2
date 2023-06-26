package service;

import module.Customer;
import module.Employee;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer c : iCustomerRepository.findAll()
        ) {
            System.out.println(c.toString());
        }
    }

    @Override
    public LinkedList<Customer> addCustomer() {
        System.out.println("Nhập Mã khách hàng: ");
        int newClientCode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iCustomerRepository.findAll().size(); i++) {
            if (iCustomerRepository.findAll().get(i).getClientCode() == newClientCode) {
                System.out.println("Trùng mã khách hàng!!!");
                return null;
            }
        }
        System.out.println("Nhập họ tên: ");
        String newFullName = scanner.nextLine();
        System.out.println("Nhập năm sinh:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tháng sinh:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày sinh:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Nhập giới tính:");
        String newGioitinh = scanner.nextLine();
        System.out.println("Nhập cmnd:");
        long newCmnd = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập sđt:");
        long newPhone = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập email:");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập loại khách:");
        String newClientType = scanner.nextLine();
        System.out.println("Nhập địa chỉ:");
        String newAddress = scanner.nextLine();
        Customer customer = new Customer(newClientCode, newFullName, date, newGioitinh, newCmnd, newPhone, newEmail, newClientType, newAddress);
        iCustomerRepository.findAll().add(customer);
        return iCustomerRepository.findAll();
    }

    @Override
    public LinkedList<Customer> editCustomer() {
        System.out.println("Nhập mã nhân viên bạn muốn chỉnh sửa:");
        int clientCode = Integer.parseInt(scanner.nextLine());
//        int index = -1;
//        for (int i = 0; i < iCustomerRepository.findAll().size(); i++) {
//            if (clientCode == iCustomerRepository.findAll().get(i).getClientCode()) {
//                index = i;
//            } else {
//                System.out.println("Không tồn tại mã nhân viên " + clientCode + " trong danh sách!!!");
//                return null;
//            }
//        }
        System.out.println("Nhập họ tên: ");
        String newFullName = scanner.nextLine();
        System.out.println("Nhập năm sinh:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tháng sinh:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày sinh:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Nhập giới tính:");
        String newGioitinh = scanner.nextLine();
        System.out.println("Nhập cmnd:");
        long newCmnd = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập sđt:");
        long newPhone = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập email:");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập loại khách:");
        String newClientType = scanner.nextLine();
        System.out.println("Nhập địa chỉ:");
        String newAddress = scanner.nextLine();
        Customer customer = new Customer(clientCode, newFullName, date, newGioitinh, newCmnd, newPhone, newEmail, newClientType, newAddress);
        for (int i = 0; i < iCustomerRepository.findAll().size(); i++) {
            if (clientCode == iCustomerRepository.findAll().get(i).getClientCode()) {
                iCustomerRepository.findAll().set(i, customer);
                return iCustomerRepository.findAll();
            }
        }
        System.out.println("Không tồn tại mã nhân viên " + clientCode + " trong danh sách!!!");
        return null;
    }
}
