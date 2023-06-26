package View;

import Common.FuncFileCSV;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> listStudent = new ArrayList<Student>();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("1. Add new Student");
        System.out.println("2. Show Information Student");
        System.out.println("3. Exit");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                addNewStudent();
                break;
            case "2":
                showInformationStudent();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Fail! Please choose again! Enter to continue");
                scanner.nextLine();
                displayMainMenu();
        }
    }

    private static void showInformationStudent() {
        listStudent=FuncFileCSV.getFileCSVToListStudent();
        for (Student s:listStudent
             ) {
            System.out.println("--------------------");
            System.out.println("Name: "+s.getName());
            System.out.println("Grade: "+s.getGrade());
            System.out.println("Address: "+s.getAddress());
            System.out.println("--------------------");
            displayMainMenu();
        }
    }

    private static void addNewStudent() {
        listStudent=FuncFileCSV.getFileCSVToListStudent();
        Student student = new Student();
        System.out.println("Enter name Student");
        student.setName(scanner.nextLine());
        System.out.println("Enter grade");
        student.setGrade(scanner.nextLine());
        System.out.println("Enter address");
        student.setAddress(scanner.nextLine());
        listStudent.add(student);
        FuncFileCSV.writeStudentToFileCSV(listStudent);
        displayMainMenu();
    }
}
