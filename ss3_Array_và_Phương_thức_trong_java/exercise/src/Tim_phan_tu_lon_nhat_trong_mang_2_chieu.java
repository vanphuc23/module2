import java.util.Scanner;

public class Tim_phan_tu_lon_nhat_trong_mang_2_chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        int columns;
        do {
            System.out.print("Nhập số hàng của ma trận: ");
            rows = Integer.parseInt(sc.nextLine());
            if (rows >= 10 || rows <= 0) {
                System.out.println("Số hàng của ma trận phải nhỏ hơn 10 và lớn hơn 0.");
            }
        } while (rows >= 10 || rows <= 0);
        double[][] arr = new double[rows][];
        for (int i = 0; i < arr.length; i++) {
            do {
                System.out.printf("Nhập số cột ở hàng thứ %d: ", i);
                columns = Integer.parseInt(sc.nextLine());
                if (columns >= 10 || columns <= 0) {
                    System.out.println("Số cột của ma trận phải nhỏ hơn 10 và lớn hơn 0.");
                }
            } while (columns >= 10 || columns <= 0);
            arr[i] = new double[columns];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Nhập phần tử thứ %d ở hàng %d: ", j, i);
                arr[i][j] = Double.parseDouble(sc.nextLine());
            }
            System.out.println();
        }
        System.out.println("Phần tử lớn nhất trong mảng 2 chiều: " + maxArray(arr));
    }

    public static double maxArray(double[][] arr) {
        double max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
