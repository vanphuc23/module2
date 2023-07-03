package Repository;

import Module.House;
import Module.Room1;
import Module.Villa;
import util.*;

import java.util.LinkedHashMap;

public class FacilityRepository implements IFacilityRepository {

    @Override
    public LinkedHashMap<Villa, Integer> displayVilla() {
        return ReadFileVilla.readFile();
    }

    @Override
    public LinkedHashMap<House, Integer> displayHouse() {
        return ReadFileHouse.readFile();
    }

    @Override
    public LinkedHashMap<Room1, Integer> displayRoom() {
        return ReadFileRoom.readFile();
    }

    @Override
    public void writeVilla(LinkedHashMap<Villa, Integer> villas) {
        WriteFileVilla.writeFile(villas);
    }

    @Override
    public void writeHouse(LinkedHashMap<House, Integer> houses) {
        WriteFileHouse.writeFile(houses);
    }

    @Override
    public void writeRoom(LinkedHashMap<Room1, Integer> rooms) {
        WriteFileRoom.writeFile(rooms);
    }
}
