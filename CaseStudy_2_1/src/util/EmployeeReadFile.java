package util;

import Module.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeReadFile {
    static ArrayList<Employee> Employee = new ArrayList<>();
    private static final String path= "D:\\Codegym\\Codegym module2\\CaseStudy_2_1\\src\\data\\Employee.csv";
    public static ArrayList<Employee> ReadFile(){
        File file = new File(path);
        BufferedReader bufferedReader;
        try {
             bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line=bufferedReader.readLine())!=null){
                String [] strings = line.split(",");
                Employee employee = new Employee();
                employee.setMnv(Integer.parseInt(strings[0]));
                employee.setName(strings[1]);
                employee.setDate(strings[2]);
                employee.setGender(strings[3]);
                employee.setCMND(strings[4]);
                employee.setSDT(strings[5]);
                employee.setEmail(strings[6]);
                employee.setHv(strings[7]);
                employee.setVitri(strings[8]);
                employee.setSalary(Double.parseDouble(strings[9]));
                Employee.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Employee;
    }

}
