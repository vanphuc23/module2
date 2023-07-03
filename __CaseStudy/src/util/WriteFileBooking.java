package util;

import Module.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class WriteFileBooking {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\booking.csv";

    public static void writeFile(TreeSet<Booking> bookings) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Booking b : bookings
            ) {
                bufferedWriter.write(b.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
