package java.model.common;

import model.room.Room;

public class RoomDTO {
    private final String name;
    private final Boolean disponibility;

    public RoomDTO(String name, Boolean disponibility) {
        this.name = name;
        this.disponibility = disponibility;
    }


    public Room DtoToRoom(){
        return new Room(name, disponibility);
    }

    public Boolean getDisponibility() {
        return this.disponibility;
    }

    public String getName() {
        return this.name;
    }
}
