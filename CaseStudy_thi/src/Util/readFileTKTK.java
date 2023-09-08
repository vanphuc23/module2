package Util;

import Module.TaiKhoanTietKiem;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class readFileTKTK {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_thi\\src\\Data\\TaiKhoanTietKiem.csv";

    public static ArrayList<TaiKhoanTietKiem> readTKTK() {
        File file = new File(PATH);
        ArrayList<TaiKhoanTietKiem> arrayList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] strings;
            TaiKhoanTietKiem tktk;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    tktk = new TaiKhoanTietKiem();
                    tktk.setId(Integer.parseInt(strings[0]));
                    tktk.setCode(strings[1]);
                    tktk.setName(strings[2]);
                    tktk.setStartDay(LocalDate.parse(strings[3], dateTimeFormatter));
                    tktk.setMoney(Long.parseLong(strings[4]));
                    tktk.setNgayGui(LocalDate.parse(strings[5], dateTimeFormatter));
                    tktk.setLaiSuat(strings[6]);
                    tktk.setKiHan(strings[7]);
                    arrayList.add(tktk);
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
