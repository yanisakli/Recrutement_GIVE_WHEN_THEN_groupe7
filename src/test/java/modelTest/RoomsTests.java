package modelTest;

import model.recruiter.Recruiter;
import model.room.Room;
import model.room.Rooms;
import utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomsTests implements Rooms {
    @Override
    public List<Room> getAvailableRoom(LocalDate date) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(Utils.createRoomB01());
        rooms.add(Utils.createRoomB21());
        rooms.add(Utils.createRoomB22());
        return rooms;
    }
}
