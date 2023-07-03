package util;
import Module.Room1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;


public class WriteFileRoom {
    private static final String PATH="D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\roomFacility.csv";
    public static void writeFile(LinkedHashMap<Room1,Integer> room1) {
        File file=new File(PATH);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
            Set<Room1> room1Set= room1.keySet();
            for (Room1 r:room1Set
                 ) {
                bufferedWriter.write(r.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
