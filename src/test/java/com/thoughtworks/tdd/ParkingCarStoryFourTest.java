package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingCarStoryFourTest {

    @Test
    public void should_return_car_when_smart_parkingboy_park_cars_to_parking_lot_which_contains_more_empty_positions() {
        //given
        Car car = new Car();
        Parkinglot parkinglot = new Parkinglot();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy(parkinglot);

        // when
        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        if (parkinglots.isEmpty()) {
            Ticket ticket = smartParkingBoy.park(car);
            Car fetchCar = smartParkingBoy.fetchCar(ticket);
            //then
            Assertions.assertSame(car, fetchCar);
        }
    }

}
