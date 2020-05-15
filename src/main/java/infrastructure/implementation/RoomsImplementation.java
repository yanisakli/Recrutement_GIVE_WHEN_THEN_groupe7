package infrastructure.implementation;

import infrastructure.utils.Utils;
import model.room.Room;
import model.room.Rooms;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomsImplementation implements Rooms {
    @Override
    public List<Room> getAvailableRoom(LocalDate date) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(Utils.createRoomB01());
        rooms.add(Utils.createRoomB21());
        rooms.add(Utils.createRoomB22());
        return rooms;
    }
}
