import java.util.Arrays;
import java.util.Scanner;

public class Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int cnt = 0;
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.print("Nhập phần tử cần xóa: ");
        int x = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == x) {
                System.out.printf("X ở vị trí thứ %d" + "\n", (j + 1));
                cnt++;
            }
        }
        for (int k = 1; k <= cnt; k++) {
            for (int i = 0; i < arr.length; i++) {
                if (i == (arr.length - 1)) {
                    arr[i] = 0;
                    break;
                }
                if (arr[i] == x) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("X không xuất hiện trong mảng.");
        }
        System.out.print(Arrays.toString(arr));
    }
}
