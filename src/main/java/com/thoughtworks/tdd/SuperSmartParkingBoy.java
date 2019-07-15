package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy{
    private String name;
    private ArrayList<ParkingLot> parkingLots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuperSmartParkingBoy(ArrayList parkingLots) {
        super(parkingLots);
        this.parkingLots=parkingLots;
    }

    @Override
    public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws Exception {
        if (car==null)throw new Exception("you should provide a car.");

        if(isCarHasParked(parkingLots,car)) throw new Exception("You should provide a car that haven't park.");

        if(isFull(parkingLots)) throw new ParkingLotIsFullException("Not enough position.");

        Ticket ticket = new Ticket();
        parkingLots.get(chooseParkingLot()).getTicketCarMap().put(ticket,car);
        return ticket;
    }


    public int chooseParkingLot(){
        int parkingLotIndex = 0;
        double maxAvailablePosition = parkingLots.get(0).getCapacity()-parkingLots.get(0).getTicketCarMap().size();
        double maxAvailablePositionRate = maxAvailablePosition/parkingLots.get(0).getCapacity();
        for(int i = 0;i < parkingLots.size();i++){
            int capacity = parkingLots.get(i).getCapacity();
            int positionsIsParked = parkingLots.get(i).getTicketCarMap().size();
            double availablePosition = capacity- positionsIsParked;
            if(maxAvailablePositionRate < (availablePosition/capacity)){
                maxAvailablePositionRate = availablePosition/capacity;
                parkingLotIndex = i;
            } else if(maxAvailablePositionRate == (availablePosition/capacity)&maxAvailablePosition < availablePosition){
                maxAvailablePosition = availablePosition;
                parkingLotIndex = i;
            }
        }
        return parkingLotIndex;
    }
}
