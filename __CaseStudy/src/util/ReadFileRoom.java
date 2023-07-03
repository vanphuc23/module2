package util;

import Module.Room1;

import java.io.*;
import java.util.LinkedHashMap;

public class ReadFileRoom {
    private static final String PATH="D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\roomFacility.csv";
    public static LinkedHashMap<Room1,Integer> readFile() {
        LinkedHashMap<Room1,Integer> room1IntegerLinkedHashMap=new LinkedHashMap<>();
        File file=new File(PATH);
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            Room1 room1;
            while ((line=bufferedReader.readLine())!=null) {
                if(!line.isEmpty()) {
                    strings=line.split(", ");
                    room1=new Room1();
                    room1.setNameService(strings[0]);
                    room1.setArea(Double.parseDouble(strings[1]));
                    room1.setRetalCosts(Long.parseLong(strings[2]));
                    room1.setPeopleMax(strings[3]);
                    room1.setRentalType(strings[4]);
                    room1.setFreeService(strings[5]);
                    room1.setUse(Integer.parseInt(strings[6]));
                    room1IntegerLinkedHashMap.put(room1,room1.getUse());
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return room1IntegerLinkedHashMap;
    }
}
