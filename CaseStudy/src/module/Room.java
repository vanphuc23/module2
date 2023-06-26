package module;

import java.time.LocalDate;

public class Room extends Rent{
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, double usableArea, int cpth, int peopleMax, String rentalType, String freeService) {
        super(serviceName, usableArea, cpth, peopleMax, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
