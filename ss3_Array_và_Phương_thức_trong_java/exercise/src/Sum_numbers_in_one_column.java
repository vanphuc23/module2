import java.util.Scanner;

public class Sum_numbers_in_one_column {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] arr = {
                {1, 2, 3},
                {4, 5.4, 6},
                {7, 8, 1.2}
        };
        int numberColumns = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                numberColumns++;
            }
            System.out.printf("Hàng thứ %d có %d cột.\n", i, numberColumns);
            numberColumns = 0;
        }
        System.out.print("Nhập cột muốn tính tổng: ");
        int column = Integer.parseInt(sc.nextLine());
        double a = sumColumn(arr, column);
        System.out.print("Tổng của cột " + column + " bằng: " + a);
    }

    public static double sumColumn(double[][] arr, int column) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == column) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}
