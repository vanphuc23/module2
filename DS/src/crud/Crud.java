package crud;

import java.util.Scanner;

public class Crud {
    static Student[] students = new Student[4];
    static int size;

    static {
        students[0] = new Student(1, "Nguyễn Văn A", 9.6);
        students[1] = new Student(2, "Nguyễn Văn B", 5.6);
        students[2] = new Student(3, "Nguyễn Văn C", 6.7);
        size = 3;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Tạo Học Sinh");
            System.out.println("2. Xem Danh Sách Học Sinh");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Nhấn số bất kỳ khác trên để thoát");

            System.out.println("Mời cưng chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    addNew(students);
                    break;
                case 2:
                    for (int i = 0; i < size; i++) {
                        System.out.printf("Thông tin sinh viên thứ %d:\n", i + 1);
                        System.out.println(students[i]);
                    }
                    break;
                case 3:
                    System.out.println("Bạn đang chọn chức năng Sửa");
                    editStudent(students);
                    break;
                case 4:
                    System.out.println("Bạn đang chọn chức năng Xóa");
                    deleteStudent(students);
            }
        } while (choose >= 1 && choose <= 4);
    }

    public static void addNew(Student[] students) {
        int count = 0;
        System.out.print("Nhập vào số học sinh muốn thêm vào: ");
        int adds = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i] = students[i];
                count++;
            }
        }
        for (int i = 0; i < adds; i++) {
            System.out.println("Thêm học sinh thứ " + (count + 1));
            System.out.println("Nhập tên học sinh: ");
            String newName = scanner.nextLine();
            System.out.println("Nhập điểm của học sinh: ");
            double newScore = Double.parseDouble(scanner.nextLine());
            students[count] = new Student(count + 1, newName, newScore);
            count++;
            size++;
        }
    }

    public static void editStudent(Student[] students) {
        System.out.println("Bạn muốn sửa học sinh ở vị trí thứ: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if ((i + 1) == number) {
                System.out.println("Nhập tên mới của học sinh: ");
                String newName = scanner.nextLine();
                System.out.println("Nhập điểm mới của học sinh: ");
                double newScore = Double.parseDouble(scanner.nextLine());
                students[i].setName(newName);
                students[i].setScore(newScore);
                students[i].getName();
                students[i].getScore();
            }
        }
    }

    public static void deleteStudent(Student[] students) {
        System.out.println("Bạn muốn xóa học sinh ở vị trí thứ: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if ((i + 1) == number) {
                students[i] = null;
                size--;
            }
        }
        for (int i = 0; i < students.length-1; i++) {
            if(students[i]==null) {
                Student temp = students[i + 1];
                students[i+1]=students[i];
                students[i]=temp;
            }
        }
    }
}

