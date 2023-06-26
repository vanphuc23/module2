package controller;

import service.EmployeeService;
import service.IEmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    Scanner scanner = new Scanner(System.in);
    private IEmployeeService iEmployeeService=new EmployeeService();
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
                    iEmployeeService.display();
                    break;
                case 2:
                    iEmployeeService.addEmployee();
                    break;
                case 3:
                    iEmployeeService.editEmployee();
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }
}
