package Common;

import model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER_STUDENT = "name,grade,address";
    private static final String fileNameStudent = "D:\\Codegym\\Codegym module2\\Doc_File_CSV\\src\\Data\\Data";

    public static void writeStudentToFileCSV(ArrayList<Student> listStudent) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameStudent);
            fileWriter.append(FILE_HEADER_STUDENT);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Student s : listStudent
            ) {
                fileWriter.append(s.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(s.getGrade());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(s.getAddress());
                fileWriter.append(COMMA_DELIMITER);
            }
        } catch (Exception e) {
            System.out.println("Error in Csv Fiile Writer !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static ArrayList<Student> getFileCSVToListStudent() {
        BufferedReader br = null;
        ArrayList<Student> listStudent = new ArrayList<Student>();
        Path path= Paths.get(fileNameStudent);
        if(!Files.exists(path)) {
            try {
                Writer writer=new FileWriter(fileNameStudent);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameStudent));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("name")) {
                    continue;
                }
                Student student = new Student();
                student.setName(splitData[0]);
                student.setGrade(splitData[1]);
                student.setAddress(splitData[2]);
                listStudent.add(student);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listStudent;
    }
}
