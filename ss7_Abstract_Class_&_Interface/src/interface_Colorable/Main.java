package interface_Colorable;

public class Main {
    public static void main(String[] args) {
        Shape2[] col = new Shape2[2];
        col[0] = new Square(2);
        col[1] = new Circle(2);
//        for (Colorable colorable : col) {
//            if (colorable instanceof Square) {
//                System.out.println("Diện tích hình vuông: " + ((Square) colorable).getArea());
//            }
//            if (colorable != null) {
//                colorable.howToColor();
//            }
        for (int i = 0; i < col.length; i++) {
            if (col[i] instanceof Square) {
                System.out.println("Diện tích hình vuông: " + ((Square) col[i]).getArea1());
            } else {
                System.out.println("Diện tích hình tròn: " + ((Circle) col[i]).getArea());
            }
            if(col[i] instanceof Colorable) {
                ((Colorable) col[i]).howToColor();
            }
        }
    }
}
