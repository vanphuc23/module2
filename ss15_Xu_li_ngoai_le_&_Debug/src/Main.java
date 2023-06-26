import exception.IllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập cạnh a: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập cạnh b: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập cạnh c: ");
            double c = Double.parseDouble(scanner.nextLine());
            checkTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Nhập sai định dạng!!!");
        }
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tam giác không hợp lệ!!!");
        } else {
            System.out.println("Tam giác hợp lệ");
        }
    }
}
