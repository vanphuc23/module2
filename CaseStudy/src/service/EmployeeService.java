package service;

import module.Employee;
import repository.EmployeeRepository;
import repository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    Scanner scanner = new Scanner(System.in);
    private LinkedList<Employee> employees=iEmployeeRepository.readFileEmployee();
    @Override
    public void display() {
        for (Employee e: employees
             ) {
            System.out.println(e);
        }
    }

    @Override
    public LinkedList<Employee> addEmployee() {
        System.out.println("Nhập Mã nhân viên: ");
        int newEmployeeCode = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iEmployeeRepository.display().size(); i++) {
            if (iEmployeeRepository.display().get(i).getEmployeeCode() == newEmployeeCode) {
                System.out.println("Trùng mã nhân viên!!!");
                return null;
            }
        }
        System.out.println("Nhập họ tên: ");
        String newFullName = scanner.nextLine();
        System.out.println("Nhập năm sinh:");
        int year = Integer.parseInt(scanner.nextLine());
        boolean isRight = false;
        int day;
        int month;
        do {
            System.out.println("Nhập tháng sinh:");
            month = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ngày sinh:");
            day = Integer.parseInt(scanner.nextLine());
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 1 && day <= 31) {
                        isRight = true;
                    } else {
                        System.out.println("Tháng " + month + " chỉ có 31 ngày");
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 1 && day <= 30) {
                        isRight = true;
                    } else {
                        System.out.println("Tháng " + month + " chỉ có 30 ngày");
                    }
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        if (day >= 1 && day <= 29) {
                            isRight = true;
                        } else {
                            System.out.println("Năm " + year + " là năm nhuận nên tháng 2 có 29 ngày");
                        }
                    } else {
                        if (day >= 1 && day <= 28) {
                            isRight = true;
                        } else {
                            System.out.println("Tháng 2 chỉ có 28 ngày");
                        }
                    }
                    break;
                default:
                    System.out.println("Một năm chỉ có 12 tháng");
                    break;
            }
        } while (!isRight);
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Nhập giới tính:");
        String newGioitinh = scanner.nextLine();
        System.out.println("Nhập cmnd:");
        long newCmnd = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập sđt:");
        long newPhone = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập email:");
        String newEmail = scanner.nextLine();
//        System.out.println("Nhập Trình độ học vấn:");
        String newLevel;
        int choose;
        do {
            System.out.println("====Chọn trình độ học vấn====");
            System.out.println("1. Trung cấp");
            System.out.println("2. Cao Đẳng");
            System.out.println("3. Đại học");
            System.out.println("4. Sau đại học");
            newLevel = scanner.nextLine();
            choose = Integer.parseInt(newLevel);
            switch (choose) {
                case 1:
                    newLevel = "Trung đẳng";
                    break;
                case 2:
                    newLevel = "Cao đẳng";
                    break;
                case 3:
                    newLevel = "Đại học";
                    break;
                case 4:
                    newLevel = "Sau đại học";
                    break;
            }
        } while (choose < 1 || choose > 4);
//        System.out.println("Nhập vị trí làm việc:");
        String newLocation;
        do {
            System.out.println("====Chọn vị trí làm việc====");
            System.out.println("1. Lễ tân");
            System.out.println("2. Phục vụ");
            System.out.println("3. Chuyên viên");
            System.out.println("4. Giám sát");
            System.out.println("5. Quản lý");
            System.out.println("6. Giám đốc");
            newLocation = scanner.nextLine();
            choose = Integer.parseInt(newLocation);
            switch (choose) {
                case 1:
                    newLocation = "Lễ tân";
                    break;
                case 2:
                    newLocation = "Phục vụ";
                    break;
                case 3:
                    newLocation = "Chuyên viên";
                    break;
                case 4:
                    newLocation = "Giám sát";
                    break;
                case 5:
                    newLocation = "Quản lý";
                    break;
                case 6:
                    newLocation = "Giám đốc";
            }
        } while (choose < 1 || choose > 6);
        System.out.println("Nhập mức lương:");
        long newWage = Long.parseLong(scanner.nextLine());
        Employee employee = new Employee(newEmployeeCode, newFullName, date, newGioitinh, newCmnd, newPhone, newEmail, newLevel, newLocation, newWage);
        iEmployeeRepository.display().add(employee);
        return iEmployeeRepository.display();
    }

    @Override
    public LinkedList<Employee> editEmployee() {
        System.out.println("Nhập mã nhân viên bạn muốn chỉnh sửa:");
        int employeeCode = Integer.parseInt(scanner.nextLine());
//        int index = -1;
//        for (int i = 0; i < iEmployeeRepository.display().size(); i++) {
//            if (employeeCode == iEmployeeRepository.display().get(i).getEmployeeCode()) {
//                index = i;
//            } else {
//                System.out.println("Không tồn tại mã nhân viên " + employeeCode + " trong danh sách!!!");
//                return null;
//            }
//        }
        System.out.println("Nhập họ tên: ");
        String newFullName = scanner.nextLine();
        System.out.println("Nhập năm sinh:");
        int year = Integer.parseInt(scanner.nextLine());
        boolean isRight = false;
        int day;
        int month;
        do {
            System.out.println("Nhập tháng sinh:");
            month = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ngày sinh:");
            day = Integer.parseInt(scanner.nextLine());
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 1 && day <= 31) {
                        isRight = true;
                    } else {
                        System.out.println("Tháng " + month + " chỉ có 31 ngày");
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 1 && day <= 30) {
                        isRight = true;
                    } else {
                        System.out.println("Tháng " + month + " chỉ có 30 ngày");
                    }
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        if (day >= 1 && day <= 29) {
                            isRight = true;
                        } else {
                            System.out.println("Năm " + year + " là năm nhuận nên tháng 2 có 29 ngày");
                        }
                    } else {
                        if (day >= 1 && day <= 28) {
                            isRight = true;
                        } else {
                            System.out.println("Tháng 2 chỉ có 28 ngày");
                        }
                    }
                    break;
                default:
                    System.out.println("Một năm chỉ có 12 tháng");
                    break;
            }
        } while (!isRight);
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("Nhập giới tính:");
        String newGioitinh = scanner.nextLine();
        System.out.println("Nhập cmnd:");
        long newCmnd = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập sđt:");
        long newPhone = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập email:");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập Trình độ học vấn:");
        String newLevel = scanner.nextLine();
        System.out.println("Nhập vị trí làm việc:");
        String newLocation = scanner.nextLine();
        System.out.println("Nhập mức lương:");
        long newWage = Long.parseLong(scanner.nextLine());
        Employee employee = new Employee(employeeCode, newFullName, date, newGioitinh, newCmnd, newPhone, newEmail, newLevel, newLocation, newWage);
        for (int i = 0; i < iEmployeeRepository.display().size(); i++) {
            if (employeeCode == iEmployeeRepository.display().get(i).getEmployeeCode()) {
                iEmployeeRepository.display().set(i, employee);
                return iEmployeeRepository.display();
            }
        }
        System.out.println("Không tồn tại mã nhân viên " + employeeCode + " trong danh sách!!!");
        return null;
    }
}
