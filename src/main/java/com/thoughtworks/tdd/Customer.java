package com.thoughtworks.tdd;

public class Customer {


    public String getMessege(Car fetchCar) {
        return "Unrecognized parking ticket.";
    }

    public String getErrorMessege(Car fetchCar) {
        return  "Please provide your parking ticket.";
    }

    public String getErrorPositionMessege(Ticket ticket) {
        return "Not enough position.";
    }
}
