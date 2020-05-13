package main.java.use_case;

import java.util.List;

public interface RoomService {
    static List<Room> getAvailableRoom(String date);
}
