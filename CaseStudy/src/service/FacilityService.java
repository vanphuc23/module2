package service;

import module.House;
import module.Room;
import module.Villa;
import repository.FacilityRepository;
import repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    IFacilityRepository iFacilityRepository = new FacilityRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        iFacilityRepository.display();
    }

    @Override
    public LinkedHashMap<House, Integer> addHouse() {
        System.out.println("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chi phí thuế: ");
        int cpth = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng người tối đa: ");
        int peopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Nhập số tầng: ");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        House house = new House("House", usableArea, cpth, peopleMax, rentalType, roomStandard, numberFloors);
        iFacilityRepository.findAll().put(house, 1);
        return iFacilityRepository.findAll();
    }

    @Override
    public LinkedHashMap<Room, Integer> addRoom() {
        System.out.println("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chi phí thuế: ");
        int cpth = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng người tối đa: ");
        int peopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
        String freeService = scanner.nextLine();
        Room room = new Room("Room", usableArea, cpth, peopleMax, rentalType, freeService);
        iFacilityRepository.findAllRoom().put(room, 1);
        return iFacilityRepository.findAllRoom();
    }

    @Override
    public LinkedHashMap<Villa, Integer> addVilla() {
        System.out.println("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chi phí thuế: ");
        int cpth = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng người tối đa: ");
        int peopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tầng: ");
        int numberFloors = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa("Villa", usableArea, cpth, peopleMax, rentalType, roomStandard, poolArea, numberFloors);
        iFacilityRepository.findAllVilla().put(villa, 1);
        return iFacilityRepository.findAllVilla();
    }

    @Override
    public void add() {
        int choose;
        do {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("ADD NEW VILLA");
                    addVilla();
                    break;
                case 2:
                    System.out.println("ADD NEW HOUSE");
                    addHouse();
                    break;
                case 3:
                    System.out.println("ADD NEW ROOM");
                    addRoom();
                    break;
            }
        } while (choose >= 1 && choose <= 3);
    }
}
