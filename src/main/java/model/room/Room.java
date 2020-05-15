package model.room;

import java.model.common.RoomDTO;
import java.time.LocalDate;

public class Room {
    private final String name;
    private final Boolean disponibility;

    public Room(String name, Boolean disponibility) {
        this.name = name;
        this.disponibility = disponibility;
    }

    public RoomDTO RoomToDTO(){
        return new RoomDTO(name, disponibility);
    }

    public Boolean getDisponibility() {
        return this.disponibility;
    }

    public String getName() {
        return this.name;
    }

}
