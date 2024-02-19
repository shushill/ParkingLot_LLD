package project.parkinglot.lldproject.service;




import org.springframework.beans.factory.annotation.Autowired;
import project.parkinglot.lldproject.entity.Car;
import project.parkinglot.lldproject.entity.ParkingLot;
import project.parkinglot.lldproject.exception.DataValidation;
import project.parkinglot.lldproject.factory.ParkingLotFactory;

import java.time.Duration;
import java.util.Locale;
import java.util.Optional;


public class ShellService {


//    @Autowired
//    ParkingLotFactory parkingLotFactory

    @Autowired
    DataValidation dataValidation;

    public ShellService(){

    }

    public String createparkinglot(int numcar) {

        if(!dataValidation.matchAnyNum(numcar)){
            return "Please enter correct positive number";
        }

        boolean isParkingLotMade = ParkingLotFactory.parkingLotAvailable();
        String response = "";
        if(isParkingLotMade){
            response = "Parking Lot already Created";
        }else{
          ParkingLot p = ParkingLotFactory.getInstance(numcar);
          int num = p.getNumcars();
          response += String.format("Created a parking lot with %d slots.", num);
        }




        return response;
    }

    public String parkcar(String reg, String rang) {

        if(rang == null){
            return "Colour cant be empty\n";
        }
        if(reg==null){
            return "Registration number cant be empty\n";
        }

        boolean isValidNumber  = dataValidation.matchNumber(reg);

        if(!isValidNumber){
            return "Please enter correct registration number.";
        }

        if(!dataValidation.matchColour(rang)){
            return "Please enter correct colour in string upto length 15.";
        }



        ParkingLot parkingLot = ParkingLotFactory.getInstance();

        if(parkingLot == null){
            return "Please Create Parking Lot first";
        }

        Car newcar = new Car(reg, rang.toLowerCase());

        if(parkingLot.getCapacity() == 0){
            return "Sorry, parking lot is full";
        }

        int parkedAtSlot = parkingLot.addCar(newcar);

        if(parkedAtSlot == -1){
            return "Sorry, parking lot is full";
        }



        String response = "";
        response += String.format("Allocated slot number: %d ", parkedAtSlot);

        return response;
    }

    public String deleteparkedcar(int num) {
        if(!dataValidation.matchAnyNum(num)){
            return "Please enter correct positive number";
        }

        ParkingLot parkingLot = ParkingLotFactory.getInstance();

        if(parkingLot == null){
            return "Please Create Parking Lot first";
        }

        parkingLot.removeCar(num);

        String response ="";
                response+= String.format("Slot number %d is free", num);

        return response;
    }

    public String availablecars() {

        ParkingLot parkingLot = ParkingLotFactory.getInstance();

        if(parkingLot == null){
            return "Please Create Parking Lot first";
        }

        if(parkingLot.getCapacity() == parkingLot.getNumcars()){
            return "Parking lot is Empty";
        }

        String response = "Slot No.\tRegistration Number\t\tColour\n";
        Car[] cars = parkingLot.getSlot();
        for(int i=0; i<parkingLot.getNumcars(); ++i){
            if(cars[i]!=null){
                response+=String.format("\t%d\t\t%s\t\t\t\t%s\n", i+1, cars[i].getRegistration_number(), cars[i].getColour());
            }
        }

        return response;
    }

    public String showcarsofcolours(String color) {
        ParkingLot parkingLot = ParkingLotFactory.getInstance();

        if(parkingLot == null){
            return "Please Create Parking Lot first";
        }

        if(parkingLot.getCapacity() == parkingLot.getNumcars()){
            return "Parking lot is Empty";
        }
        if(!dataValidation.matchColour(color)){
            return "Please enter correct colour in string upto length 15.";
        }

        String response = "";

        Car[] cars = parkingLot.getSlot();
        for(int i=0; i<parkingLot.getNumcars(); ++i){
            if(cars[i]!=null && cars[i].getColour().equals(color.toLowerCase())){
               response+=String.format("%s\n",cars[i].getRegistration_number());
            }
        }

        return response;
    }




}

