package util;

import Module.House;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class WriteFileHouse {
    private static final String PATH="D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\houseFacility.csv";
    public static void writeFile(LinkedHashMap<House,Integer> house) {
        File file=new File(PATH);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
            Set<House> houseSet= house.keySet();
            for (House h:houseSet
                 ) {
                bufferedWriter.write(h.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
