package controller;

import java.util.Scanner;

public class FuramaController {
    Scanner scanner = new Scanner(System.in);
    public void displayMainMenu() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    EmployeeManagement employeeManagement=new EmployeeManagement();
                    employeeManagement.display();
                    break;
                case 2:
                    CustomerManagement customerManagement=new CustomerManagement();
                    customerManagement.display();
                    break;
                case 3:
                    FacilityManagement facilityManagement=new FacilityManagement();
                    facilityManagement.display();
            }
        } while (choose >= 1 && choose <= 5);
    }
}
