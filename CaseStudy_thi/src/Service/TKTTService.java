package Service;


import Module.TaiKhoanThanhToan;
import Module.TaiKhoanTietKiem;
import Repository.TKTKRepository;
import Repository.TKTTRepository;
import Repository.iTKTKRepository;
import Repository.iTKTTRepository;
import Exception.NotFoundBankAccountException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TKTTService implements iTKTTService {
    private iTKTTRepository tktt = new TKTTRepository();
    private iTKTKRepository tktk = new TKTKRepository();
    private ArrayList<TaiKhoanThanhToan> arrayListTT = tktt.findAll();
    private ArrayList<TaiKhoanTietKiem> arrayListTK = tktk.display();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addNew() {
        String code = CODE();
        String name = NAME();
        LocalDate startDay = birthday();
        String soThe = SOTHE();
        long tienTK = TIENTK();
        TaiKhoanThanhToan tt = new TaiKhoanThanhToan(arrayListTK.size() + arrayListTT.size() + 1, code, name, startDay, soThe, tienTK);
        ArrayList<TaiKhoanThanhToan> arrayList = arrayListTT;
        arrayList.add(tt);
        tktt.write(arrayList);
    }

    @Override
    public void deleteTT() {
        int searchId = searchId();
        int index = -1;
        ArrayList<TaiKhoanThanhToan> arrayList = arrayListTT;
        try {
            for (int i = 0; i < arrayListTT.size(); i++) {
                if (arrayListTT.get(i).getId() == searchId) {
                    index = i;
                    arrayList.remove(i);
                    tktt.write(arrayList);
                }
            }
            checkId(index);
        } catch (NotFoundBankAccountException n) {
            System.out.println(n.getMessage());
        }
    }

    @Override
    public void displayTT() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (TaiKhoanTietKiem tk : arrayListTK
        ) {
            System.out.println("ID: " + tk.getId() + ", Mã tài khoản: " + tk.getCode() + ", Tên chủ tài khoản: " + tk.getName() + ", Ngày tạo tài khoản: " + formatter.format(tk.getStartDay()) + ", Số tiền gửi tiết kiệm: " + tk.getMoney() + ", Ngày gửi tiết kiệm: " + formatter.format(tk.getNgayGui()) + ", Lãi suất: " + tk.getLaiSuat() + ", Kì hạn: " + tk.getKiHan());
        }
        for (TaiKhoanThanhToan tt : arrayListTT
        ) {
            System.out.println("ID: " + tt.getId() + ", Mã tài khoản: " + tt.getCode() + ", Tên chủ tài khoản: " + tt.getName() + ", Ngày tạo tài khoản: " + formatter.format(tt.getStartDay()) + ", Số thẻ: " + tt.getSoThe() + ", Số tiền trong tài khoản: " + tt.getTienTK());
        }
    }

    private String CODE() {
        String code;
        while (true) {
            System.out.println("Nhập mã tài khoản:");
            code = scanner.nextLine();
            String mp = "^[0-9]{9}$";
            if (Pattern.matches(mp, code)) {
                return code;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private String NAME() {
        String name;
        while (true) {
            System.out.println("Nhập tên chủ tài khoản:");
            name = scanner.nextLine();
            String mp = "^[A-Z][a-z][a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\ ]+$";
            if (Pattern.matches(mp, name)) {
                return name;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
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

    private String SOTHE() {
        String soThe;
        while (true) {
            System.out.println("Nhập số thẻ:");
            soThe = scanner.nextLine();
            String mp = "^[0-9]{10}$";
            if (Pattern.matches(mp, soThe)) {
                return soThe;
            } else {
                System.out.println("Nhập sai!!! Xin vui lòng nhập lại");
            }
        }
    }

    private long TIENTK() {
        long tienTK;
        while (true) {
            try {
                System.out.println("Nhập số tiền trong tài khoản:");
                tienTK = Long.parseLong(scanner.nextLine());
                return tienTK;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Xin vui lòng nhập lại!!!");
            }
        }
    }

    private void checkId(int id) throws NotFoundBankAccountException {
        if (id == -1) {
            throw new NotFoundBankAccountException("Mã tài khoản ngân hàng không tồn tại!!! Nhập lại\n" +
                    "==========================================");

        } else {
            System.out.println("Xóa thành công");
        }
    }

    private int searchId() {
        while (true) {
            try {
                System.out.println("Nhập mã tài khoản ngân hàng: ");
                int searchId = Integer.parseInt(scanner.nextLine());
                return searchId;
            } catch (Exception e) {
                System.out.println("Nhập sai phông chữ!!! Xin vui lòng nhập lại");
            }
        }
    }
}
