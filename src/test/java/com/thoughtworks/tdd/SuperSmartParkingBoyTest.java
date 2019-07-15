package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_a_car_when_given_a_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = superSmartParkingBoy.park(car);
        Car fetchCar = superSmartParkingBoy.fetch(ticket);
        //then
        assertSame(fetchCar,car);
    }
    @Test
    public void should_return_multiple_cars_when_given_multiple_cars() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car FirstCar = new Car();
        Car SecondCar = new Car();
        //when
        Ticket FirstTicket = superSmartParkingBoy.park(FirstCar);
        Car fetchFirstCar = superSmartParkingBoy.fetch(FirstTicket);
        Ticket SecondTicket = superSmartParkingBoy.park(SecondCar);
        Car fetchSecondCar = superSmartParkingBoy.fetch(SecondTicket);
        //then
        assertSame(fetchFirstCar,FirstCar);
        assertEquals(fetchSecondCar,SecondCar);
    }
    @Test
    public void should_not_fetch_car_when_given_wrong_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket wrongTicket = null;
        //when
        superSmartParkingBoy.park(car);
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.fetch(wrongTicket));
    }
    @Test
    public void should_not_fetch_car_when_given_ticket_has_been_used() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = superSmartParkingBoy.park(car);
        superSmartParkingBoy.fetch(ticket);
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.fetch(ticket));
    }
    @Test
    public void should_not_get_ticket_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            superSmartParkingBoy.park(new Car());
        }
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.park(car));
    }
    @Test
    public void should_return_Unrecognized_parking_ticket_when_given_wrong_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket=superSmartParkingBoy.park(car);
        superSmartParkingBoy.fetch(ticket);
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.fetch(ticket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_return_Please_provide_your_parking_ticket_when_given_no_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket noTicket = null;
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.fetch(noTicket),"Please provide your parking ticket.");
    }
    @Test
    public void should_return_Not_enough_position_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            superSmartParkingBoy.park(new Car());
        }
        //then
        assertThrows(Exception.class,() -> superSmartParkingBoy.park(car),"Not enough position.");
    }
    @Test
    public void should_parking_lot_2_is_not_empty_when_park_2_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car FirstCar = new Car();
        Car SecondCar = new Car();
        //when
        superSmartParkingBoy.park(FirstCar);
        superSmartParkingBoy.park(SecondCar);
        //then
        assertEquals(parkingLots.get(1).getTicketCarMap().isEmpty(),false);
    }
    @Test
    public void should_parking_lot_1_is_empty_when_park_1_car_and_paking_lot_2_has_15_capacity() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(15));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        superSmartParkingBoy.park(car);
        //then
        assertEquals(parkingLots.get(0).getTicketCarMap().isEmpty(),true);
    }
    @Test
    public void should_parking_lot_1_has_1_car_when_park_4_car_and_paking_lot_2_has_20_capacity() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(20));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        for(int i = 0;i < 5;i++) {
            superSmartParkingBoy.park(new Car());
        }
        //then
        assertEquals(2,parkingLots.get(0).getTicketCarMap().size());
    }
}
