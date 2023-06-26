package controller;

import service.FacilityService;
import service.IFacilityService;

import java.util.Scanner;

public class FacilityManagement {
    IFacilityService iFacilityService=new FacilityService();
    Scanner scanner=new Scanner(System.in);
    public void display() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iFacilityService.display();
                    break;
                case 2:
                    iFacilityService.add();
                    break;
                case 3:
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }
}
