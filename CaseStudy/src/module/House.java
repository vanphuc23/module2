package module;

import java.time.LocalDate;

public class House extends Rent {
    private String roomStandard;
    private int numberFloors;

    public House() {
    }

    public House(String serviceName, double usableArea, int cpth, int peopleMax, String rentalType, String roomStandard, int numberFloors) {
        super(serviceName, usableArea, cpth, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
