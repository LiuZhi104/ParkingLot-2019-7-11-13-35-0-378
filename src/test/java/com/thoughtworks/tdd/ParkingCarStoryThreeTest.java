package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ParkingCarStoryThreeTest {
    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car_muiltiple_car() {
        //given
        Car car = new Car();
        Parkinglot Parkinglot = new Parkinglot();
        Parkingboy parkingboy = new Parkingboy(Parkinglot);

        // when
        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        if (parkinglots.isEmpty()) {
            Ticket ticket = parkingboy.park(car);
            Car fetchCar = parkingboy.fetchCar(ticket);
            //then
            Assertions.assertSame(car, fetchCar);
        }
    }

    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car_muiltiple_car_statify_1_and_2() {
        //given
        Car car = new Car();
        Parkinglot parkinglot = new Parkinglot();
        Parkingboy parkingboy = new Parkingboy(parkinglot);

        // when
        List<Parkinglot> parkinglots = new ArrayList<Parkinglot>();
        if (parkinglots.isEmpty()) {
            Ticket ticket = parkingboy.park(car);
            Car fetchCar = parkingboy.fetchCar(ticket);
            //then
            Assertions.assertSame(car, fetchCar);
        }
    }
}
