import java.io.*;

public class DemoFile {
    public static void main(String[] args) throws IOException {
        String[] a = new String[3];
        a[0]="Macbook";
        a[1]="Acer";
        a[2]="Asus";
        File file=new File("mt.txt");
        OutputStream outputStream=new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
        for(String item:a) {
            outputStreamWriter.write(item);
            outputStreamWriter.write("\n");
            outputStreamWriter.flush();
        }







//        //Khai báo một đối tượng file
//        File file = new File("demo.txt");
//        //Tạo một dòng kết nối với file
//        InputStream inputStream = new FileInputStream(file);
//        //Tạo một đối tượng đọc file với dòng trên
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        //Tạo 1 đối tượng bộ đệm
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String line = "";
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
    }
}
