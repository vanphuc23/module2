package Util;

import Module.TaiKhoanThanhToan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeFileTKTT {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_thi\\src\\Data\\TaiKhoanThanhToan.csv";

    public static void writeTKTT(ArrayList<TaiKhoanThanhToan> arrayList) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (TaiKhoanThanhToan t : arrayList
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
