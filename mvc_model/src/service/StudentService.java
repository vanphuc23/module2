package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.Scanner;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        Student[] students = iStudentRepository.findAll();
        for (int i = 0; i < iStudentRepository.getSize(); i++) {
            System.out.printf("Thông tin sinh viên thứ %d:\n", i + 1);
            System.out.println(students[i]);
        }
    }

    public Student[] add() {
        Student[] students = iStudentRepository.findAll();
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
            iStudentRepository.upSize();
        }
        return students;
    }

    public Student[] edit() {
        Student[] students = iStudentRepository.findAll();
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
        return students;
    }

    public void delete() {
        Student[] students = iStudentRepository.findAll();
        System.out.println("Bạn muốn xóa học sinh ở vị trí thứ: ");
        int number = Integer.parseInt(scanner.nextLine());
        if(number<=iStudentRepository.getSize()) {
            for (int i = 0; i < students.length; i++) {
                if ((i + 1) == number) {
                    students[i] = null;
                    iStudentRepository.downSize();
                }
            }
            iStudentRepository.deleteStudent();
        }
    }
}
