package util;

import Module.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeWriteFile {
    private static final String path= "D:\\Codegym\\Codegym module2\\CaseStudy_2_1\\src\\data\\Employee.csv";
    public static ArrayList<Employee>WriteFile(ArrayList<Employee> employees){
        File file = new File(path);
        try {
            FileWriter reader = new FileWriter(file, false);
            BufferedWriter buff = new BufferedWriter(reader);
            for(Employee ch:employees){
                buff.write(ch.getMnv()+","+ch.getName()+","+ch.getDate()+","+ch.getGender()+","+ch.getCMND()+","+ch.getSDT()+","+ch.getEmail()+","+ch.getHv()+","+ch.getVitri()+","+ch.getSalary());
                buff.newLine();
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
