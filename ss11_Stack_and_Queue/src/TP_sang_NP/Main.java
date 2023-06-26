package TP_sang_NP;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> number = new Stack<>();
        System.out.print("Nhập số thập phân: ");
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            number.push(n % 2);
            n /= 2;
        }
        while (!number.isEmpty()) {
            System.out.print(number.pop());
        }
    }
}
