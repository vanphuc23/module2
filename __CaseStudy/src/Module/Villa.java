package Module;

public class Villa extends Facility {
    private String roomType;
    private double poolArea;
    private String floor;
    private int use;

    public Villa() {
    }

    public Villa(String roomType, double poolArea, String floor) {
        this.roomType = roomType;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String nameService, double area, long retalCosts, String peopleMax, String rentalType, String roomType, double poolArea, String floor, int use) {
        super(nameService, area, retalCosts, peopleMax, rentalType);
        this.roomType = roomType;
        this.poolArea = poolArea;
        this.floor = floor;
        this.use = use;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.roomType + ", " + this.poolArea + ", " + this.floor+", "+this.use;
    }
}
