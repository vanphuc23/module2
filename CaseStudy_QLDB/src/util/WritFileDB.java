package util;

import module.DanhBa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritFileDB {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_QLDB\\src\\data\\DanhBa.csv";

    public static void writeFile(ArrayList<DanhBa> arrayList) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (DanhBa d : arrayList
            ) {
                bufferedWriter.write(d.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
