public class d {
    public static void main(String[] args) {
         chia(1,0);
    }
    public static void chia(double a,double b) {
            try {
                double c=a/b;
                System.out.println(c);
            } catch (ArithmeticException e) {
                System.out.println("b khác 0");
            }
    }
}
