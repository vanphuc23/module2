package util;

import module.DanhBa;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadFileDB {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\CaseStudy_QLDB\\src\\data\\DanhBa.csv";

    public static ArrayList<DanhBa> readFile() {
        File file = new File(PATH);
        ArrayList<DanhBa> arrayList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            DanhBa db;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    db = new DanhBa();
                    db.setPhone(strings[0]);
                    db.setGroup(strings[1]);
                    db.setName(strings[2]);
                    db.setGender(strings[3]);
                    db.setAddress(strings[4]);
                    db.setBirthday(LocalDate.parse(strings[5], formatter));
                    db.setEmail(strings[6]);
                    arrayList.add(db);
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
