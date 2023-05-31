package repository;

import model.Student;

import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    static Scanner scanner = new Scanner(System.in);
    static Student[] students = new Student[100];
    static int size = 0;

    static {
        students[0] = new Student(1, "Nguyễn Văn A", 9.6);
        students[1] = new Student(2, "Nguyễn Văn B", 5.6);
        students[2] = new Student(3, "Nguyễn Văn C", 6.7);
        size = 3;
    }

    @Override
    public Student[] findAll() {
        return students;
    }

    public int getSize() {
        return size;
    }

    public int upSize() {
        return size++;
    }

    public int downSize() {
        return size--;
    }

    //    public void save(Student student) {
//        students[size] = student;
//        size++;
//    }
    public Student[] deleteStudent() {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i] == null) {
                Student temp = students[i + 1];
                students[i + 1] = students[i];
                students[i] = temp;
            }
        }
        return students;
    }
}
