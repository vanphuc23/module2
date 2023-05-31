package interface_Resizeable;

public class Circle extends Area implements Resizeable {
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void resize(double percent) {
        System.out.print("Diện tích hình tròn sau khi tăng lên " + percent + " :");
        System.out.println(Math.PI * Math.pow((radius + percent), 2));
    }
}
