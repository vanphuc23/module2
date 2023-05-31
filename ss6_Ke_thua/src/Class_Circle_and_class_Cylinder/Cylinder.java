package Class_Circle_and_class_Cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return areaCircle() * height;
    }

    @Override
    public String toString() {
        return "Hình trụ có đáy là hình tròn có "
                + super.toString()
                + " và có chiều cao "
                + getHeight();
    }
}
