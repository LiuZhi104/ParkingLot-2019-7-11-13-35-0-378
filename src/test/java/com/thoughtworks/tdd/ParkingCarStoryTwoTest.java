package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingCarStoryTwoTest {
    @Test
    public void should_return_unrecognized_parking_ticket_when_customer_gives_wrong_ticket() {
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(car);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertThrows(Exception.class,() -> parkingboy.fetchCar(ticket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_return_please_provide_your_parking_ticket_when_customer_does_not_provide_ticket() {
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        Ticket noTicket=null;
        Car fetchCar=parkingboy.fetchCar(noTicket);
        //then
        Assertions.assertThrows(Exception.class,() ->parkingboy.fetchCar(noTicket),"Please provide your parking ticket.");
    }
    @Test
    public void should_return_not_enough_position_when_parking_boy_attempt_to_park_car_into_parking_lot_without_position() {
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        for(int i=0;i<20;i++){
            parkingboy.park(new Car());
        }
        //then
        Assertions.assertThrows(Exception.class,() -> parkingboy.park(car),"Not enough position.");
    }
}
