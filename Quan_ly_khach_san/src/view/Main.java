package view;

import controller.Hotel;
import model.Order;
import model.Room;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User a = new User("Nguyễn Văn A", "2000", "01");
        User b = new User("Nguyễn Văn B", "2001", "02");
        ArrayList<User> users = new ArrayList<>();
        users.add(a);
        users.add(b);

        Room r1 = new Room("TT0105", "VIP", 100);
        Room r2 = new Room("TT0205", "NORMAL", 50);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(r1);
        rooms.add(r2);

        Hotel boss = new Hotel(users, rooms);
        Order client = new Order();
        client.setUser(a);
        client.setRoom(r1);
        client.setCheckin(LocalDate.of(2023, 6, 5));
        client.setCheckout(LocalDate.of(2023, 6, 8));
        Order client2 = new Order();
        client2.setUser(b);
        client2.setRoom(r2);
        client2.setCheckin(LocalDate.of(2023, 6, 5));
        client2.setCheckout(LocalDate.of(2023, 6, 6));
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(client);
        orders.add(client2);

        boss.setOrderList(orders);
        System.out.println(boss.getAllTotal());
    }
}

