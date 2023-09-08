package util;

import Module.Constract;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReadFileConstract {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\Constracts.csv";

    public static Queue<Constract> readFile() {
        Queue<Constract> queue = new PriorityQueue<>();
        File file = new File(PATH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String[] strings;
            Constract c;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    strings = line.split(", ");
                    c = new Constract();
                    c.setIdConstract(Integer.parseInt(strings[0]));
                    c.setIdCustomer(Integer.parseInt(strings[1]));
                    c.setStartDB(LocalDate.parse(strings[2], formatter));
                    c.setEndDB(LocalDate.parse(strings[3], formatter));
                    c.setIdService(strings[4]);
                    queue.add(c);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return queue;
    }
}
