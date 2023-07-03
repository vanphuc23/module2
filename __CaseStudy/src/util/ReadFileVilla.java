package util;

import Module.Villa;

import java.io.*;
import java.util.LinkedHashMap;

public class ReadFileVilla {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\villaFacility.csv";
    public static LinkedHashMap<Villa,Integer> readFile() {
        LinkedHashMap<Villa, Integer> villaIntegerLinkedHashMap = new LinkedHashMap<>();
        File file = new File(PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            Villa villa;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.isEmpty()) {
                    strings=line.split(", ");
                    villa=new Villa();
                    villa.setNameService(strings[0]);
                    villa.setArea(Double.parseDouble(strings[1]));
                    villa.setRetalCosts(Long.parseLong(strings[2]));
                    villa.setPeopleMax(strings[3]);
                    villa.setRentalType(strings[4]);
                    villa.setRoomType(strings[5]);
                    villa.setPoolArea(Double.parseDouble(strings[6]));
                    villa.setFloor(strings[7]);
                    villa.setUse(Integer.parseInt(strings[8]));
                    villaIntegerLinkedHashMap.put(villa,villa.getUse());
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaIntegerLinkedHashMap;
    }
}
