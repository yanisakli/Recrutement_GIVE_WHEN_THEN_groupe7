package model.room;

import java.time.LocalDate;
import java.util.List;

public interface Rooms {
    List<Room> getAvailableRoom(LocalDate date);
}
