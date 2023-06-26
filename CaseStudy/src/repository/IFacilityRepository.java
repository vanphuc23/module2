package repository;

import module.House;
import module.Room;
import module.Villa;

import java.util.LinkedHashMap;

public interface IFacilityRepository {
    void display();

    LinkedHashMap<House, Integer> findAll();

    LinkedHashMap<Room, Integer> findAllRoom();

    LinkedHashMap<Villa, Integer> findAllVilla();
}
