package Class_Circle_and_class_Cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double areaCircle() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Bán kính của hình tròn bằng "
                + getRadius()
                + " Có màu "
                + getColor();
    }
}
