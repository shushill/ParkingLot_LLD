package project.parkinglot.lldproject.factory;

import project.parkinglot.lldproject.entity.ParkingLot;

public class ParkingLotFactory {

    private  static ParkingLot instance;

    private static boolean already_created = false;

    public static ParkingLot getInstance(int num) {
        if (instance == null) {
            instance = new ParkingLot(num);
            already_created = true;
        }
        return instance;

    }
    public static ParkingLot getInstance() {
        return instance;

    }

    public static boolean parkingLotAvailable(){
        return already_created;
    }



}
