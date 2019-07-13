package com.thoughtworks.tdd;

import java.util.HashMap;

public class Parkinglot {
    private HashMap<Ticket,Car> ticketCarHashMap;
    private int capacity;

    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }

    public Parkinglot() {
        this.ticketCarHashMap =new HashMap<>();
    }

    public Ticket park(Car car) {
        if(capacity<=10){
            Ticket ticket=new Ticket();
            ticketCarHashMap.put(ticket,car);
            return ticket;
        }else{
            return null;
        }


    }


    public Car getCar(Ticket ticket) {
        return ticketCarHashMap.get(ticket);
    }
}
