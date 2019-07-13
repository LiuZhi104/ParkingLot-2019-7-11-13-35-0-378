package com.thoughtworks.tdd;

public class Parkingboy {
    private Parkinglot parkinglot;

    public Parkingboy(Parkinglot parkinglot) {
        this.parkinglot = parkinglot;
    }

    public Ticket park(Car car) {
        return parkinglot.park(car);
    }

    public Car fetchCar(Ticket ticket) {
        return parkinglot.getCar(ticket);
    }
}
