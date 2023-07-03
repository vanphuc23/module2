package Controller;

import Service.BookingService;
import Service.IBookingService;

import java.util.Scanner;

public class BookingManagerment {
    Scanner scanner = new Scanner(System.in);
    private IBookingService iBookingService=new BookingService();
    public void display() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iBookingService.addBooking();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choose >= 1 && choose <= 5);
    }
}
