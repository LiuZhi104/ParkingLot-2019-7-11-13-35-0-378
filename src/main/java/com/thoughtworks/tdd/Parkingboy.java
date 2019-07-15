package com.thoughtworks.tdd;

import java.util.List;

public class Parkingboy {
    private List<Parkinglot> parkinglots;

    public Parkingboy(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public Ticket park(Car car){
          return parkinglot.park(car);
    }

    public Car fetchCar(Ticket ticket){

            return parkinglot.getCar(ticket);

    }
}
