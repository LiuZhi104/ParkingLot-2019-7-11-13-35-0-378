package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket,Car> ticketCarHashMap;
    private int capacity;
    public ParkingLot(int capacity){
        this.ticketCarHashMap = new HashMap<>();
        this.capacity = capacity;
    }

    public HashMap<Ticket, Car> getTicketCarMap() {
        return ticketCarHashMap;
    }

    public int getCapacity() {
        return capacity;
    }
}
