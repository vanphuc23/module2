package Palindrome_use_Queue;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        String word = str.toLowerCase(Locale.ROOT);
        String[] arr = word.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (String s : arr
        ) {
            stack.push(s);
            queue.add(s);
        }
        String[] a = word.split("");
        String[] b = word.split("");
        while (!stack.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                a[i] = stack.pop();
            }
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                b[i] = queue.remove();
            }
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!a[i].equals(b[i])) {
                System.out.println("Không phải chuỗi Palindrome");
                break;
            } else {
                count++;
            }
        }
        if (count == word.length()) {
            System.out.println("chuỗi Palindrome");
        }
    }
}
