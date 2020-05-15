package java.model.common;

import model.room.Room;

import java.util.List;
import java.util.UUID;

public class RoomDTO {
    private final String name;
    private final List<SlotDTO> disponibilities;
    private UUID roomUuid;

    public RoomDTO(String name, List<SlotDTO> disponibilities, UUID roomUuid) {
        this.roomUuid = roomUuid;
        this.name = name;
        this.disponibilities = disponibilities;
    }


    public Room DtoToRoom(){
        return new Room(name, disponibilities);
    }

    public List<SlotDTO> getDisponibilities() {
        return this.disponibilities;
    }

    public String getName() {
        return this.name;
    }

    public UUID getRoomUuid() {
        return this.roomUuid;
    }
}
