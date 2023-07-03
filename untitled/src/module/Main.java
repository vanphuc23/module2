package module;


import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String PATH="D:\\Codegym\\Codegym module2\\untitled\\src\\module\\abc.csv";
    public static void main(String[] args) {
        readFile();
    }
    private static void writeFile(ArrayList<Abc> a) {
        File file=new File(PATH);
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,false));
            for (Abc b: a
                 ) {
                bufferedWriter.write(b.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<Abc> readFile() {
        File file=new File(PATH);
        ArrayList<Abc> a =new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;
            Abc b=new Abc();
            String[] strings;
            while ((line= bufferedReader.readLine())!=null) {
                if(!line.isEmpty()) {
                    strings = line.split(",");
                    b.setUse(Integer.parseInt(strings[0])+1);
                    if(b.getUse()>5) {
                        System.out.println("BẢO TRÌ");
                        b.setUse(5);
                    }
                    a.add(b);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}

