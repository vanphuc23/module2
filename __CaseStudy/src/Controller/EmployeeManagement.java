package Controller;

import Service.EmployeeService;
import Service.IEmployeeService;
import Exception.NotFoundEmployeeException;

import java.util.Scanner;

public class EmployeeManagement {
    Scanner scanner = new Scanner(System.in);
    private IEmployeeService iEmployeeService=new EmployeeService();
    public void display() throws NotFoundEmployeeException {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Search employee");
            System.out.println("6. Return main menu");
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
                case 4:
                    iEmployeeService.deleteEmployee();
                    break;
                case 5:
                    iEmployeeService.searchEmployee();
                    break;
            }
        } while (choose >= 1 && choose <= 5);
    }
}
