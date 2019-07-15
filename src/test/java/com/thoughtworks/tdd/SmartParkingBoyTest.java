package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    public void should_return_a_car_when_given_a_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);
        Car fetchCar = smartParkingBoy.fetch(ticket);
        //then
        assertSame(fetchCar,car);
    }
    @Test
    public void should_return_multiple_cars_when_given_multiple_cars() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car FirstCar = new Car();
        Car SecondCar = new Car();
        //when
        Ticket FirstTicket = smartParkingBoy.park(FirstCar);
        Car fetchFirstCar = smartParkingBoy.fetch(FirstTicket);
        Ticket SecondTicket = smartParkingBoy.park(SecondCar);
        Car fetchSecondCar = smartParkingBoy.fetch(SecondTicket);
        //then
        assertSame(fetchFirstCar,FirstCar);
        assertSame(fetchSecondCar,SecondCar);
    }
    @Test
    public void should_not_fetch_car_when_given_wrong_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket wrongTicket = null;
        //when
        smartParkingBoy.park(car);
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.fetch(wrongTicket));
    }
    @Test
    public void should_not_fetch_car_when_given_ticket_has_been_used() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket);
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.fetch(ticket));
    }
    @Test
    public void should_not_get_ticket_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            smartParkingBoy.park(new Car());
        }
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.park(car));
    }
    @Test
    public void should_return_Unrecognized_parking_ticket_when_given_wrong_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket=smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket);
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.fetch(ticket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_return_Please_provide_your_parking_ticket_when_given_no_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket noTicket = null;
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.fetch(noTicket),"Please provide your parking ticket.");
    }
    @Test
    public void should_return_Not_enough_position_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            smartParkingBoy.park(new Car());
        }
        //then
        assertThrows(Exception.class,() -> smartParkingBoy.park(car),"Not enough position.");
    }
    @Test
    public void should_parking_lot_2_is_not_empty_when_park_2_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car FirstCar = new Car();
        Car SecondCar = new Car();
        //when
        smartParkingBoy.park(FirstCar);
        smartParkingBoy.park(SecondCar);
        //then
        assertSame(parkingLots.get(1).getTicketCarMap().isEmpty(),false);
    }
    @Test
    public void should_parking_lot_1_is_empty_when_park_1_car_and_paking_lot_2_has_15_capacity() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(15));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        smartParkingBoy.park(car);
        //then
        assertSame(parkingLots.get(0).getTicketCarMap().isEmpty(),true);
    }
}
