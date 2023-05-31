package Access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle cr = new Circle();
        System.out.println(cr.getRadius());
        System.out.println(cr.getArea());
        Circle htr = new Circle(2);
        System.out.println(htr.getRadius());
        System.out.println(htr.getArea());
    }
}
