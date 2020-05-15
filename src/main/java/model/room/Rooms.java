package java.model.room;

import java.model.common.RoomDTO;
import java.time.LocalDate;
import java.util.List;

public interface Rooms {
    List<RoomDTO> getAvailableRoom(LocalDate date);
}
