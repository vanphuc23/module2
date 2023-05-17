import java.util.Scanner;

public class Dem_so_lan_xuat_hien_ky_tu_trong_chuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một ký tự: ");
        char c = sc.next().charAt(0);
        String str2 = sc.nextLine();
        System.out.print("Nhập một chuỗi: ");
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        System.out.printf("Số lần xuất hiện của ký tự %c trong '%s' bằng: %d", c, str, count);
    }
}
