package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingCarStoryOneTest {
    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Ticket ticket= new Ticket();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
       // when
        Ticket ticket=parkingboy.park(parkinglot);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }
    @Test
    public void should_return_multiple_cars_when_parking_ticket_back_to_parking_boy_to_fetch_car(){
        //given
        Car firstCar=new Car();
        Car secondCar=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Ticket ticket= new Ticket();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(parkinglot);
        Car fetchFirstCar=parkingboy.fetchCar(ticket);
        Car fetchSecondCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(firstCar,fetchFirstCar);
        Assertions.assertSame(secondCar,fetchSecondCar);
    }
    @Test
    public void should_return_exception_when_wrong_or_does_not_give_ticket_back_to_parking_boy_to_fetch_car(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Ticket ticket= new Ticket();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(parkinglot);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }
    @Test
    public void should_return_exception_when_used_ticket_back_to_parking_boy_to_fetch_car(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Ticket ticket= new Ticket();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(parkinglot);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }
    @Test
    public void should_return_exception_when_parking_lot_is_no_position(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Ticket ticket= new Ticket();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(parkinglot);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }

}
