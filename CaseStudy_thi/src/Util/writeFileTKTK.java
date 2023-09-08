package Util;

import Module.TaiKhoanTietKiem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeFileTKTK {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_thi\\src\\Data\\TaiKhoanTietKiem.csv";

    public static void writeTKTK(ArrayList<TaiKhoanTietKiem> arrayList) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (TaiKhoanTietKiem t : arrayList
            ) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
