package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLotManagerTest {
    @Test
    public void should_return_a_car_when_specify_a_parking_boy_on_the_list_to_park_or_fetch_the_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);parkingBoy.setName("parkingBoy");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);smartParkingBoy.setName("smartParkingBoy");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);superSmartParkingBoy.setName("superSmartParkingBoy");
        HashMap<String,ParkingBoy> managementList = new HashMap<>();
        managementList.put("parkingBoy",parkingBoy);
        managementList.put("smartParkingBoy",smartParkingBoy);
        managementList.put("superSmartParkingBoy",superSmartParkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,managementList);
        Car car = new Car();
        //when
        Ticket ticket= parkingLotManager.specifyPark("parkingBoy",car);
        Car actualCar = parkingLotManager.specifyFetch("parkingBoy",ticket);
        //then
        Assertions.assertEquals(car,actualCar);
    }
    @Test
    public void should_return_a_correct_car_when_given_a_car() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);parkingBoy.setName("parkingBoy");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);smartParkingBoy.setName("smartParkingBoy");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);superSmartParkingBoy.setName("superSmartParkingBoy");
        HashMap<String,ParkingBoy> managementList = new HashMap<>();
        managementList.put("parkingBoy",parkingBoy);
        managementList.put("smartParkingBoy",smartParkingBoy);
        managementList.put("superSmartParkingBoy",superSmartParkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,managementList);
        Car car = new Car();
        //when
        Ticket ticket= parkingLotManager.park(car);
        Car fetchCar = parkingLotManager.fetch(ticket);
        //then
        Assertions.assertEquals(car,fetchCar);
    }
    @Test
    public void should_return_a_error_message_when_pakring_boy_failed_to_do_the_operation() throws Exception {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);parkingBoy.setName("parkingBoy");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);smartParkingBoy.setName("smartParkingBoy");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);superSmartParkingBoy.setName("superSmartParkingBoy");
        HashMap<String,ParkingBoy> managementList = new HashMap<>();
        managementList.put("parkingBoy",parkingBoy);
        managementList.put("smartParkingBoy",smartParkingBoy);
        managementList.put("superSmartParkingBoy",superSmartParkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,managementList);
        //when
        Car car = null;
        //then
        Assertions.assertThrows(Exception.class,() -> parkingLotManager.specifyPark("parkingBoy",car));
    }
}
