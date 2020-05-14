package main.java.infrastructure;

import main.java.model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Rooms {

    public static List<Room> getAvailableRoom(String date){
        List<Room> listRoom = new ArrayList<>();
        Room roomOne = new Room("B01",true,date);
        Room roomTwo = new Room("A01",true,date);
        Room roomThree = new Room("B22",true,date);

        listRoom.add(roomOne);
        listRoom.add(roomTwo);
        listRoom.add(roomThree);

        return listRoom;
    }
}
