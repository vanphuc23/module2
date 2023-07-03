package util;

import Module.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFileEmployee {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\employee.csv";

    public static void WriteFile(ArrayList<Employee> employees) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false));
            for (Employee e : employees) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
