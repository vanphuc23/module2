package Controller;

import Repository.IFacilityRepository;
import Service.FacilityService;
import Service.IFacilityService;
import Service.IService;

import java.util.Scanner;

public class FacilityManagement {
    Scanner scanner = new Scanner(System.in);
    private IFacilityService iFacilityService = new FacilityService();

    public void display() {
        int choose;
        do {
            System.out.println("========= Menu =========");
            System.out.println("1. Display list Facility");
            System.out.println("2. Add new Facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iFacilityService.display();
                    break;
                case 2:
                    add();
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }

    private void add() {
        int choose;
        do {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iFacilityService.addVilla();
                    break;
                case 2:
                    iFacilityService.addHouse();
                    break;
                case 3:
                    iFacilityService.addRoom();
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }
}
