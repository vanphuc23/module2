package Controller;

import Service.TKTTService;
import Service.iTKTTService;

import java.util.Scanner;

public class TKTT {
    Scanner scanner = new Scanner(System.in);

    public void menu2() {
        iTKTTService iTT = new TKTTService();
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách tài khoản ngân hàng");
            System.out.println("4. Tìm Kiếm");
            System.out.println("5. Exit");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iTT.addNew();
                    break;
                case 2:
                    iTT.deleteTT();
                    break;
                case 3:
                    iTT.displayTT();
                    break;
                case 4:
                    break;
            }
        } while (choose >= 1 && choose <= 4);
    }
}
