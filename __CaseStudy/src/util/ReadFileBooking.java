package util;


import Module.Booking;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class ReadFileBooking {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\booking.csv";

    public static TreeSet<Booking> readFile() {
        TreeSet<Booking> bookings = new TreeSet<>();
        File file = new File(PATH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line=bufferedReader.readLine();
            int id;
            String idService;
            String[] strings;
            while (line!=null) {
                strings=line.split(", ");
                id=Integer.parseInt(strings[0]);
                LocalDate start=LocalDate.parse(strings[1],formatter);
                LocalDate end=LocalDate.parse(strings[2],formatter);
                idService=strings[3];
                Booking booking=new Booking(id,start,end,idService);
                bookings.add(booking);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }
}
