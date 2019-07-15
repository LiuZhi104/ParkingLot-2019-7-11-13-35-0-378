package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParkingBoy {
    private String name;

    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws Exception {
        if (car==null){
            throw new Exception("you should has a car");
        }
        if(isCarHasParked(parkingLots,car)) throw new Exception("You should provide a car that haven't park.");

        if(isFull(parkingLots)) throw new ParkingLotIsFullException("Not enough position.");

        Ticket ticket = new Ticket();
        ParkingLot parkingLotParked = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getTicketCarMap().size()<parkingLot.getCapacity())
                .findFirst()
                .get();
        parkingLotParked.getTicketCarMap().put(ticket,car);

        return ticket;
    }

    public Car fetch(Ticket ticket) throws  NoTicketException, WrongTicketException {
        if (ticket == null) throw new NoTicketException("Please provide your parking ticket.");

        Car car = null;
        ParkingLot parkingLotHasCar= parkingLots.stream()
                .filter(parkingLot -> parkingLot.getTicketCarMap().containsKey(ticket))
                .findFirst()
                .get();
        car=parkingLotHasCar.getTicketCarMap().get(ticket);
        parkingLotHasCar.getTicketCarMap().remove(ticket);

        if (car == null) throw new WrongTicketException("Unrecognized parking ticket.");
        return car;
    }
    public boolean isFull(ArrayList<ParkingLot> parkingLots){
        boolean isFull = true;
        if(parkingLots.stream()
                .filter(parkingLot -> parkingLot.getTicketCarMap().size()<parkingLot.getCapacity())
                .collect(Collectors.toList())
                .size()!=0)
            isFull=false;
        return isFull;
    }
    public boolean isCarHasParked(ArrayList<ParkingLot> parkingLots,Car car){
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getTicketCarMap().containsKey(car))
                .collect(Collectors.toList()).size()!=0;
    }
}
