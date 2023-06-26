package Read_FileCSV;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String FilePath="D:\\Codegym\\Codegym module2\\ss16_IO_Text_File\\src\\Read_FileCSV\\country.text";
    public static void main(String[] args) {
        ArrayList<Country> arrayList=new ArrayList<>();
        arrayList.add(new Country(1,"AU","Australia"));
        arrayList.add(new Country(2,"CN","China"));
        arrayList.add(new Country(3,"AU","Australia"));
        arrayList.add(new Country(4,"CN","China"));
        File file=new File(FilePath);
//        BufferedWriter bufferedWriter=null;
//        try {
//            bufferedWriter=new BufferedWriter(new FileWriter(file));
//            for (Country c: arrayList
//                 ) {
//                bufferedWriter.write(c.getId()+","+c.getCode()+","+c.getName());
//                bufferedWriter.newLine();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(bufferedWriter!=null) {
//                    bufferedWriter.close();
//                }
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line="";
            String[] strings;
            Country country=new Country();
            while ((line= bufferedReader.readLine())!=null) {
                strings=line.split(",");
                country.setId(Integer.parseInt(strings[0]));
                country.setCode(strings[1]);
                country.setName(strings[2]);
                System.out.println(country);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
