package util;

import Module.House;

import java.io.*;
import java.util.LinkedHashMap;

public class ReadFileHouse {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\houseFacility.csv";

    public static LinkedHashMap<House, Integer> readFile() {
        LinkedHashMap<House, Integer> houseIntegerLinkedHashMap = new LinkedHashMap<>();
        File file = new File(PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            House house;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    house = new House();
                    house.setNameService(strings[0]);
                    house.setArea(Double.parseDouble(strings[1]));
                    house.setRetalCosts(Long.parseLong(strings[2]));
                    house.setPeopleMax(strings[3]);
                    house.setRentalType(strings[4]);
                    house.setRoomType(strings[5]);
                    house.setFloor(strings[6]);
                    house.setUse(Integer.parseInt(strings[7]));
                    houseIntegerLinkedHashMap.put(house, house.getUse());
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return houseIntegerLinkedHashMap;
    }
}
