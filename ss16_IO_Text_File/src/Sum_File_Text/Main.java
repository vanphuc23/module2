package Sum_File_Text;

import java.io.*;

public class Main {
    private static final String PATH = "D:\\Codegym\\Codegym module2\\ss16_IO_Text_File\\src\\Sum_File_Text\\sum.txt";

    public static void main(String[] args) {
        readFileText();
    }

    public static void readFileText() {
        File file = new File(PATH);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng= "+sum);
        } catch (FileNotFoundException e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        } catch (IOException e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }catch (NumberFormatException e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
}
