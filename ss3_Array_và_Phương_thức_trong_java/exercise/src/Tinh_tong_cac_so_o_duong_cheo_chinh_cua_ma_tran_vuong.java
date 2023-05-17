import java.util.Scanner;

public class Tinh_tong_cac_so_o_duong_cheo_chinh_cua_ma_tran_vuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        int columns;
        do {
            System.out.print("Nhập số hàng: ");
            rows = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số hàng: ");
            columns = Integer.parseInt(sc.nextLine());
            if (rows != columns || rows <= 0) {
                System.out.println("Số hàng và số cột phải bằng nhau và cả 2 phải lớn hơn 0.");
            }
        } while (rows != columns || rows <= 0);
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Nhập phần tử thứ %d của hàng %d: ", j, i);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        sumLine(arr);
    }

    private static void sumLine(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.print("Tổng đường chéo chính của ma trận vuông: " + sum);
    }
}
