package controller;

import model.Order;
import model.Room;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<User> userList = new ArrayList<>();
    List<Room> roomList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();

    public Hotel(List<User> userList, List<Room> roomList) {
        this.userList = userList;
        this.roomList = roomList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void addNewRoom(Room room) {
        roomList.add(room);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public long getAllTotal() {
        int total = 0;
        for (Order order : orderList
        ) {
            total += order.getTotalPrice();
        }
        return total;
    }
}
