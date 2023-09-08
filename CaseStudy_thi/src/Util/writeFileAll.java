package Util;

import Module.TaiKhoanThanhToan;
import Module.TaiKhoanTietKiem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeFileAll {
    private static final String PATH="D:\\Codegym\\Codegym module2\\CaseStudy_thi\\src\\Data\\tk.csv";
    public static void writeAll() {
        File file=new File(PATH);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
            ArrayList<TaiKhoanTietKiem> arrayList= readFileTKTK.readTKTK();
            ArrayList<TaiKhoanThanhToan> arrayList1= readFileTKTT.readTKTT();
            for (TaiKhoanTietKiem tk: arrayList
                 ) {
                bufferedWriter.write(tk.toString());
                bufferedWriter.newLine();
            }
            for (TaiKhoanThanhToan tt: arrayList1
                 ) {
                bufferedWriter.write(tt.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
