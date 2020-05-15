package java.model.common;

import java.model.room.Equipment;
import java.model.room.Room;
import java.util.List;
import java.util.UUID;

public class RoomDTO {
    private final String name;
    private final List<SlotDTO> disponibilities;
    private UUID roomUuid;
    private final int capacity;
    private final List<Equipment> equipments;

    public RoomDTO(String name, List<SlotDTO> disponibilities, UUID roomUuid, int capacity, List<Equipment> equipments) {
        this.roomUuid = roomUuid;
        this.name = name;
        this.disponibilities = disponibilities;
        this.capacity = capacity;
        this.equipments = equipments;
    }


    public Room DtoToRoom(){
        return new Room(name, disponibilities, capacity, equipments);
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
