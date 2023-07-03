package Module;

public class Room1 extends Facility {
    private String freeService;
    private int use;

    public Room1() {
    }

    public Room1(String freeService) {
        this.freeService = freeService;
    }

    public Room1(String nameService, double area, long retalCosts, String peopleMax, String rentalType, String freeService, int use) {
        super(nameService, area, retalCosts, peopleMax, rentalType);
        this.freeService = freeService;
        this.use = use;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.freeService+", "+this.use;
    }
}
