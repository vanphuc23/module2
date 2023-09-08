package Util;

import Module.TaiKhoanThanhToan;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class readFileTKTT {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_thi\\src\\Data\\TaiKhoanThanhToan.csv";

    public static ArrayList<TaiKhoanThanhToan> readTKTT() {
        File file = new File(PATH);
        ArrayList<TaiKhoanThanhToan> arrayList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            TaiKhoanThanhToan tktt;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    tktt = new TaiKhoanThanhToan();
                    tktt.setId(Integer.parseInt(strings[0]));
                    tktt.setCode(strings[1]);
                    tktt.setName(strings[2]);
                    tktt.setStartDay(LocalDate.parse(strings[3], formatter));
                    tktt.setSoThe(strings[4]);
                    tktt.setTienTK(Long.parseLong(strings[5]));
                    arrayList.add(tktt);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
