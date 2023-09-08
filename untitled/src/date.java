import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class date {
    private static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) {
        String name=NAME();

    }
    private static String NAME() {
        String name;
        String newName;
        boolean right=true;
        while (right) {
            System.out.println("Nhập họ tên:");
            name=scanner.nextLine();
            String mp="^[A-Z][a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+$";
            String[] strings=name.split(" ");
            int count=0;
            for (int i = 0; i < strings.length; i++) {
                if(!Pattern.matches(mp,strings[i])) {
                    count++;
                }
            }
            if(count!=0) {
                System.out.println("Nhập lại");
            }else {
                for (int i = 0; i < strings.length; i++) {
                    right=false;
                }
            }

//            String mp="^[A-Z][a-z][a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\ ]+$";
//            String mp="^(^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$)";
        }
        return "";
    }
}
