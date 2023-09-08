import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước của mảng: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        int index = 0;
        do {
            System.out.print("Nhập giá trị vị trí thứ " + index + " :");
            int val = Integer.parseInt(sc.nextLine());
            arr[index] = val;
            index++;
        } while (index < size);
        System.out.println("Mảng trước khi chèn");
        System.out.println(Arrays.toString(arr));

        System.out.println("Nhập vị trí cần chèn: ");
        int position = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập giá trị cần chèn: ");
        int value = Integer.parseInt(sc.nextLine());

        int[] newArr = Arrays.copyOf(arr, size + 1);

        for (int i = position; i < newArr.length; i++) {
            int number = newArr[i];
            newArr[i] = value;
            value = number;
        }
        System.out.println(Arrays.toString(newArr));
    }
}
