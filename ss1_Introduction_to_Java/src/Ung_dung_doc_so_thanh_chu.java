import java.util.Scanner;

public class Ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print("Nhập số: ");
            number = Integer.parseInt(sc.nextLine());
            if (number > 999) {
                System.out.println("Số không được lớn hơn 999!!!");
            }
        } while (number > 999);
        String lessTen = one(number);
        String two = lessTwenty(number);
        String lessHundred = lessOne(number);
        String hundred = oneHundred(number);
        if (number >= 0 && number < 10) {
            System.out.print(lessTen);
        } else if (number >= 10 && number < 20) {
            System.out.print(two);
        } else if (number >= 20 && number < 100) {
            System.out.print(lessHundred);
        } else {
            int tens = (number % 100) / 10;
            int ones = (number % 100) % 10;
            if (tens == 0) {
                String a = one(ones);
                System.out.print(hundred + " and " + a);
            } else if (tens == 1) {
                String b = lessTwenty((number % 100));
                System.out.print(hundred + " and " + b);
            } else {
                String c = lessOne((number % 100));
                System.out.print(hundred + " and " + c);
            }
        }
    }

    public static String one(int n) {
        String n2 = Integer.toString(n);
        switch (n) {
            case 0:
                n2 = "";
                break;
            case 1:
                n2 = "One";
                break;
            case 2:
                n2 = "Two";
                break;
            case 3:
                n2 = "Three";
                break;
            case 4:
                n2 = "Four";
                break;
            case 5:
                n2 = "Five";
                break;
            case 6:
                n2 = "Six";
                break;
            case 7:
                n2 = "Seven";
                break;
            case 8:
                n2 = "Eight";
                break;
            case 9:
                n2 = "Nine";
                break;
            default:
                n2 = "out of ability";
        }
        return n2;
    }

    public static String lessTwenty(int n) {
        n = n % 10;
        String n2 = Integer.toString(n);
        switch (n) {
            case 0:
                n2 = "Ten";
                break;
            case 1:
                n2 = "Eleven";
                break;
            case 2:
                n2 = "Twelve";
                break;
            case 3:
                n2 = "Thirteen";
                break;
            case 4:
                n2 = "Fourteen";
                break;
            case 5:
                n2 = "Fifteen";
                break;
            case 6:
                n2 = "Sixteen";
                break;
            case 7:
                n2 = "Seventeen";
                break;
            case 8:
                n2 = "Eightteen";
                break;
            case 9:
                n2 = "Nineteen";
                break;
        }
        return n2;
    }

    public static String lessOne(int n) {
        int tens = n / 10;
        int ones = n % 10;
        String ten = Integer.toString(tens);
        String one = Integer.toString(ones);
        switch (tens) {
            case 2:
                ten = "Twenty";
                break;
            case 3:
                ten = "Thirty";
                break;
            case 4:
                ten = "Fourty";
                break;
            case 5:
                ten = "Fifty";
                break;
            case 6:
                ten = "Sixty";
                break;
            case 7:
                ten = "Seventy";
                break;
            case 8:
                ten = "Eighty";
                break;
            case 9:
                ten = "Ninety";
                break;
        }
        switch (ones) {
            case 1:
                one = "One";
                break;
            case 2:
                one = "Two";
                break;
            case 3:
                one = "Three";
                break;
            case 4:
                one = "Four";
                break;
            case 5:
                one = "Five";
                break;
            case 6:
                one = "Six";
                break;
            case 7:
                one = "Seven";
                break;
            case 8:
                one = "Eight";
                break;
            case 9:
                one = "Nine";
                break;
            default:
                one = "";
                break;
        }
        return (ten + " " + one);
    }

    public static String oneHundred(int n) {
        n = n / 100;
        String n2 = Integer.toString(n);
        switch (n) {
            case 1:
                n2 = "One hundred";
                break;
            case 2:
                n2 = "Two hundred";
                break;
            case 3:
                n2 = "Three hundred";
                break;
            case 4:
                n2 = "Four hundred";
                break;
            case 5:
                n2 = "Five hundred";
                break;
            case 6:
                n2 = "Six hundred";
                break;
            case 7:
                n2 = "Seven hundred";
                break;
            case 8:
                n2 = "Eight hundred";
                break;
            case 9:
                n2 = "Nine hundred";
                break;
        }
        return n2;
    }
}
