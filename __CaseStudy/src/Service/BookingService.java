package Service;

import Module.*;
import Repository.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingService implements IBookingService {
    Scanner scanner = new Scanner(System.in);
    private ICustomerRepository customers = new CustomerRepository();
    private ArrayList<Customer> customerList = customers.findAll();
    private IFacilityRepository iFacilityRepository = new FacilityRepository();
    private IConstractRepository iConstractRepository = new ConstractRepository();
    private LinkedHashMap<Villa, Integer> villaLinked = iFacilityRepository.displayVilla();
    private LinkedHashMap<House, Integer> houseLinked = iFacilityRepository.displayHouse();
    private LinkedHashMap<Room1, Integer> roomLinked = iFacilityRepository.displayRoom();
    private IBookingRepository iBookingRepository = new BookingRepository();
    private TreeSet<Booking> bookings = iBookingRepository.display();
    private Queue<Constract> queue = iConstractRepository.findAll();

    @Override
    public void addBooking() {
        int idCustomer = IDCUSTOMER();
        String idService = IDSERVICE();
        LocalDate start;
        LocalDate end;
        boolean right = true;
        do {
            start = birthday();
            end = birthday();
            if (end.isAfter(start)) {
                right = false;
            }
        } while (right);
        Booking b = new Booking(idCustomer, start, end, idService);
        TreeSet<Booking> booking = bookings;
        booking.add(b);
        iBookingRepository.write(booking);
    }

    @Override
    public void show() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Booking b : bookings
        ) {
            System.out.println("Mã khách hàng: " + b.getIdCustomer() + ", " + "Ngày bắt đầu: " + formatter.format(b.getStart()) + ", " + "Ngày kết thúc: " + formatter.format(b.getEnd()) + ", " + "Tên dịch vụ: " + b.getIdService());
        }
    }

    @Override
    public void createConstract() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Constract c = new Constract(queue.size() + 1, bookings.last().getIdCustomer(), bookings.last().getStart(), bookings.last().getEnd(), bookings.last().getIdService());
        queue.add(c);
        Booking booking = new Booking(bookings.last().getIdCustomer(), bookings.last().getStart(), bookings.last().getEnd(), bookings.last().getIdService());
        TreeSet<Booking> treeSet = bookings;
        treeSet.pollLast();
        iBookingRepository.write(treeSet);
        System.out.println("========HỢP ĐỒNG========");
        System.out.println("Mã hợp đồng: " + c.getIdConstract() + ", " + "Mã khách hàng: " + c.getIdCustomer() + ", " + "Ngày bắt đầu: " + formatter.format(c.getStartDB()) + ", " + "Ngày kết thúc: " + formatter.format(c.getEndDB()) + ", " + "Tên dịch vụ: " + c.getIdService());
        iConstractRepository.write(queue);
    }

    @Override
    public void displayConstracts() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("==========DANH SÁCH HỢP ĐỒNG==========");
        for (Constract c : queue
        ) {
            System.out.println("Mã hợp đồng: " + c.getIdConstract() + ", " + "Mã khách hàng: " + c.getIdCustomer() + ", " + "Ngày bắt đầu: " + formatter.format(c.getStartDB()) + ", " + "Ngày kết thúc: " + formatter.format(c.getEndDB()) + ", " + "Tên dịch vụ: " + c.getIdService());
        }
    }

    @Override
    public void editConstract() {
        displayConstracts();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhập mã hợp đồng muốn sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Constract c : queue) {
            if (id == c.getIdConstract()) {
                System.out.println("===Mã hợp đồng sửa===");
                System.out.println("Mã hợp đồng: " + c.getIdConstract() + ", " + "Mã khách hàng: " + c.getIdCustomer() + ", " + "Ngày bắt đầu: " + formatter.format(c.getStartDB()) + ", " + "Ngày kết thúc: " + formatter.format(c.getEndDB()) + ", " + "Tên dịch vụ: " + c.getIdService());
                EDIT(c);
            }
        }
        iConstractRepository.write(queue);
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

    private int IDCUSTOMER() {
        System.out.println("=======Danh sách khách hàng=======");
        for (Customer c : customerList
        ) {
            System.out.println(c);
        }
        while (true) {
            try {
                System.out.println("Chọn mã khách hàng:");
                int code = Integer.parseInt(scanner.nextLine());
                int count = 0;
                for (int i = 0; i < customerList.size(); i++) {
                    if (code == customerList.get(i).getClientCode()) {
                        System.out.println(customerList.get(i));
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Mã khách hàng ko tồn tại!!! Mời nhập lại:");
                } else {
                    return code;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!!");
            }
        }
    }

    private String IDSERVICE() {
        System.out.println("=======Danh sách dịch vụ=======");
        Set<Villa> villaSet = villaLinked.keySet();
        System.out.println("=====Villa Facility=====");
        for (Villa v : villaSet
        ) {
            System.out.println(v.toString());
        }
        Set<House> houseSet = houseLinked.keySet();
        System.out.println("=====House Facility=====");
        for (House h : houseSet
        ) {
            System.out.println(h.toString());
        }
        Set<Room1> room1Set = roomLinked.keySet();
        System.out.println("=====Room Facility=====");
        for (Room1 r : room1Set
        ) {
            System.out.println(r.toString());
        }
        while (true) {
            System.out.println("Chọn mã dịch vụ");
            String choose = scanner.nextLine();
            int dem = 0;
            for (Villa v : villaSet
            ) {
                if (choose.equalsIgnoreCase(v.getNameService())) {
                    System.out.println(v.toString());
                    choose = v.getNameService();
                    v.setUse(v.getUse() + 1);
                    iFacilityRepository.writeVilla(villaLinked);
                    dem++;
                }
            }
            for (House h : houseSet
            ) {
                if (choose.equalsIgnoreCase(h.getNameService())) {
                    System.out.println(h.toString());
                    choose = h.getNameService();
                    h.setUse(h.getUse() + 1);
                    iFacilityRepository.writeHouse(houseLinked);
                    dem++;
                }
            }
            for (Room1 r : room1Set
            ) {
                if (choose.equalsIgnoreCase(r.getNameService())) {
                    System.out.println(r.toString());
                    choose = r.getNameService();
                    r.setUse(r.getUse() + 1);
                    iFacilityRepository.writeRoom(roomLinked);
                    dem++;
                }
            }
            if (dem == 0) {
                System.out.println("Mã dịch vụ không tồn tại");
            } else {

                return choose;
            }
        }
    }

    private void EDIT(Constract c) {
        int choose;
        do {
            System.out.println("===Chọn thông tin muốn sửa===");
            System.out.println("1. Mã khách hàng");
            System.out.println("2. Ngày bắt đầu");
            System.out.println("3. Ngày kết thúc");
            System.out.println("4. Mã dịch vụ");
            System.out.println("5. Exit");
            System.out.println("Chọn thông tin muốn sửa");
            choose = CHOOSE();
            switch (choose) {
                case 1:
                    int idCustomer;
                    System.out.println("Nhập mã khách hàng mới:");
                    idCustomer = CHOOSE();
                    c.setIdCustomer(idCustomer);
                    break;
                case 2:
                    LocalDate start;
                    System.out.println("Nhập ngày bắt đầu mới:");
                    boolean right = true;
                    do {
                        start = birthday();
                        if (c.getEndDB().isAfter(start)) {
                            right = false;
                        } else {
                            System.out.println("Ngày bắt đầu phải trước ngày kết thúc!!!");
                        }
                    } while (right);
                    c.setStartDB(start);
                    break;
                case 3:
                    LocalDate end;
                    System.out.println("Nhập ngày kết thúc mới:");
                    boolean RIGHT = true;
                    do {
                        end = birthday();
                        if (c.getStartDB().isBefore(end)) {
                            RIGHT = false;
                        } else {
                            System.out.println("Ngày kết thúc phải sau ngày bắt đầu!!!");
                        }
                    } while (RIGHT);
                    c.setEndDB(end);
                    break;
                case 4:
                    System.out.println("Nhập mã dịch vụ mới:");
                    String idService = IDSERVICE();
                    c.setIdService(idService);
                    break;
            }
        } while (choose >= 1 && choose <= 4);
    }

    private int CHOOSE() {
        int c;
        while (true) {
            try {
                c = Integer.parseInt(scanner.nextLine());
                return c;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!!Vui lòng nhập lại");
            }
        }
    }
}