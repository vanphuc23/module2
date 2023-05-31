package model;

public class Student {
    private int id; // biến toàn cục, biến đối tượng
    private String name;
    static int count; // biến static
    private double score;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if ( score < 0 || score > 10) {
            System.out.println("Điểm không hợp lệ");
            // exception
        } else {
            this.score = score;
        }
    }

    static { // Khối static
        count = 110;
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        int x = 2; // biến cục bộ
        this.score = score;
    }

    public void test() {
        int a = 2; // biến cục bộ
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
