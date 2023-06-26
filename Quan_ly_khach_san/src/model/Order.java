package model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class Order {
    private LocalDate checkin;
    private LocalDate checkout;
    private User user;
    private Room room;

    public long getTotalPrice() {
        long result;
        //số ngày
        long numDay = DAYS.between(checkin, checkout);
        //giá phòng
        int price = room.getPrice();
        result = numDay * price;
        return result;
    }

    public Order() {
    }

    public Order(LocalDate checkin, LocalDate checkout, User user, Room room) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.user = user;
        this.room = room;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
        this.room.setStatus(false);
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
