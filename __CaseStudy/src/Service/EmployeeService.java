package Service;

import Module.Employee;
import Repository.EmployeeRepository;
import Repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeService implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    private ArrayList<Employee> employeeList = iEmployeeRepository.findAll();

    @Override
    public void display() {
        for (Employee e : employeeList
        ) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Employee> addEmployee() {
        System.out.println("Nhập họ tên:");
        String fullname = scanner.nextLine();
        String date = birthday();
        String gioitinh = gender();
        String cmnd = CMND();
        String phone = SDT();
        String email = Email();
        String level = LEVEL();
        String location = LOCATION();
        System.out.println("Nhập mức lương:");
        long wage = Long.parseLong(scanner.nextLine());
        Employee employee = new Employee(employeeList.size() + 1, fullname, date, gioitinh, cmnd, phone, email, level, location, wage);
        ArrayList<Employee> employees = employeeList;
        employees.add(employee);
        iEmployeeRepository.write(employees);
        return employees;
    }

    private String LEVEL() {
        String level;
        int choose;
        do {
            System.out.println("====Chọn trình độ học vấn====");
            System.out.println("1. Trung cấp");
            System.out.println("2. Cao Đẳng");
            System.out.println("3. Đại học");
            System.out.println("4. Sau đại học");
            level = scanner.nextLine();
            choose = Integer.parseInt(level);
            switch (choose) {
                case 1:
                    level = "Trung đẳng";
                    break;
                case 2:
                    level = "Cao đẳng";
                    break;
                case 3:
                    level = "Đại học";
                    break;
                case 4:
                    level = "Sau đại học";
                    break;
            }
        } while (choose < 1 || choose > 4);
        return level;
    }

    private String LOCATION() {
        int choose;
        String location;
        do {
            System.out.println("====Chọn vị trí làm việc====");
            System.out.println("1. Lễ tân");
            System.out.println("2. Phục vụ");
            System.out.println("3. Chuyên viên");
            System.out.println("4. Giám sát");
            System.out.println("5. Quản lý");
            System.out.println("6. Giám đốc");
            location = scanner.nextLine();
            choose = Integer.parseInt(location);
            switch (choose) {
                case 1:
                    location = "Lễ tân";
                    break;
                case 2:
                    location = "Phục vụ";
                    break;
                case 3:
                    location = "Chuyên viên";
                    break;
                case 4:
                    location = "Giám sát";
                    break;
                case 5:
                    location = "Quản lý";
                    break;
                case 6:
                    location = "Giám đốc";
            }
        } while (choose < 1 || choose > 6);
        return location;
    }

    private String birthday() {
        int date = tryDate();
        int month = tryMonth();
        date = monthBirth(month, date);
        int year = tryYear();
        if (month == 2) {
            date = yearBirth(date, month, year);
        }
        return date + "/" + month + "/" + year;
    }

    private int tryDate() {
        try {
            System.out.println("Nhập ngày sinh:");
            int date = Integer.parseInt(scanner.nextLine());
            date = dayBirth(date);
            return date;
        } catch (Exception e) {
            System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
            tryDate();
        }
        return 0;
    }

    private int tryMonth() {
        try {
            boolean isDate = false;
            int month;
            do {
                System.out.println("Nhập tháng sinh:");
                month = Integer.parseInt((scanner.nextLine()));
                if (month >= 1 && month <= 12) {
                    isDate = true;
                    return month;
                } else {
                    System.out.println("Một năm chỉ có 12 tháng!!!");
                }
            } while (!isDate);
        } catch (Exception e) {
            System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
            tryMonth();
        }
        return 0;
    }

    private int tryYear() {
        try {
            System.out.println("Nhập năm sinh:");
            int year = Integer.parseInt(scanner.nextLine());
            return year;
        } catch (Exception e) {
            System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
            tryYear();
        }
        return 0;
    }

    private int dayBirth(int date) {
        boolean isDate = false;
        do {
            if (date < 1 || date > 31) {
                System.out.println("1 tháng có tối đá 31 ngày!!!");
                try {
                    System.out.println("Nhập ngày sinh:");
                    date = Integer.parseInt(scanner.nextLine());
                    if (date >= 1 && date <= 31) {
                        isDate = true;
                        return date;
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
                }
            } else {
                return date;
            }
        } while (!isDate);
        return 0;
    }

    private int monthBirth(int month, int date) {
        boolean isDate = false;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                do {
                    try {
                        if (date < 1 || date > 31) {
                            System.out.println("Tháng " + month + " chỉ có 31 ngày!!!");
                            System.out.println("Nhập ngày sinh:");
                            date = Integer.parseInt(scanner.nextLine());
                        } else {
                            isDate = true;
                            return date;
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
                    }
                } while (!isDate);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                do {
                    try {
                        if (date < 1 || date > 30) {
                            System.out.println("Tháng " + month + " chỉ có 30 ngày!!!");
                            System.out.println("Nhập ngày sinh:");
                            date = Integer.parseInt(scanner.nextLine());
                        } else {
                            isDate = true;
                            return date;
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
                    }
                } while (!isDate);
                break;
            case 2:
                do {
                    try {
                        if (date < 1 || date > 29) {
                            System.out.println("Tháng " + month + " chỉ có 29 ngày đối với năm nhuận\nvà chỉ có 20 ngày đối với năm không nhuận!!!");
                            System.out.println("Nhập ngày sinh:");
                            date = Integer.parseInt(scanner.nextLine());
                        } else {
                            isDate = true;
                            return date;
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
                    }
                } while (!isDate);
                break;
        }
        return 0;
    }

    private int yearBirth(int date, int month, int year) {
        boolean isDate = false;
        if (month == 2) {
            do {
                try {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        if (date >= 1 && date <= 29) {
                            isDate = true;
                            return date;
                        } else {
                            System.out.println("Năm " + year + " là năm nhuận nên tháng 2 có 29 ngày");
                            System.out.println("Nhập ngày sinh:");
                            date = Integer.parseInt(scanner.nextLine());
                        }
                    } else {
                        if (date >= 1 && date <= 28) {
                            isDate = true;
                            return date;
                        } else {
                            System.out.println("Tháng 2 chỉ có 28 ngày");
                            System.out.println("Nhập ngày sinh:");
                            date = Integer.parseInt(scanner.nextLine());
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi phông chữ!!! Vui lòng nhập lại!!!!");
                }
            } while (!isDate);
        }
        return 0;
    }

    private String gender() {
        String gender;
        while (true) {
            System.out.println("Nhập giới tính");
            gender = scanner.nextLine();
            if (gender.toLowerCase(Locale.ROOT).equals("nam") || gender.toLowerCase(Locale.ROOT).equals("nữ")) {
                return gender;
            } else {
                System.out.println("Giới tính không hợp lệ!!!");
            }
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

    @Override
    public void editEmployee() {
        int fixId = fixId();
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode() == fixId) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Mã nhân viên không tồn tại!!!");
            return;
        }
        int choose;
        do {
            System.out.println("========== FIX ==========");
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
            System.out.println("Bạn muốn sửa thông tin nào???");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhập tên mới:");
                    String newName = scanner.nextLine();
                    employeeList.get(index).setFullName(newName);
                    break;
                case 2:
                    String newDate = birthday();
                    employeeList.get(index).setDate(newDate);
                    break;
                case 3:
                    String newGender = gender();
                    employeeList.get(index).setGioitinh(newGender);
                    break;
                case 4:
                    String newCmnd = CMND();
                    employeeList.get(index).setCmnd(newCmnd);
                    break;
                case 5:
                    String newPhone = SDT();
                    employeeList.get(index).setPhone(newPhone);
                    break;
                case 6:
                    String newEmail = Email();
                    employeeList.get(index).setEmail(newEmail);
                    break;
                case 7:
                    String newLevel = LEVEL();
                    employeeList.get(index).setLevel(newLevel);
                    break;
                case 8:
                    String newLocation = LOCATION();
                    employeeList.get(index).setLocation(newLocation);
                    break;
                case 9:
                    long newWage = fixWage();
                    employeeList.get(index).setWage(newWage);
                    break;
            }
        } while (choose >= 1 && choose <= 9);
        iEmployeeRepository.write(employeeList);
    }

    private int fixId() {
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên muốn sửa: ");
                int fixId = Integer.parseInt(scanner.nextLine());
                return fixId;
            } catch (Exception e) {
                System.out.println("Nhập sai phông chữ!!! Xin vui lòng nhập lại");
            }
        }
    }

    private long fixWage() {
        while (true) {
            try {
                System.out.println("Nhập lương muốn sửa: ");
                long fixWage = Long.parseLong(scanner.nextLine());
                return fixWage;
            } catch (Exception e) {
                System.out.println("Nhập sai phông chữ!!! Xin vui lòng nhập lại");
            }
        }
    }

    @Override
    public void deleteEmployee() {
        int deleteId = deleteId();
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode() == deleteId) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Mã nhân viên không tồn tại!!!");
            return;
        }
        employeeList.remove(index);
        iEmployeeRepository.write(employeeList);
    }

    private int deleteId() {
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên muốn xóa: ");
                int fixId = Integer.parseInt(scanner.nextLine());
                return fixId;
            } catch (Exception e) {
                System.out.println("Nhập sai phông chữ!!! Xin vui lòng nhập lại");
            }
        }
    }

    @Override
    public void searchEmployee() {
        int searchId = searchId();
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode() == searchId) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Mã nhân viên không tồn tại!!!");
            return;
        }
        System.out.println(employeeList.get(index).toString());
    }

    private int searchId() {
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên muốn tìm kiếm: ");
                int searchId = Integer.parseInt(scanner.nextLine());
                return searchId;
            } catch (Exception e) {
                System.out.println("Nhập sai phông chữ!!! Xin vui lòng nhập lại");
            }
        }
    }
}
