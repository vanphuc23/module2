package Module;

public class House extends Facility {
    private String roomType;
    private String floor;
    private int use;

    public House() {
    }

    public House(String roomType, String floor) {
        this.roomType = roomType;
        this.floor = floor;
    }

    public House(String nameService, double area, long retalCosts, String peopleMax, String rentalType, String roomType, String floor,int use) {
        super(nameService, area, retalCosts, peopleMax, rentalType);
        this.roomType = roomType;
        this.floor = floor;
        this.use=use;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
        return super.toString() + ", " + this.roomType + ", " + this.floor +", "+this.use;
    }
}
