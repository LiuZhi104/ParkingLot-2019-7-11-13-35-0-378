package com.thoughtworks.tdd;

public class SmartParkingBoy extends Parkingboy {

    public SmartParkingBoy(Parkinglot parkinglot) {
        super(parkinglot);
    }

    @Override
    public Ticket park(Car car) {
        return super.park(car);
    }

    @Override
    public Car fetchCar(Ticket ticket) {
        return super.fetchCar(ticket);
    }
}
