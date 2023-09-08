package service;

import module.DanhBa;
import repository.DBRepository;
import repository.IDBRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DBService implements IDBService {
    Scanner scanner = new Scanner(System.in);
    private IDBRepository idbRepository = new DBRepository();
    private ArrayList<DanhBa> arrayListDB = idbRepository.findAll();
    private ArrayList<DanhBa> arrayListDB2 = idbRepository.readFileNew();

    @Override
    public void display() {
        for (DanhBa d : arrayListDB
        ) {
            System.out.println("Số điện thoại: " + d.getPhone() + ", " + "Nhóm: " + d.getGroup() + ", " + "Họ tên: " + d.getName() + ", " + "Giới tính: " + d.getGender() + ", " + "Địa chỉ: " + d.getAddress());
        }
    }

    @Override
    public void add() {
        String phone = PHONE();
        String group = GROUP();
        String name = NAME();
        String gender = GENDER();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        LocalDate birthday = birthday();
        String email = EMAIL();
        DanhBa db = new DanhBa(phone, group, name, gender, address, birthday, email);
        ArrayList<DanhBa> arrayList = arrayListDB;
        arrayList.add(db);
        idbRepository.write(arrayList);
    }

    @Override
    public void edit() {
        String phone = SEARCH();
        int choose;
        if (!phone.equals("")) {
            for (DanhBa d : arrayListDB
            ) {
                if (phone.equals(d.getPhone())) {
                    do {
                        System.out.println("========== Chức năng muốn cập nhập ==========");
                        System.out.println("1. Nhóm của danh bạ");
                        System.out.println("2. Họ tên");
                        System.out.println("3. Giới tính");
                        System.out.println("4. Địa chỉ");
                        System.out.println("5. Ngày sinh");
                        System.out.println("6. Email");
                        System.out.println("7. Exit");
                        choose = Integer.parseInt(scanner.nextLine());
                        switch (choose) {
                            case 1:
                                String group = GROUP();
                                d.setGroup(group);
                                break;
                            case 2:
                                String name = NAME();
                                d.setName(name);
                                break;
                            case 3:
                                String gender = GENDER();
                                d.setGender(gender);
                                break;
                            case 4:
                                System.out.println("Nhập địa chỉ:");
                                String address = scanner.nextLine();
                                d.setAddress(address);
                                break;
                            case 5:
                                LocalDate birth = birthday();
                                d.setBirthday(birth);
                                break;
                            case 6:
                                String email = EMAIL();
                                d.setEmail(email);
                                break;
                        }
                    } while (choose >= 1 && choose <= 6);
                }
            }
            idbRepository.write(arrayListDB);
        } else {
            return;
        }
    }

    @Override
    public void delete() {
        String phone = SEARCH();
        ArrayList<DanhBa> arrayList = arrayListDB;
        int choose;
        if (!phone.equals("")) {
            for (int i = 0; i < arrayListDB.size(); i++) {
                if (phone.equals(arrayListDB.get(i).getPhone())) {
                    System.out.println("======== Bạn có muốn xóa hay không ========");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choose = Integer.parseInt(scanner.nextLine());
                    switch (choose) {
                        case 1:
                            arrayList.remove(i);
                            idbRepository.write(arrayList);
                            break;
                        default:
                            break;
                    }
                }
            }
        } else {
            return;
        }
    }

    @Override
    public void search() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String name = NAME();
        String phone = PHONE();
        for (DanhBa d : arrayListDB
        ) {
            if (name.equalsIgnoreCase(d.getName()) || phone.equalsIgnoreCase(d.getPhone())) {
                System.out.println("Số điện thoại: " + d.getPhone() + ", " + "Nhóm: " + d.getGroup() + ", " + "Họ tên: " + d.getName() + ", " + "Giới tính: " + d.getGender() + ", " + "Địa chỉ: " + d.getAddress() + ", " + "Ngày sinh: " + formatter.format(d.getBirthday()) + ", " + "Email: " + d.getEmail());
                return;
            }
        }
        System.out.println("Không tìm thấy!!!");
    }

    @Override
    public void saveFile() {
        int choose;
        System.out.println("======== Bạn có muốn cập nhật File không? ========");
        System.out.println("1. Yes");
        System.out.println("2. No");
        choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                idbRepository.writeFileNew(arrayListDB);
                break;
            case 2:
                System.out.println("Bạn đã chọn không cập nhật File");
                break;
            default:
                break;
        }
    }

    @Override
    public void readFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (DanhBa d : arrayListDB2
        ) {
            System.out.println("Số điện thoại: " + d.getPhone() + ", " + "Nhóm: " + d.getGroup() + ", " + "Họ tên: " + d.getName() + ", " + "Giới tính: " + d.getGender() + ", " + "Địa chỉ: " + d.getAddress() + ", " + "Ngày sinh: " + formatter.format(d.getBirthday()) + ", " + "Email: " + d.getEmail());
        }
    }

    private String PHONE() {
        String p;
        while (true) {
            System.out.println("Nhập số điện thoại: ");
            p = scanner.nextLine();
            String mp = "^[0]{1}[1-9]{9}$";
            if (Pattern.matches(mp, p)) {
                return p;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String PHONE2() {
        String p;
        while (true) {
            System.out.println("Nhập số điện thoại: ");
            p = scanner.nextLine();
            String mp = "^0[1-9]{9}$";
            if (Pattern.matches(mp, p) || p.equals("")) {
                return p;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String GROUP() {
        String g;
        while (true) {
            System.out.println("Nhập nhóm của danh bạ: ");
            g = scanner.nextLine();
            String mp = "^[1-9]{1,2}$";
            if (Pattern.matches(mp, g)) {
                return g;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String NAME() {
        String name;
        while (true) {
            System.out.println("Nhập họ tên:");
            name = scanner.nextLine();
            String mp = "^[A-Z][a-z][a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\ ]+$";
            if (Pattern.matches(mp, name)) {
                return name;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String GENDER() {
        String gender;
        while (true) {
            System.out.println("Nhập giới tính");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ")) {
                return gender;
            } else {
                System.out.println("Giới tính không hợp lệ!!!");
            }
        }
    }

    private LocalDate birthday() {
        int date = tryDate();
        int month = tryMonth();
        date = monthBirth(month, date);
        int year = tryYear();
        if (month == 2) {
            date = yearBirth(date, month, year);
        }
        return LocalDate.of(year, month, date);
    }

    private int tryDate() {
        try {
            System.out.println("Nhập ngày:");
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
                System.out.println("Nhập tháng:");
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
            System.out.println("Nhập năm:");
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
                            System.out.println("Tháng " + month + " chỉ có 29 ngày đối với năm nhuận\nvà chỉ có 28 ngày đối với năm không nhuận!!!");
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

    private String EMAIL() {
        String e;
        while (true) {
            System.out.println("Nhập email: ");
            e = scanner.nextLine();
            String mp = "^[a-zA-Z0-9]+@gmail.com$";
            if (Pattern.matches(mp, e)) {
                return e;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String SEARCH() {
        String str;
        while (true) {
            str = PHONE2();
            for (DanhBa d : arrayListDB
            ) {
                if (str.equals(d.getPhone()) || str.equals("")) {
                    return str;
                }
            }
            System.out.println("Không tìm được danh bạ với số điện thoại trên!!! Vui lòng nhập lại");
        }
    }
}
