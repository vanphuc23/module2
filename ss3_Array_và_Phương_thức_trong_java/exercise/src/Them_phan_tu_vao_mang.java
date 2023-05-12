import java.util.Arrays;
import java.util.Scanner;

public class Them_phan_tu_vao_mang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int slot = 0;
        int count = 0;
        System.out.print("Nhập số cần chèn: ");
        int x = Integer.parseInt(sc.nextLine());
        int ind;
        int[] arr = {10, 4, 6, 7, 8, 9, 10, 11, 12, 13};
        do {
            System.out.print("Nhập vị trí để chèn số vào trong mảng: ");
            ind = Integer.parseInt(sc.nextLine());
            if (ind <= 1 || ind >= (arr.length - 1)) {
                System.out.println("Không chèn được phần tử vào mảng.");
                System.out.printf("Vị trí phải > 1 hoặc < %d" + "\n", (arr.length - 1));
            }
        } while (ind <= 1 || ind >= (arr.length - 1));
        for (int i = 0; i < arr.length; i++) {
            if (i == ind) {
                int temp = arr[i];
                arr[i] = x;
                slot = arr[i + 1];
                arr[i + 1] = temp;
                count++;
            }
            if (count != 0) {
                int tp = arr[i + 2];
                arr[i + 2] = slot;
                slot = tp;
                if ((i + 2) == (arr.length - 1)) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
