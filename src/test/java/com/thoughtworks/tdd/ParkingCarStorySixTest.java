package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingCarStorySixTest {
    @Test
    public void should_return_car_when_manager_specify_parking_boy_to_fetch_car(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Manager manager=new Manager();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        // when
        Ticket ticket=parkingboy.park(car);
        Car fetchCar=parkingboy.fetchCar(ticket);
        //then
        Assertions.assertSame(car,fetchCar);
    }

}
