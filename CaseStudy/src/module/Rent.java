package module;

import java.time.LocalDate;

public class Rent {
    private String serviceName;
    private double usableArea;
    private int cpth;
    private int peopleMax;
    private String rentalType;

    public Rent() {
    }

    public Rent(String serviceName, double usableArea, int cpth, int peopleMax, String rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cpth = cpth;
        this.peopleMax = peopleMax;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getCpth() {
        return cpth;
    }

    public void setCpth(int cpth) {
        this.cpth = cpth;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
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
        return "Rent{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", cpth=" + cpth +
                ", peopleMax=" + peopleMax +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
