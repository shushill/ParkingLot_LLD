package project.parkinglot.lldproject.entity;

import project.parkinglot.lldproject.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private Car[] slot;


    private int numcars;

    private static int capacity;


    public ParkingLot(int num){
        this.numcars = num;
        capacity = num;
        this.slot = new Car[num];
        for (int i = 0; i < num; i++) {
            slot[i] = null;
        }
    }

    public int getNumcars() {

        return numcars;
    }
    public Car[] getSlot() {
        return slot;
    }

    public int addCar(Car car){
        for(int i=0; i<numcars; ++i){
            if(slot[i]==null){
                slot[i] = car;
                capacity -=1;
                return i+1;
            }
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    public void removeCar(int num){
        if(slot[num] != null){
            slot[num-1] = null;
            capacity+=1;
        }
    }


}
