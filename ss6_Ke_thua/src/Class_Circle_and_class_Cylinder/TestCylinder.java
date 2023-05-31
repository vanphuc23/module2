package Class_Circle_and_class_Cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(2, "red", 4);
        System.out.println(c.getVolume());
        System.out.println(c.areaCircle());
        System.out.println(c);
        Circle c2 = new Circle(2, "red");
        System.out.println(c2);
    }
}
