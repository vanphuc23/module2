package Controller;

import java.util.Scanner;

public class TaiKhoanNganHang {
    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Tài Khoản Tiết Kiệm");
            System.out.println("2. Tài Khoản Thanh Toán");
            System.out.println("3. Exit");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    TKTK tk=new TKTK();
                    tk.menu();
                    break;
                case 2:
                    TKTT tt=new TKTT();
                    tt.menu2();
                    break;
            }
        } while (choose >= 1 && choose <= 2);
    }
}
