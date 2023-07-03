package Module;

public abstract class Facility {
    private String nameService;
    private double area;
    private long retalCosts;
    private String peopleMax;
    private String rentalType;

    public Facility() {
    }

    public Facility(String nameService, double area, long retalCosts, String peopleMax, String rentalType) {
        this.nameService = nameService;
        this.area = area;
        this.retalCosts = retalCosts;
        this.peopleMax = peopleMax;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getRetalCosts() {
        return retalCosts;
    }

    public void setRetalCosts(long retalCosts) {
        this.retalCosts = retalCosts;
    }

    public String getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(String peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return this.nameService + ", " + this.area + ", " + this.retalCosts + ", " + this.peopleMax + ", " + this.rentalType;
    }
}
