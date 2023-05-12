import java.util.Scanner;

public class Kiem_tra_so_nguyen_to {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.print("Nhập: ");
        int number = sc.nextInt();
        if (number > 1) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.print(number + " là số nguyên tố");
            } else {
                System.out.print(number + " không phải là số nguyên tố");
            }
        } else {
            System.out.print(number + " không phải là số nguyên tố");
        }
    }
}
