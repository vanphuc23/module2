public class Hien_thi_cac_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(i + "\t");
            }
            count = 0;
        }
    }
}
