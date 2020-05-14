package main.java.model.room;

public class Room {
    private final String name;
    private final Boolean available;
    private final String date;

    public Room(String name, Boolean available, String date) {
        this.name = name;
        this.available = available;
        this.date = date;
    }

    public Boolean getDisponibility() {
        return this.available;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }
}
