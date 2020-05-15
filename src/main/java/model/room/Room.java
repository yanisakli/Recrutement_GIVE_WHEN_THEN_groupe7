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

    public Room DtoToRoom(RoomDTO roomDTO){
        return new Room(roomDTO.getName(),roomDTO.getDisponibility());
    }
    public Boolean getDisponibility() {
        return this.disponibility;
    }

    public String getName() {
        return this.name;
    }

}
