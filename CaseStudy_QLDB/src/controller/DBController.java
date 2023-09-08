package controller;

import service.DBService;
import service.IDBService;

import java.util.Scanner;

public class DBController {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        IDBService danhsach = new DBService();
        int choose;
        do {
            System.out.println("========== CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ==========");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    danhsach.display();
                    break;
                case 2:
                    danhsach.add();
                    break;
                case 3:
                    danhsach.edit();
                    break;
                case 4:
                    danhsach.delete();
                    break;
                case 5:
                    danhsach.search();
                    break;
                case 6:
                    danhsach.readFile();
                    break;
                case 7:
                    danhsach.saveFile();
                    break;
            }
        } while (choose >= 1 && choose <= 7);
    }
}
