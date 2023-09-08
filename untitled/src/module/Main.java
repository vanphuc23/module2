package module;


import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    private static final String PATH="D:\\Codegym\\Codegym module2\\untitled\\src\\module\\abc.csv";
    public static void main(String[] args) {
        TreeSet<Abc> treeSet=readFile();
        treeSet.pollLast();
        writeFile(treeSet);
    }
    private static void writeFile(TreeSet<Abc> a) {
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
    private static TreeSet<Abc> readFile() {
        File file=new File(PATH);
        TreeSet<Abc> a =new TreeSet<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line;
            Abc b;
            String[] strings;
            while ((line= bufferedReader.readLine())!=null) {
                if(!line.isEmpty()) {
                    strings = line.split(",");
                    b=new Abc();
                    b.setUse(Integer.parseInt(strings[0]));
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

