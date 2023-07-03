package Controller;

import Service.CustomerService;
import Service.ICustomerService;

import java.util.Scanner;

public class CustomerManagement {
    Scanner scanner = new Scanner(System.in);
    private ICustomerService iCustomerService = new CustomerService();

    public void display() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iCustomerService.display();
                    break;
                case 2:
                    iCustomerService.addCustomer();
                    break;
                case 3:
                    iCustomerService.editCustomer();
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }
}
