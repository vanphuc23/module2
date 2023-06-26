package Demerging;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Manager> nu = new LinkedList<>();
        Queue<Manager> nam = new LinkedList<>();
        Manager[] manager = new Manager[4];
        manager[0] = new Manager("Nguyễn Văn A", "Nam", 21);
        manager[1] = new Manager("Nguyễn Văn B", "Nam", 12);
        manager[2] = new Manager("Nguyễn Văn C", "Nữ", 30);
        manager[3] = new Manager("Nguyễn Văn D", "Nữ", 15);
        for (int i = 0; i < manager.length - 1; i++) {
            for (int j = i + 1; j < manager.length; j++) {
                if (manager[i].getDate() > manager[j].getDate()) {
                    Manager temp = manager[i];
                    manager[i] = manager[j];
                    manager[j] = temp;
                }
            }
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i].getGioitinh().equals("Nam")) {
                nam.add(manager[i]);
            } else {
                nu.add(manager[i]);
            }
        }
        while (!nu.isEmpty()) {
            System.out.println(nu.remove());
        }
        while (!nam.isEmpty()) {
            System.out.println(nam.remove());
        }
    }
}
