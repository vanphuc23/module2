package Repository;

import Module.House;
import Module.Room1;
import Module.Villa;

import java.util.LinkedHashMap;

public interface IFacilityRepository {
    LinkedHashMap<Villa,Integer> displayVilla();
    LinkedHashMap<House,Integer> displayHouse();
    LinkedHashMap<Room1,Integer> displayRoom();
    void writeVilla(LinkedHashMap<Villa,Integer> villas);
    void writeHouse(LinkedHashMap<House,Integer> houses);
    void writeRoom(LinkedHashMap<Room1,Integer> rooms);
}
