package module;


import java.time.LocalDate;

public class Villa extends Rent {
    private String roomStandard;
    private double poolArea;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String serviceName, double usableArea, int cpth, int peopleMax, String rentalType, String roomStandard, double poolArea, int numberFloors) {
        super(serviceName, usableArea, cpth, peopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
