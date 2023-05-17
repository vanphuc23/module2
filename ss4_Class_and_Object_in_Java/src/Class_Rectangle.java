import java.util.Scanner;

public class Class_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double width = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double height = Double.parseDouble(sc.nextLine());
        Rectangle rec = new Rectangle(width, height);
        System.out.println("Your Rectangle \n" + rec.display());
        System.out.println("Chu vi hình chữ nhật: " + rec.getPerimeter());
        System.out.println("Diện tích hình chữ nhật: " + rec.getArea());
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
