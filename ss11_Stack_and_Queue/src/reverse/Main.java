package reverse;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 5; i++) {
            st.push(i);
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        Stack<String> wStack = new Stack<>();
        String mWork = "olleH";
        String[] work = mWork.split("");
        for (String s : work) {
            wStack.push(s);
        }
        while (!wStack.isEmpty()) {
            System.out.print(wStack.pop());
        }
    }
}
