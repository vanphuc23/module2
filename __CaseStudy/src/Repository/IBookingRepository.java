package Repository;

import Module.Booking;

import java.util.TreeSet;

public interface IBookingRepository {
    TreeSet<Booking> display();
    void write(TreeSet<Booking> bookings);
}
