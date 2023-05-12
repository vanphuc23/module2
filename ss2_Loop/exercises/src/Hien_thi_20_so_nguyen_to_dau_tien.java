

public class Hien_thi_20_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        for (int i = 1; i <= 20; ) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(num + "\t");
                i++;
            }
            count = 0;
            num++;
        }
    }
}
