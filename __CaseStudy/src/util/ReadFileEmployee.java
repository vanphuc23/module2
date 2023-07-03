package util;

import Module.Employee;

import java.io.*;
import java.util.ArrayList;

public class ReadFileEmployee {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\employee.csv";

    public static ArrayList<Employee> ReadFile() {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            Employee employee;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    employee = new Employee();
                    employee.setEmployeeCode(Integer.parseInt(strings[0]));
                    employee.setFullName(strings[1]);
                    employee.setDate(strings[2]);
                    employee.setGioitinh(strings[3]);
                    employee.setCmnd(strings[4]);
                    employee.setPhone(strings[5]);
                    employee.setEmail(strings[6]);
                    employee.setLevel(strings[7]);
                    employee.setLocation(strings[8]);
                    employee.setWage(Long.parseLong(strings[9]));
                    employees.add(employee);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
