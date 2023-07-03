package util;

import Module.Villa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class WriteFileVilla {
    private static final String PATH="D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\villaFacility.csv";
    public static void writeFile(LinkedHashMap<Villa,Integer> villa) {
        File file=new File(PATH);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,false));
            Set<Villa> villaSet=villa.keySet();
            for (Villa v: villaSet) {
                bufferedWriter.write(v.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
