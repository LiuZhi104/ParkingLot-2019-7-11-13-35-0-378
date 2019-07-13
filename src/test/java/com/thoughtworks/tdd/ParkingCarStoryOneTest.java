package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingCarStoryOneTest {
    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
       // when
        Ticket ticket=parkingboy.park(car);
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
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket firstTicket=parkingboy.park(firstCar);
        Ticket secondTicket=parkingboy.park(secondCar);
        Car fetchFirstCar=parkingboy.fetchCar(firstTicket);
        Car fetchSecondCar=parkingboy.fetchCar(secondTicket);
        //then
        Assertions.assertSame(firstCar,fetchFirstCar);
        Assertions.assertSame(secondCar,fetchSecondCar);
    }
//    @Test
//    public void should_return_exception_when_wrong_or_does_not_give_ticket_back_to_parking_boy_to_fetch_car(){
//        //given
//        Car car=new Car();
//        Parkinglot parkinglot=new Parkinglot();
//        Ticket ticket= new Ticket();
//        Parkingboy parkingboy=new Parkingboy(parkinglot);
//        // when
//        Ticket ticket=parkingboy.park(parkinglot);
//        Car fetchCar=parkingboy.fetchCar(ticket);
//        //then
//        Assertions.assertSame(car,fetchCar);
//    }
//    @Test
//    public void should_return_exception_when_used_ticket_back_to_parking_boy_to_fetch_car(){
//        //given
//        Car car=new Car();
//        Parkinglot parkinglot=new Parkinglot();
//        Ticket ticket= new Ticket();
//        Parkingboy parkingboy=new Parkingboy(parkinglot);
//        // when
//        Ticket ticket=parkingboy.park(parkinglot);
//        Car fetchCar=parkingboy.fetchCar(ticket);
//        //then
//        Assertions.assertSame(car,fetchCar);
//    }
//    @Test
//    public void should_return_exception_when_parking_lot_is_no_position(){
//        //given
//        Car car=new Car();
//        Parkinglot parkinglot=new Parkinglot();
//        Ticket ticket= new Ticket();
//        Parkingboy parkingboy=new Parkingboy(parkinglot);
//        // when
//        Ticket ticket=parkingboy.park(parkinglot);
//        Car fetchCar=parkingboy.fetchCar(ticket);
//        //then
//        Assertions.assertSame(car,fetchCar);
//    }

}
