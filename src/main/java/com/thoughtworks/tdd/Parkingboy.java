package com.thoughtworks.tdd;

public class Parkingboy {
    private Parkinglot parkinglot;

    public Parkingboy(Parkinglot parkinglot) {
        this.parkinglot = parkinglot;
    }

    public Ticket park(Parkinglot parkinglot) {
        return parkinglot.getCarTicket();
    }

    public Car fetchCar(Ticket ticket) {
        return ticket.getCar(parkinglot);
    }
}
