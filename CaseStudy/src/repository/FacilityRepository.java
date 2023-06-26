package repository;

import module.House;
import module.Room;
import module.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FacilityRepository implements IFacilityRepository {
    static LinkedHashMap<House, Integer> houses = new LinkedHashMap<>();

    //    List<Villa> villaList=new LinkedList<>();
//    List<Room> roomList=new LinkedList<>();
    static {
        houses.put(new House("House", 800, 500, 5, "Thuê theo tháng", "Normal", 2), 2);
        houses.put(new House("House", 1000, 800, 4, "Thuê theo tháng", "Normal", 2), 3);
        houses.put(new House("House", 1500, 1000, 6, "Thuê theo năm", "VIP", 3), 1);
    }

    static LinkedHashMap<Room, Integer> rooms = new LinkedHashMap<>();

    static {
        rooms.put(new Room("Room", 500, 400, 3, "Thuê theo tháng", "Đồ ăn free"), 1);
        rooms.put(new Room("Room", 800, 600, 3, "Thuê theo tháng", "Đồ ăn free"), 1);
    }

    static LinkedHashMap<Villa, Integer> villas = new LinkedHashMap<>();

    static {
        villas.put(new Villa("Villa", 1000, 1000, 10, "Thuê theo ngày", "VIP", 200, 4), 1);
        villas.put(new Villa("Villa", 1500, 2000, 15, "Thuê theo ngày", "VIP", 300, 5), 1);
    }

    @Override
    public void display() {
        System.out.println("House:");
        for (Map.Entry<House, Integer> entry : houses.entrySet()
        ) {
            System.out.println(entry.getKey() + "    " + entry.getValue());
        }
        System.out.println("Room");
        for (Map.Entry<Room, Integer> entry : rooms.entrySet()
        ) {
            System.out.println(entry.getKey() + "     " + entry.getValue());
        }
        System.out.println("Villa");
        for (Map.Entry<Villa, Integer> entry : villas.entrySet()
        ) {
            System.out.println(entry.getKey() + "      " + entry.getValue());
        }
    }

    @Override
    public LinkedHashMap<House, Integer> findAll() {
        return houses;
    }

    @Override
    public LinkedHashMap<Room, Integer> findAllRoom() {
        return rooms;
    }

    @Override
    public LinkedHashMap<Villa, Integer> findAllVilla() {
        return villas;
    }
}
