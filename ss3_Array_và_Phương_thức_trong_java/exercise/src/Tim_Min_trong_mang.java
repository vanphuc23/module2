import java.util.Scanner;

public class Tim_Min_trong_mang {
    public static int minArray(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập độ dài của mảng: ");
            size = Integer.parseInt(sc.nextLine());
            if (size >= 10 || size <= 0) {
                System.out.print("Độ dài của mảng phải nhỏ hơn 10 và lớn hơn 0!!!");
            }
        } while (size >= 10 || size <= 0);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập phần tử thứ %d trong mảng: ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Giá trị nhỏ nhất trong mảng: " + minArray(arr));
    }
}
