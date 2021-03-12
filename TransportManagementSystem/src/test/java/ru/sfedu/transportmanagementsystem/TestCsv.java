package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


import static org.junit.Assert.*;
import ru.sfedu.transportmanagementsystem.entities.*;
import ru.sfedu.transportmanagementsystem.api.CsvDataProvider;
import ru.sfedu.transportmanagementsystem.api.IDataProvider;

/**
 *
 * @author HOME
 */
public class TestCsv {
    private static final Logger log = LogManager.getLogger(TestCsv.class);
    IDataProvider providerCSV = new CsvDataProvider();

    public TestCsv() {
    }


    /*
     тесты класса Bort
    */


    @Test
    public void testBortCreateSuccess() {
        Bort bort = new Bort(2, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.SUCCESS, providerCSV.createBort(bort));
    }

    @Test
    public void testBortCreateFail() {
        Bort bort = new Bort(0, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createBort(bort));
    }

    @Test
    public void testBortGetByIdSuccess() {
        Boolean bort = providerCSV.getBortById(0).isPresent();
        assertTrue(bort);
    }

    @Test
    public void testBortGetByIdFail() {
        Boolean bort = providerCSV.getBortById(10).isPresent();
        assertFalse(bort);
    }

    @Test
    public void testBortUpdateSuccess() {
        Bort bort = new Bort(0, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerCSV.updateBort(bort);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testBortUpdateFail() {
        Bort bort = new Bort(3, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerCSV.updateBort(bort);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testBortDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteBortById(2));
    }

    @Test
    public void testBortDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteBortById(3));
    }


    /*
     тесты класса Transport
    */


    @Test
    public void testTransportCreateSuccess() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.SUCCESS, providerCSV.createTransport(transport));
    }

    @Test
    public void testTransportCreateFail() {
        Transport transport = new Transport(0, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createTransport(transport));
    }

    @Test
    public void testTransportGetByIdSuccess() {
        Boolean transport = providerCSV.getTransportById(0).isPresent();
        assertTrue(transport);
    }

    @Test
    public void testTransportGetByIdFail() {
        Boolean transport = providerCSV.getTransportById(2).isPresent();
        assertFalse(transport);
    }

    @Test
    public void testTransportUpdateSuccess() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        Result result = providerCSV.updateTransport(transport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTransportUpdateFail() {
        Transport transport = new Transport(2, "testName", 20000, "АБВГД123", 100);
        Result result = providerCSV.updateTransport(transport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteTransportById(1));
    }

    @Test
    public void testTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteTransportById(2));
    }

    /*
     тесты класса Platform
    */

    @Test
    public void testPlatformCreateSuccess() {
        Platform platform = new Platform(2, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.SUCCESS, providerCSV.createPlatform(platform));
    }

    @Test
    public void testPlatformCreateFail() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createPlatform(platform));
    }

    @Test
    public void testPlatformGetByIdSuccess() {
        Boolean platform = providerCSV.getPlatformById(1).isPresent();
        assertTrue(platform);
    }

    @Test
    public void testPlatformGetByIdFail() {
        Boolean platform = providerCSV.getPlatformById(3).isPresent();
        assertFalse(platform);
    }

    @Test
    public void testPlatformUpdateSuccess() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerCSV.updatePlatform(platform);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testPlatformUpdateFail() {
        Platform platform = new Platform(3, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerCSV.updatePlatform(platform);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testPlatformDeleteSuccess() { assertEquals(Result.SUCCESS, providerCSV.deletePlatformById(2)); }

    @Test
    public void testPlatformDeleteFail() { assertEquals(Result.UNSUCCESSFUL, providerCSV.deletePlatformById(3)); }


    /*
     тесты класса ClosedTransport
    */


    @Test
    public void testClosedTransportCreateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.SUCCESS, providerCSV.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportCreateFail() {
        ClosedTransport closedTransport = new ClosedTransport(0, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportGetByIdSuccess() {
        Boolean closedTransport = providerCSV.getClosedTransportById(1).isPresent();
        assertTrue(closedTransport);
    }

    @Test
    public void testClosedTransportGetByIdFail() {
        Boolean closedTransport = providerCSV.getClosedTransportById(3).isPresent();
        assertFalse(closedTransport);
    }

    @Test
    public void testClosedTransportUpdateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerCSV.updateClosedTransport(closedTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testClosedTransportUpdateFail() {
        ClosedTransport closedTransport = new ClosedTransport(3, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerCSV.updateClosedTransport(closedTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testClosedTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteClosedTransportById(1));
    }

    @Test
    public void testClosedTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteClosedTransportById(3));
    }


    /*
     тесты класса OpenTransport
    */


    @Test
    public void testOpenTransportCreateSuccess() {
        OpenTransport openTransport = new OpenTransport(1, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.SUCCESS, providerCSV.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportCreateFail() {
        OpenTransport openTransport = new OpenTransport(0, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportGetByIdSuccess() {
        Boolean openTransport = providerCSV.getOpenTransportById(0).isPresent();
        assertTrue(openTransport);
    }

    @Test
    public void testOpenTransportGetByIdFail() {
        Boolean openTransport = providerCSV.getOpenTransportById(3).isPresent();
        assertFalse(openTransport);
    }

    @Test
    public void testOpenTransportUpdateSuccess() {
        OpenTransport openTransport = new OpenTransport(0, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerCSV.updateOpenTransport(openTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testOpenTransportUpdateFail() {
        OpenTransport openTransport = new OpenTransport(2, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerCSV.updateOpenTransport(openTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testOpenTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteOpenTransportById(1));
    }

    @Test
    public void testOpenTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteOpenTransportById(3));
    }


    /*
     тесты класса Cargo
    */


    @Test
    public void testCargoCreateSuccess() {
        Cargo cargo = new Cargo(1, "testName", 4000, CargoType.General);
        assertEquals(Result.SUCCESS, providerCSV.createCargo(cargo));
    }

    @Test
    public void testCargoCreateFail() {
        Cargo cargo = new Cargo(0, "testName", 4000, CargoType.General);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createCargo(cargo));
    }

    @Test
    public void testCargoGetByIdSuccess() {
        Boolean cargo = providerCSV.getCargoById(0).isPresent();
        assertTrue(cargo);
    }

    @Test
    public void testCargoGetByIdFail() {
        Boolean cargo = providerCSV.getCargoById(3).isPresent();
        assertFalse(cargo);
    }

    @Test
    public void testCargoUpdateSuccess() {
        Cargo cargo = new Cargo(1, "testName", 4000, CargoType.General);
        Result result = providerCSV.updateCargo(cargo);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testCargoUpdateFail() {
        Cargo cargo = new Cargo(3, "testName", 4000, CargoType.General);
        Result result = providerCSV.updateCargo(cargo);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testCargoDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteCargoById(1));
    }

    @Test
    public void testCargoDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteCargoById(3));
    }


    /*
     тесты класса Container
    */


    @Test
    public void testContainerCreate() {
        Container container = new Container(1, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.SUCCESS, providerCSV.createContainer(container));
    }

    @Test
    public void testContainerCreateFail() {
        Container container = new Container(0, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createContainer(container));
    }

    @Test
    public void testContainerGetByIdSuccess() {
        Boolean container = providerCSV.getContainerById(0).isPresent();
        assertTrue(container);
    }

    @Test
    public void testContainerGetByIdFail() {
        Boolean container = providerCSV.getContainerById(3).isPresent();
        assertFalse(container);
    }

    @Test
    public void testContainerUpdateSuccess() {
        Container container = new Container(0, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerCSV.updateContainer(container);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testContainerUpdateFail() {
        Container container = new Container(3, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerCSV.updateContainer(container);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testContainerDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteContainerById(1));
    }

    @Test
    public void testContainerDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteContainerById(3));
    }


    /*
     тесты класса Driver
    */


    @Test
    public void testDriverCreateSuccess() {
        Driver driver = new Driver(1, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.SUCCESS, providerCSV.createDriver(driver));
    }

    @Test
    public void testDriverCreateFail() {
        Driver driver = new Driver(0, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createDriver(driver));
    }

    @Test
    public void testDriverGetByIdSuccess() {
        Boolean driver = providerCSV.getDriverById(0).isPresent();
        assertTrue(driver);
    }

    @Test
    public void testDriverGetByIdFail() {
        Boolean driver = providerCSV.getDriverById(3).isPresent();
        assertFalse(driver);
    }

    @Test
    public void testDriverUpdateSuccess() {
        Driver driver = new Driver(0, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerCSV.updateDriver(driver);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testDriverUpdateFail() {
        Driver driver = new Driver(3, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerCSV.updateDriver(driver);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testDriverDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteDriverById(1));
    }

    @Test
    public void testDriverDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteDriverById(3));
    }


    /*
     тесты класса Refrigerator
    */


    @Test
    public void testRefrigeratorCreateSuccess() {
        Refrigerator refrigerator = new Refrigerator(1, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.SUCCESS, providerCSV.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorCreateFail() {
        Refrigerator refrigerator = new Refrigerator(0, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorGetByIdSuccess() {
        Boolean refrigerator = providerCSV.getRefrigeratorById(0).isPresent();
        assertTrue(refrigerator);
    }

    @Test
    public void testRefrigeratorGetByIdFail() {
        Boolean refrigerator = providerCSV.getRefrigeratorById(3).isPresent();
        assertFalse(refrigerator);
    }

    @Test
    public void testRefrigeratorUpdateSuccess() {
        Refrigerator refrigerator = new Refrigerator(0, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerCSV.updateRefrigerator(refrigerator);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testRefrigeratorUpdateFail() {
        Refrigerator refrigerator = new Refrigerator(3, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerCSV.updateRefrigerator(refrigerator);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testRefrigeratorDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteRefrigeratorById(1));
    }

    @Test
    public void testRefrigeratorDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteRefrigeratorById(3));
    }


    /*
     тесты класса Tent
    */


    @Test
    public void testTentCreateSuccess() {
        Tent tent = new Tent(1, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.SUCCESS, providerCSV.createTent(tent));
    }

    @Test
    public void testTentCreateFail() {
        Tent tent = new Tent(0, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createTent(tent));
    }

    @Test
    public void testTentGetByIdSuccess() {
        Boolean tent = providerCSV.getTentById(0).isPresent();
        assertTrue(tent);
    }

    @Test
    public void testTentGetByIdFail() {
        Boolean tent = providerCSV.getTentById(3).isPresent();
        assertFalse(tent);
    }

    @Test
    public void testTentUpdateSuccess() {
        Tent tent = new Tent(0, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerCSV.updateTent(tent);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTentUpdateFail() {
        Tent tent = new Tent(3, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerCSV.updateTent(tent);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTentDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteTentById(1));
    }

    @Test
    public void testTentDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteTentById(3));
    }


    /*
     тесты класса Traffic
    */


    @Test
    public void testTrafficCreateSuccess() {
        Traffic traffic = new Traffic(1,0,0,0,100);
        assertEquals(Result.SUCCESS, providerCSV.createTraffic(traffic));
    }

    @Test
    public void testTrafficCreateFail() {
        Traffic traffic = new Traffic(0,0,0,0,100);
        assertEquals(Result.UNSUCCESSFUL, providerCSV.createTraffic(traffic));
    }

    @Test
    public void testTrafficGetByIdSuccess() {
        Boolean traffic = providerCSV.getTrafficById(0).isPresent();
        assertTrue(traffic);
    }

    @Test
    public void testTrafficGetByIdFail() {
        Boolean traffic = providerCSV.getTrafficById(3).isPresent();
        assertFalse(traffic);
    }

    @Test
    public void testTrafficUpdateSuccess() {
        Traffic traffic = new Traffic(0, 0,0,0,100);
        Result result = providerCSV.updateTraffic(traffic);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTrafficUpdateFail() {
        Traffic traffic = new Traffic(3, 0,0,0,100);
        Result result = providerCSV.updateTraffic(traffic);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTrafficDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerCSV.deleteTrafficById(1));
    }

    @Test
    public void testTrafficDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerCSV.deleteTrafficById(3));
    }

}