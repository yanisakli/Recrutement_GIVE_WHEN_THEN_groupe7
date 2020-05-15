package java.model.common;

public class RoomDTO {
    private final String name;
    private final Boolean disponibility;

    public RoomDTO(String name, Boolean disponibility) {
        this.name = name;
        this.disponibility = disponibility;
    }

    public RoomDTO RoomToDTO(model.room.Room room){
        return new RoomDTO(room.getName(),room.getDisponibility());
    }

    public Boolean getDisponibility() {
        return this.disponibility;
    }

    public String getName() {
        return this.name;
    }
}
