package model.room;

import model.interview.Slot;

import java.model.common.RoomDTO;
import java.model.common.SlotDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class Room {
    private final String name;
    private final List<Slot> disponibilities;
    private final UUID roomUuid;

    public Room(String name, List<SlotDTO> disponibilities) {
        this.roomUuid = UUID.randomUUID();
        this.name = name;
        this.disponibilities = disponibilities.stream().map(disponibilityDTO -> disponibilityDTO.DtoToSlot()).collect(Collectors.toList());;
    }

    public RoomDTO RoomToDTO(){
        return new RoomDTO(name, disponibilities, roomUuid);
    }

    public List<Slot> getDisponibilities() {
        return this.disponibilities;
    }

    public Room getFreeRoom(Slot slot) {

    }

    // Liberer commands

    public String getName() {
        return this.name;
    }

    public UUID getRoomUuid() {
        return roomUuid;
    }
}
