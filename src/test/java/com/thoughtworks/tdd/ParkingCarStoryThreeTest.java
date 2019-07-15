package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingCarStoryThreeTest {
    @Test
    public void should_parkink_lot_2_is_empty_when_park_10_car() throws Exception {
        //given
        Car car=new Car();
        List<Parkinglot> parkinglots = new ArrayList();
        parkinglots.add(new Parkinglot(10));
        parkinglots.add(new Parkinglot(10));
        Parkingboy parkingboy=new Parkingboy(parkinglots);
        // when
        for(int i=0;i<10;i++){
            parkingboy.park(new Car());
        }
        //then
        assertEquals(parkinglots.get(1).park(car).isEmpty(),true);
    }

    @Test
    public void should_return_car_when_parking_ticket_back_to_parking_boy_to_fetch_car_muiltiple_car_statify_1_and_2(){
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
