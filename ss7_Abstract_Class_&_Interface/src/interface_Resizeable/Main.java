package interface_Resizeable;

public class Main {
    public static void main(String[] args) {
        Resizeable[] test = new Resizeable[3];
        test[0] = new Circle(2);
        test[1] = new Triangle(3, 4, 5);
        test[2] = new Square(4);
        for (Resizeable resizeable : test) {
            if (resizeable instanceof Circle) {
                System.out.println("Diện tích hình tròn ban đầu: " + ((Circle) resizeable).getArea());
            } else if (resizeable instanceof Triangle) {
                System.out.println("Diện tích hình tam giác ban đầu: " + ((Triangle) resizeable).getArea());
            } else {
                System.out.println("Diện tích hình vuông ban đầu: " + ((Square) resizeable).getArea());
            }
            double randomDouble = Math.random();
            randomDouble = randomDouble * 100 + 1;
            int randomInt = (int) randomDouble;
            resizeable.resize(randomInt);
        }
    }
}
