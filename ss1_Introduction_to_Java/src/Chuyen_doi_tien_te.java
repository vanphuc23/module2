import java.util.Scanner;

public class Chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vnd = 23000;
        System.out.print("Nhập số tiền USD muốn đổi thành VNĐ: ");
        double usd = Double.parseDouble(sc.nextLine());
        double exchange = usd * vnd;
        System.out.println("Giá trị VNĐ: " + exchange);
    }
}
