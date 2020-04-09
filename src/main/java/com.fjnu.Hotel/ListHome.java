package com.fjnu.Hotel;

public class ListHome {
    IData iData;

    public ListHome(IData iData) {
        this.iData = iData;
    }

    public void search() {
        for (int i = 0; i < HotelConstant.NumOfFloor; i++) {
            for (int j = 0; j < HotelConstant.RoomsOfFloor; j++) {
                if (j + 1 < 10) {
                    System.out.print(i + 1 + "0" + (j + 1) + "\t");
                } else {
                    System.out.print(i + 1 + "" + (j + 1) + "\t");
                }
            }
            System.out.println();
            for (int j = 0; j < HotelConstant.RoomsOfFloor; j++) {
                System.out.print(iData.getStation((i + 1) * 100 + j + 1) + "\t");
            }
            System.out.println();
        }
    }
}
