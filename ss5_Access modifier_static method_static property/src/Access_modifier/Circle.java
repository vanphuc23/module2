package Access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

     double getRadius() {
        return radius;
    }

     double getArea() {
        return Math.PI * radius * radius;
    }
}
