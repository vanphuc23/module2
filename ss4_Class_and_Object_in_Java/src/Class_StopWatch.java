import java.util.Scanner;

public class Class_StopWatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StopWatch watch = new StopWatch();
        int a;
        do {
            System.out.print("Nhập 0 để bắt đầu: ");
            a = Integer.parseInt(sc.nextLine());
            if (a != 0) {
                System.out.println("Phải nhập 0 mới bắt đầu!!!");
            }
        } while (a != 0);
        watch.start();
        int b;
        do {
            System.out.print("Nhập 1 để kết thúc: ");
            b = Integer.parseInt(sc.nextLine());
            if (b != 1) {
                System.out.println("Phải nhập 1 mới kết thúc!!!");
            }
        } while (b != 1);
        watch.stop();
        System.out.print("Thời gian đã trôi qua: " + watch.getElapsedTime() + " mili giây");
    }
}

class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        startTime = 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long elapsed;
        elapsed = (endTime - startTime);
        return elapsed;
    }
}
