package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLotManager extends ParkingBoy{
    private ArrayList<ParkingLot> parkingLots;
    private HashMap<String,ParkingBoy> managementList;


    public ParkingLotManager(ArrayList<ParkingLot> parkingLots, HashMap<String,ParkingBoy> managementList) {
        super(parkingLots);
        this.managementList = managementList;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public HashMap<String,ParkingBoy> getParkingBoys() {
        return managementList;
    }

    public Ticket specifyPark(String name,Car car) throws Exception {
        return managementList.get(name).park(car);
    }

    public Car specifyFetch(String name,Ticket ticket) throws Exception {
        return managementList.get(name).fetch(ticket);
    }

}
