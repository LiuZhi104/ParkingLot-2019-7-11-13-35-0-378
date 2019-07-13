package com.thoughtworks.tdd;

import java.util.HashMap;

public class Parkinglot {
    private HashMap<Ticket,Car> ticketCarHashMap;

    public Parkinglot() {
        this.ticketCarHashMap =new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket=new Ticket();
        ticketCarHashMap.put(ticket,car);
        return ticket;
    }


    public Car getCar(Ticket ticket) {
        return ticketCarHashMap.get(ticket);
    }
}
