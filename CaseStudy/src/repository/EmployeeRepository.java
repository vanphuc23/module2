package repository;

import module.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FILE_EMPLOYEE="D:\\Codegym\\Codegym module2\\CaseStudy\\src\\repository\\employee.csv";
    static LinkedList<Employee> employees = new LinkedList<>();

    static {
        employees.add(new Employee(1, "Nguyễn Văn A", LocalDate.of(2000, 2, 5), "Nam", 123456, 0123456, "abc@gmail.com", "Đại học", "giám sát", 3000000));
        employees.add(new Employee(2, "Nguyễn Văn B", LocalDate.of(2001, 3, 6), "Nữ", 6534124, 64563, "abc@gmail.com", "Đại học", "quản lý", 5000000));
        employees.add(new Employee(3, "Nguyễn Văn C", LocalDate.of(2002, 6, 30), "Nam", 76352, 6753, "abc@gmail.com", "Cao đẳng", "phục vụ", 2200000));
    }

    @Override
    public LinkedList<Employee> display() {
        return employees;
    }

//    @Override
//    public void writeFileEmployee() {
//        File file=new File(FILE_EMPLOYEE);
//        try {
//            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
//            for (Employee e: employees
//                 ) {
//                bufferedWriter.write(e.getEmployeeCode()+","+e.getFullName());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public LinkedList<Employee> readFileEmployee() {
        File file=new File(FILE_EMPLOYEE);
        LinkedList<Employee> employeess = new LinkedList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line="";
            String[] strings;
            Employee employee;
            while ((line= bufferedReader.readLine())!=null) {
                strings = line.split(",");
                employee = new Employee();
                employee.setEmployeeCode(Integer.parseInt(strings[0]));
                employee.setFullName(strings[1]);
                employeess.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeess;
    }
}
