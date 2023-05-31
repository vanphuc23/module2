package class_Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle("red", 3, 4, 5);
        System.out.println(t);
        System.out.println("Chu vi tam giác: " + t.getPerimeter());
        System.out.println("Diện tích tam giác: " + t.getArea());
    }
}
