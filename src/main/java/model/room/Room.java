package model.room;

import model.common.RoomDTO;
import model.common.SlotDTO;
import model.interview.Slot;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class Room {
    private final String name;
    private final List<Slot> disponibilities;
    private final UUID roomUuid;
    private final int capacity;
    private final List<Equipment> equipments;

    public Room(String name, List<SlotDTO> disponibilities, int capacity, List<Equipment> equipments) {
        this.roomUuid = UUID.randomUUID();
        this.name = name;
        this.disponibilities = disponibilities.stream().map(disponibilityDTO -> disponibilityDTO.DtoToSlot()).collect(Collectors.toList());
        this.equipments = equipments;
        if(capacity < 2){
            throw new model.room.exception.RoomException("Room Capacity under 2 persons");
        }
        else {
            this.capacity = capacity;
        }
    }

    public RoomDTO RoomToDTO(){
        return new RoomDTO(name,
                disponibilities.stream().map(disponibility -> disponibility.SlotToDTO()).collect(Collectors.toList()),
                roomUuid,
                capacity,
                equipments);
    }

    public List<Slot> getDisponibilities() {
        return this.disponibilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity &&
                Objects.equals(name, room.name) &&
                Objects.equals(disponibilities, room.disponibilities) &&
                Objects.equals(roomUuid, room.roomUuid) &&
                Objects.equals(equipments, room.equipments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, disponibilities, roomUuid, capacity, equipments);
    }

    public Boolean getFreeRoom(Slot slot) {
        return this.disponibilities.contains(slot);
    }

    // TODO : Libérer la salle si l'entretien est reporté ou annulé

    public String getName() {
        return this.name;
    }

    public UUID getRoomUuid() {
        return roomUuid;
    }
}
