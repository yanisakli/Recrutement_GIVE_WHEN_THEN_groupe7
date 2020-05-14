package model.room;

import java.time.LocalDate;

public class Room {
    private final String name;
    private final Boolean available;
    private final LocalDate date;

    public Room(String name, Boolean available, LocalDate date) {
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

    public LocalDate getDate() {
        return this.date;
    }
}
