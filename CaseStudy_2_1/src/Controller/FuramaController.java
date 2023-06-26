package Controller;

import Service.EmployeeService;
import Service.IEmployeeService;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        int choose;
        IEmployeeService iEmployeeService;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management ");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6,Exit");
            System.out.println("Mời cưng chọn chức năng: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    int n;
                    do {
                        System.out.println("1.Display list employees");
                        System.out.println("2.Add new employee");
                        System.out.println("3.Edit employee");
                        System.out.println("4.return main menu");
                        n = Integer.parseInt(sc.nextLine());
                        iEmployeeService = new EmployeeService();
                        switch (n) {
                            case 1:
                                iEmployeeService.display();
                                break;
                            case 2:
                                iEmployeeService.add();
                                break;
                            case 3:
                                iEmployeeService.fixInfor();
                                iEmployeeService.display();
                                break;
                        }
                    } while (n >= 1 && n <= 3);
                    break;
            }
        } while (choose >= 1 && choose <= 5);
    }
}
