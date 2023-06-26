package service;

import module.House;
import module.Room;
import module.Villa;

import java.util.LinkedHashMap;

public interface IFacilityService {
    void display();

    LinkedHashMap<House, Integer> addHouse();

    LinkedHashMap<Room, Integer> addRoom();

    LinkedHashMap<Villa, Integer> addVilla();
    void add();
}
