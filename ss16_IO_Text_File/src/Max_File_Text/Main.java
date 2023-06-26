package Max_File_Text;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String FILE_PATH = "D:\\Codegym\\Codegym module2\\ss16_IO_Text_File\\src\\Max_File_Text\\max.txt";

    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        readFile(number);
        findMax(number);
    }

    public static ArrayList<Integer> readFile(ArrayList<Integer> numbers) {
        File file = new File(FILE_PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static int findMax(ArrayList<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        System.out.println(max);
        return max;
    }
}
