package model;

public class Room {
    private String name;
    private String type;
    private int price;
    private boolean status;

    public Room() {
    }

    public Room(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = true;
    }

    public Room(String name, String type, int price, boolean status) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
