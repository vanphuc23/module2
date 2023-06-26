package Ktra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        Stack<String> bstack = new Stack<>();
        System.out.print("Nhập biểu thức: ");
        String str = sc.nextLine();
        String[] sym = str.split("");
        int count = 0;
        int dem = 0;
        for (int i = 0; i < sym.length; i++) {
            if (sym[i].equals("(")) {
                stack.push(sym[i]);
                count++;
            }
            if (sym[i].equals(")")) {
                bstack.push(sym[i]);
                dem++;
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Không có dấu ngoặc");
        }
        if (count == dem) {
            System.out.println("Well");
        } else {
            System.out.println("???");
        }
    }
}
