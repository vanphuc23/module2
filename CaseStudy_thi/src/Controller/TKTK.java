package Controller;


import Service.TKNHService;
import Service.iTKNHService;

import java.util.Scanner;

public class TKTK {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        iTKNHService iTK=new TKNHService();
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
                    iTK.addNew();
                    break;
                case 2:
                    iTK.deleteTK();
                    break;
                case 3:
                    iTK.displayTK();
                    break;
                case 4:
                    break;
            }
        } while (choose >= 1 && choose <= 4);
    }
}
