package interface_Colorable;

public class Square extends Shape2 implements Colorable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea1() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Square has red color");
    }
}
