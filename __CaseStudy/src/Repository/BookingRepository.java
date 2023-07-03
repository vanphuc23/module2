package Repository;

import Module.Booking;
import util.ReadFileBooking;
import util.WriteFileBooking;
import util.WriteFileRoom;

import java.util.TreeSet;

public class BookingRepository implements IBookingRepository{
    @Override
    public TreeSet<Booking> display() {
        return ReadFileBooking.readFile();
    }

    @Override
    public void write(TreeSet<Booking> bookings) {
        WriteFileBooking.writeFile(bookings);
    }
}
