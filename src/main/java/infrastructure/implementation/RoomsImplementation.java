package infrastructure.implementation;

import infrastructure.utils.Utils;
import model.room.Rooms;

import java.model.common.RoomDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomsImplementation implements Rooms {
    @Override
    public List<RoomDTO> getAvailableRoom(LocalDate date) {
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(Utils.createRoomB01());
        rooms.add(Utils.createRoomB21());
        rooms.add(Utils.createRoomB22());
        return rooms;
    }
}
