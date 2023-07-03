package Service;

import Module.House;
import Module.Room1;
import Module.Villa;
import Repository.FacilityRepository;
import Repository.IFacilityRepository;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class FacilityService implements IFacilityService {
    private Scanner scanner = new Scanner(System.in);
    private IFacilityRepository iFacilityRepository = new FacilityRepository();
    private LinkedHashMap<Villa, Integer> villaLinked = iFacilityRepository.displayVilla();
    private LinkedHashMap<House, Integer> houseLinked = iFacilityRepository.displayHouse();
    private LinkedHashMap<Room1, Integer> roomLinked = iFacilityRepository.displayRoom();

    @Override
    public void display() {
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
    }

    @Override
    public void addVilla() {
        double area = AREA();
        long rentalCosts = RENTALCOSTS();
        String peopleMax = PEOPLEMAX();
        String rentalType = RENTALTYPE();
        System.out.println("Tiêu chuẩn phòng");
        String roomType = scanner.nextLine();
        double poolArea = POOL();
        String floor = FLOOR();
        Villa villa = new Villa("Villa" + (villaLinked.size() + 1), area, rentalCosts, peopleMax, rentalType, roomType, poolArea, floor, 0);
        LinkedHashMap<Villa, Integer> linkedHashMap = villaLinked;
        linkedHashMap.put(villa, 0);
        iFacilityRepository.writeVilla(linkedHashMap);
    }

    @Override
    public void addHouse() {
        double area = AREA();
        long rentalCosts = RENTALCOSTS();
        String peopleMax = PEOPLEMAX();
        String rentalType = RENTALTYPE();
        System.out.println("Tiêu chuẩn phòng");
        String roomType = scanner.nextLine();
        String floor = FLOOR();
        House house = new House("House" + (houseLinked.size() + 1), area, rentalCosts, peopleMax, rentalType, roomType, floor, 0);
        LinkedHashMap<House, Integer> linkedHashMap = houseLinked;
        linkedHashMap.put(house, 0);
        iFacilityRepository.writeHouse(linkedHashMap);
    }

    @Override
    public void addRoom() {
        double area = AREA();
        long rentalCosts = RENTALCOSTS();
        String peopleMax = PEOPLEMAX();
        String rentalType = RENTALTYPE();
        System.out.println("Dịch vụ miễn phí đi kèm:");
        String freeService = scanner.nextLine();
        Room1 room1 = new Room1("Room" + (roomLinked.size() + 1), area, rentalCosts, peopleMax, rentalType, freeService, 0);
        LinkedHashMap<Room1, Integer> linkedHashMap = roomLinked;
        linkedHashMap.put(room1, 0);
        iFacilityRepository.writeRoom(linkedHashMap);
    }

    private double AREA() {
        double area;
        while (true) {
            try {
                System.out.println("Nhập diện tích sử dụng:");
                area = Double.parseDouble(scanner.nextLine());
                return area;
            } catch (NumberFormatException n) {
                System.out.println("Nhập sai định dạng!!!");
            }
        }
    }

    private long RENTALCOSTS() {
        long rental;
        while (true) {
            try {
                System.out.println("Nhập chi phí thuê:");
                rental = Long.parseLong(scanner.nextLine());
                return rental;
            } catch (NumberFormatException n) {
                System.out.println("Nhập sai định dạng!!!");
            }
        }
    }

    private String PEOPLEMAX() {
        String people;
        while (true) {
            System.out.println("Nhập số lượng người tối đa");
            people = scanner.nextLine();
            String mp = "^[1-9]$";
            if (Pattern.matches(mp, people)) {
                return people;
            } else {
                System.out.println("Dịch vụ có tối đa 9 người");
            }
        }
    }

    private String RENTALTYPE() {
        int choose;
        String type;
        while (true) {
            System.out.println("======= Kiểu thuê =======");
            System.out.println("1. Thuê theo năm");
            System.out.println("2. Thuê theo tháng");
            System.out.println("3. Thuê theo ngày");
            System.out.println("4. Thuê theo giờ");
            try {
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        type = "Thuê theo năm";
                        return type;
                    case 2:
                        type = "Thuê theo tháng";
                        return type;
                    case 3:
                        type = "Thuê theo ngày";
                        return type;
                    case 4:
                        type = "Thuê theo giờ";
                        return type;
                }
            } catch (NumberFormatException n) {
                System.out.println("Nhập sai định dạng!!!");
            }
        }
    }

    private double POOL() {
        double area;
        while (true) {
            try {
                System.out.println("Nhập diện tích hồ bơi:");
                area = Double.parseDouble(scanner.nextLine());
                return area;
            } catch (NumberFormatException n) {
                System.out.println("Nhập sai định dạng!!!");
            }
        }
    }

    private String FLOOR() {
        String fl;
        while (true) {
            System.out.println("Nhập số tầng:");
            fl = scanner.nextLine();
            String mp = "^[1-6]$";
            if (Pattern.matches(mp, fl)) {
                return fl;
            } else {
                System.out.println("Villa có tối đa 6 tầng!!!");
            }
        }
    }
}
