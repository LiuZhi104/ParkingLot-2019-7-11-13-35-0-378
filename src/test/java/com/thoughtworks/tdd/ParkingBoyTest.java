package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    public void should_return_a_car_when_given_a_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(ticket);
        //then
        assertSame(fetchCar,car);
    }
    @Test
    public void should_return_multiple_cars_when_given_multiple_cars() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car FirstCar = new Car();
        Car SecondCar = new Car();
        //when
        Ticket FirstTicket = parkingBoy.park(FirstCar);
        Car fetchFirstCar = parkingBoy.fetch(FirstTicket);
        Ticket SecondTicket = parkingBoy.park(SecondCar);
        Car fetchSecondCar = parkingBoy.fetch(SecondTicket);
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket wrongTicket = null;
        //when
        parkingBoy.park(car);
        //then
       assertThrows(Exception.class,() -> parkingBoy.fetch(wrongTicket));
    }
    @Test
    public void should_not_fetch_car_when_given_ticket_has_been_used() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //then
     assertThrows(Exception.class,() -> parkingBoy.fetch(ticket));
    }
    @Test
    public void should_not_get_ticket_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            parkingBoy.park(new Car());
        }
        //then
       assertThrows(FullException.class,() -> parkingBoy.park(car));
    }
    @Test
    public void should_return_Unrecognized_parking_ticket_when_given_wrong_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket=parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //then
        assertThrows(Exception.class,() -> parkingBoy.fetch(ticket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_return_Please_provide_your_parking_ticket_when_given_no_ticket() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket noTicket = null;
        //then
        assertThrows(Exception.class,() -> parkingBoy.fetch(noTicket),"Please provide your parking ticket.");
    }
    @Test
    public void should_return_Not_enough_position_when_parking_lot_is_full() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 20;i++){
            parkingBoy.park(new Car());
        }
        //then
        assertThrows(Exception.class,() -> parkingBoy.park(car),"Not enough position.");
    }
    @Test
    public void should_parkink_lot_2_is_empty_when_park_10_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        for(int i = 0;i < 10;i++){
            parkingBoy.park(new Car());
        }
        //then
        assertSame(parkingLots.get(1).getTicketCarMap().isEmpty(),true);
    }

}
