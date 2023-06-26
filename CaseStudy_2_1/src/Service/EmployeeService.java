package Service;

import Module.Employee;
import Repository.EmployeeReposity;
import Repository.IEmployeeReposity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.regex.Pattern;

public class EmployeeService implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeReposity employeereposity = new EmployeeReposity();
    static ArrayList<Employee> employee = employeereposity.findAll();

    @Override
    public void display() {
        for (Employee ch : employee) {
            System.out.println(ch);
        }
    }

    @Override
    public void add() {
        System.out.println("Họ tên");
        String nameIn = scanner.nextLine();
        String gender1 = Gender();
        String strDate1 = Date();
        String CMND = CMND();
        String SDT1 = SDT();
        String email1 = Email();
        String hv = TD();
        String VT = VT();
        System.out.println("Nhập vào lương: ");
        double salarynew = Double.parseDouble(scanner.nextLine());
        Employee employeenew = new Employee(employeereposity.getSize() + 1, nameIn, strDate1, gender1, CMND, SDT1, email1, VT, hv, salarynew);
        employee.add(employeenew);
        ArrayList<Employee> employeeadd = employeereposity.readFromFile(employee);
        for (Employee ch : employeeadd) {
            System.out.println(ch);
        }
    }

    @Override
    public void fixInfor() {
        System.out.println("Nhập vào id employee muốn sửa : ");
        int idFixx = Integer.parseInt(scanner.nextLine());
        int choose;
        do {
            System.out.println("Nhập thông tin muốn sửa!!");
            System.out.println("1.Name");
            System.out.println("2. Ngày sinh");
            System.out.println("3.Giới tính");
            System.out.println("4.CMND");
            System.out.println("5.Số điẹn thoại");
            System.out.println("6.Email");
            System.out.println("7.Trình độ");
            System.out.println("8.Vị trí");
            System.out.println("9.Lương");
            System.out.println("10.Dừng");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("input new name: ");
                    String newName = scanner.nextLine();
                    employee.get(idFixx).setName(newName);
                    break;
                case 2:
                    System.out.println("Input new date!!");
                    String strDate1 = Date();
                    employee.get(idFixx).setDate(strDate1);
                    break;
                case 3:
                    System.out.println("Input gender!!");
                    String gender = Gender();
                    employee.get(idFixx).setDate(gender);
                    break;
                case 4:
                    System.out.println("CMND");
                    String cmnd = CMND();
                    employee.get(idFixx).setCMND(cmnd);
                    break;
                case 5:
                    System.out.println("input phone!!!");
                    String newPhone = SDT();
                    employee.get(idFixx).setSDT(newPhone);
                    break;
                case 6:
                    System.out.println("input email!!");
                    String email = Email();
                    employee.get(idFixx).setEmail(email);
                    break;
                case 7:
                    System.out.println("trình độ!!");
                    String td = TD();
                    employee.get(idFixx).setHv(td);
                    break;
                case 8:
                    System.out.println("vị trí !!");
                    String vt = VT();
                    employee.get(idFixx).setVitri(vt);
                    break;
                case 9:
                    System.out.println("Nhập lương : ");
                    String salary = scanner.nextLine();
                    employee.get(idFixx).setName(salary);
                    break;
                case 10:
                    System.out.println("Danh sách sửa !!");
            }

        } while (choose >= 1 && choose < 10);

    }

    public static boolean hopLe(int day, int month, int year) {
        int[] max = {0, 31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31};
        if (day > max[month] && month != 2) {
            return false;
        }
        if (month > 12) {
            return false;
        }
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                if (day <= 29) {
                    return true;
                } else {
                    System.out.println("Năm nhuận nên tháng 2 có 29 ngày !!");
                    return false;
                }
            } else {
                if (day <= 28) {
                    return true;
                } else {
                    System.out.println("Năm không nhuận nên tháng 2 chỉ có 28 ngày !!");
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    public static String CMND() {
        String CMND;
        while (true) {
            System.out.println("Nhập vào CMND: ");
            CMND = scanner.nextLine();
            String mp = "^[0-9]{10}$";
            if (Pattern.matches(mp, CMND)) {
                return CMND;
            } else {
                System.out.println("CMDN k hợp lệ !!");
            }
        }
    }

    public static String SDT() {
        String SDT1;
        while (true) {
            System.out.println("Nhập vào số điện thoại: ");
            SDT1 = scanner.nextLine();
            String mp = "^09\\d{8}$";
            if (Pattern.matches(mp, SDT1)) {
                return SDT1;
            } else {
                System.out.println("Số điện thoại không hợp lệ!");
            }
        }
    }

    public static String Email() {
        String email1;
        while (true) {
            System.out.println("Nhập vào email: ");
            email1 = scanner.nextLine();
            String mp = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com";
            if (Pattern.matches(mp, email1)) {
                return email1;
            } else {
                System.out.println("email không hợp lệ !!");
            }
        }
    }

    public static String TD() {
        String hv1 = "Trung cấp";
        String hv2 = "Cao đẳng";
        String hv3 = "Đại học";
        String hv4 = "Sau đại học";
        String hv;
        while (true) {
            System.out.println("Nhập vào trình độ: ");
            hv = scanner.nextLine();
            if (hv.equals(hv1) || hv.equals(hv2) || hv.equals(hv3) || hv.equals(hv4)) {
                return hv;
            } else {
                System.out.println("Thông tin không hợp lệ");
            }
        }
    }

    public static String VT() {
        String VT0 = "Lễ tân";
        String VT1 = "Phục vụ";
        String VT2 = "Chuyên viên";
        String VT3 = "Giám Sát";
        String VT4 = "Quản lý";
        String VT5 = "Giám đốc";
        String VTO;
        String VT;
        while (true) {
            System.out.println("Nhập vào vị trí: ");
            VT = scanner.nextLine();
            if (VT.equals(VT0) || VT.equals(VT1) || VT.equals(VT2) || VT.equals(VT3) || VT.equals(VT4) || VT.equals(VT5)) {
                return VT;
            } else {
                System.out.println("thông tin không hợp lệ");
            }
        }
    }

    public static String Date() {
        Date date1;
        String strDate1;
        while (true) {
            System.out.println("Nhap ngay: ");
            int day = Integer.parseInt(scanner.nextLine());
            int month;
            while (true) {
                System.out.println("Nhap tháng: ");
                month = Integer.parseInt(scanner.nextLine());
                if (month < 12) {
                    break;
                } else {
                    System.out.println("tháng k hợp lệ!!");
                }
            }
            int year;
            while (true) {
                System.out.println("Nhap năm: ");
                year = Integer.parseInt(scanner.nextLine());
                if (year < 2023) {
                    break;
                } else {
                    System.out.println("tháng không hợp lệ!!");
                }
            }
            if (hopLe(day, month, year)) {
                date1 = new Date(day, month, year);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                strDate1 = formatter.format(date1);
                System.out.println(strDate1);
                return strDate1;
            } else {
                System.out.println("ngày k hợp lệ");
            }

        }

    }

    public static String Gender() {
        String gender1;
        while (true) {
            System.out.println("Nhập vào giới tính: ");
            gender1 = scanner.nextLine();

            if (gender1.equals("nam") || gender1.equals("nữ")) {
                return gender1;

            } else {
                System.out.println("giới tính k hợp lệ !!");

            }
        }
    }
}