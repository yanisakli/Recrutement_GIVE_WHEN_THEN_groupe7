package java.model.common;

public class RoomDTO {
    private final String name;
    private final Boolean disponibility;

    public RoomDTO(String name, Boolean disponibility) {
        this.name = name;
        this.disponibility = disponibility;
    }

    public RoomDTO(Boolean disponibility) {
        this.disponibility = disponibility;
    }

    public RoomDTO(String name) {
        this.name = name;
    }

    public Boolean getDisponibility() {
        return this.disponibility;
    }

    public String getName() {
        return this.name;
    }
}
