package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParkingCarStoryOneTest {
    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car() {
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
       // when
        Ticket ticket=parkingboy.park(car);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }
    @Test
    public void should_return_multiple_cars_when_parking_ticket_back_to_parking_boy_to_fetch_car()  {
        //given
        Car firstCar=new Car();
        Car secondCar=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        Ticket firstTicket=parkingboy.park(firstCar);
        Ticket secondTicket=parkingboy.park(secondCar);
        Car fetchFirstCar=parkingboy.fetchCar(firstTicket);
        Car fetchSecondCar=parkingboy.fetchCar(secondTicket);
        //then
        Assertions.assertSame(firstCar,fetchFirstCar);
        Assertions.assertSame(secondCar,fetchSecondCar);
    }
    @Test
    public void should_not_fetch_car_when_wrong_or_does_not_give_ticket_back_to_parking_boy(){
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        Ticket wrongTicket=null;
        // when
        parkingboy.park(car);
        //then
        //Assertions.assertSame(null,fetchCar);
        assertThrows(Exception.class,()->parkingboy.fetchCar(wrongTicket));
    }
    @Test
    public void should_fetch_car_when_used_ticket_back_to_parking_boy() {
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        Ticket ticket=parkingboy.park(car);
        parkingboy.fetchCar(ticket);
        //then
        assertThrows(Exception.class,()->parkingboy.fetchCar(ticket));
    }
    @Test
    public void should_return_exception_when_parking_lot_is_no_position(){
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        for(int i=0;i<20;i++){
            parkingboy.park( new Car());
        }
        //then
        assertThrows(Exception.class,()->parkingboy.park(car));
    }

}
