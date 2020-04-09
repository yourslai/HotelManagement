package com.fjnu.Hotel;

public class DP implements IData{
    private static String[][] rooms;

    public DP() {
        iniRooms();
    }

    public void iniRooms() {
        // TODO Auto-generated method stub
        rooms = new String[HotelConstant.NumOfFloor][HotelConstant.RoomsOfFloor];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                rooms[i][j] = "EMPTY";
            }
        }
    }

    public int roomNo(int roomNo) {
        if ("EMPTY".equals(rooms[roomNo / 100 - 1][roomNo % 100 - 1])) {
            return roomNo;
        } else
            return 0;
    }

    public String in_Out_Room(int roomNo, String name) {
        // TODO Auto-generated method stub
        if (name.equals("EMPTY")) {
            if (roomNo(roomNo) == 0) {
                rooms[roomNo / 100 - 1][roomNo % 100 - 1] = name;
                return roomNo + "退房成功";
            } else
                return "空房间退房失败";
        } else if (roomNo(roomNo) == 0) {

            return "该房间已有客人入住";

        } else {
            rooms[roomNo / 100 - 1][roomNo % 100 - 1] = name;
            return name + "成功入住" + roomNo + "房间";
        }
    }

    public String getStation(int roomNo) {
        // TODO Auto-generated method stub
        return rooms[(roomNo / 100) - 1][(roomNo % 100) - 1];
    }
}
