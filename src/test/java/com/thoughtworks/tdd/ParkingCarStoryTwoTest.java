package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingCarStoryTwoTest {
    @Test
    public void should_retrun_unrecognized_parking_ticket_when_customer_gives_wrong_ticket(){
        //given
        Car car=new Car();
        Parkinglot parkinglot=new Parkinglot();
        Parkingboy parkingboy=new Parkingboy(parkinglot);
        Customer customer=new Customer();
        // when
        parkingboy.park(car);
        Ticket ticket=new Ticket();
        Car fetchCar=parkingboy.fetchCar(ticket);
        String actulMessege=customer.getMessege(fetchCar);
        //then
        Assertions.assertSame("Unrecognized parking ticket.",actulMessege);

    }
}
