package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        return getSmartTicket(car);
    }

    private Ticket getSmartTicket(Car car) throws Exception {
        if (car==null)throw new Exception("you should provide a car");
        if(isCarHasParked(parkingLots,car)) throw new Exception("You should provide a car that haven't park.");
        if(isFull(parkingLots)) throw new FullException("Not enough position.");
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = chooseParkingLot(parkingLots);
        parkingLot.getTicketCarMap().put(ticket,car);
        return ticket;
    }


    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots){
        return parkingLots.stream()
                .sorted(Comparator.comparing((ParkingLot parkingLot) -> parkingLot.getCapacity()-parkingLot.getTicketCarMap().size()).reversed())
                .collect(Collectors.toList())
                .get(0);
    }

}
