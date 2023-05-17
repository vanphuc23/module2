

public class Class_Fan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 10, "yellow");
        Fan fan2 = new Fan(2, false, 5, "blue");
        System.out.println(fan1.display());
        System.out.println(fan2.display());
    }
}

class Fan {
    private int speed = 2;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public Fan(int speed, boolean status, double radius, String color) {
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
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

    public boolean turn() {
        if (this.status) {
            this.status = false;
        } else {
            this.status = true;
        }
        return this.status;
    }

    public String display() {
        if (this.status) {
            return String.format("Quạt đang bật, tốc độ %d,màu %s, và bán kính %f, 'Fan is on'", this.speed, color, radius);
        } else {
            return String.format("Quạt đang tắt, màu %s, và bán kính %f, 'Fan is off'", color, radius);
        }

    }

    public int speedUp() {
        if (this.speed >= 1 && this.speed < 3) {
            this.speed++;
        } else {
            System.out.println("Tốc độ lớn nhất bằng 3 và nhỏ nhất bằng 1.");
        }
        return this.speed;
    }

    public int speedDown() {
        if (this.speed > 1 && this.speed <= 3) {
            this.speed--;
        } else {
            System.out.println("Tốc độ lớn nhất bằng 3 và nhỏ nhất bằng 1.");
        }
        return this.speed;
    }
}
