package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingCarStoryFiveTest {
    @Test
    public void should_return_car_when_super_smart_parking_boy_park_cars_to_parking_lot_which_has_a_larger_available_position_rate () {
        //given
        Car car = new Car();
        Parkinglot parkinglot = new Parkinglot();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(parkinglot);

        // when
        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        if (parkinglots.isEmpty()) {
            Ticket ticket = superSmartParkingBoy.park(car);
            Car fetchCar = superSmartParkingBoy.fetchCar(ticket);
            //then
            Assertions.assertSame(car, fetchCar);
        }
    }

}
