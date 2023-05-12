

import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều dài của hình chữ nhật: ");
        int chieudai = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chiều rộng của hình chữ nhật: ");
        int chieurong = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < chieudai; i++) {
            for (int j = 0; j < chieurong; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}