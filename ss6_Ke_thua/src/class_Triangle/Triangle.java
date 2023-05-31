package class_Triangle;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        double h = (2 * Math.sqrt(p * (p - side1) * (p - side2) * (p - side3))) / side1;
        double max = side1;
        double min = side1;
        if (max < side2 && side2 > side3) {
            max = side2;
        } else if (max < side3 && side3 > side2) {
            max = side3;
        }
        if (min > side2 && side2 < side3) {
            min = side2;
        } else if (min > side3 && side3 < side2) {
            min = side3;
        }
        if (Math.pow(max, 2) == Math.pow(side1, 2) + Math.pow(side2, 2) || Math.pow(max, 2) == Math.pow(side1, 2) + Math.pow(side3, 2) || Math.pow(max, 2) == Math.pow(side3, 2) + Math.pow(side2, 2)) {
            return (h * min) / 2;
        } else {
            return (h * max) / 2;
        }

    }

    @Override
    public String toString() {
        return super.toString() + " " + "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
