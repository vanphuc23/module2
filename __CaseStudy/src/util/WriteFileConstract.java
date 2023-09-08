package util;

import Module.Constract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class WriteFileConstract {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\__CaseStudy\\src\\Data\\Constracts.csv";

    public static void writeFile(Queue<Constract> queue) {
        File file = new File(PATH);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false));
            for (Constract c : queue
            ) {
                bufferedWriter.write(c.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
