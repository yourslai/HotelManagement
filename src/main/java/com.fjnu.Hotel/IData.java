package com.fjnu.Hotel;

public interface IData {
    void iniRooms();

    String in_Out_Room(int roomNo, String name);

    String getStation(int roomNo);
}
