import java.util.Scanner;

public class Hien_thi_cac_loai_hinh {
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

        System.out.print("Nhập chiều cao của tam giác: ");
        int chieucao = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= chieucao; i++) {
            for (int j = 1; j <= chieucao; j++) {
                if (j <= i) {
                    System.out.print("* ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println();
        }

        System.out.print("Nhập chiều cao của tam giác: ");
        int chieucao2 = Integer.parseInt(sc.nextLine());
        for (int i = chieucao2; i >= 1; i--) {
            for (int j = 1; j <= chieucao2; j++) {
                if (j <= i) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
