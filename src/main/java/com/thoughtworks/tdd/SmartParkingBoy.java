package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ArrayList<ParkingLot> parkingLots;

    public SmartParkingBoy(ArrayList parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }
    @Override
    public Ticket park(Car car) throws Exception {
        if (car==null)throw new Exception("you should provide a car");

        if(isCarHasParked(parkingLots,car)) throw new Exception("You should provide a car that haven't park.");

        if(isFull(parkingLots)) throw new ParkingLotIsFullException("Not enough position.");

        Ticket ticket = new Ticket();
        this.parkingLots.get(chooseParkingLot()).getTicketCarMap().put(ticket,car);
        return ticket;
    }




    public int chooseParkingLot(){
        int parkingLotIndex = 0;
        int parkingLotRestPositions = parkingLots.get(0).getCapacity()-parkingLots.get(0).getTicketCarMap().size();
        for(int i = 0;i < parkingLots.size();i++){
            int capacity = parkingLots.get(i).getCapacity();
            int positionsIsParked = parkingLots.get(i).getTicketCarMap().size();
            if(parkingLotRestPositions <= capacity - positionsIsParked){
                parkingLotRestPositions = capacity-positionsIsParked;
                parkingLotIndex = i;
            }
        }
        return parkingLotIndex;
    }

}
