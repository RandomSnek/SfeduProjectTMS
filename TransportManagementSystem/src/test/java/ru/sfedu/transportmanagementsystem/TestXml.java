package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


import static org.junit.Assert.*;
import ru.sfedu.transportmanagementsystem.entities.*;
import ru.sfedu.transportmanagementsystem.api.XmlDataProvider;
import ru.sfedu.transportmanagementsystem.api.IDataProvider;

/**
 *
 * @author HOME
 */

public class TestXml {
    private static final Logger log = LogManager.getLogger(TestXml.class);
    IDataProvider providerXml = new XmlDataProvider();

    public TestXml() {
    }


    /*
     тесты класса Bort
    */


    @Test
    public void testBortCreateSuccess() {
        Bort bort = new Bort(1, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.SUCCESS, providerXml.createBort(bort));
    }

    @Test
    public void testBortCreateFail() {
        Bort bort = new Bort(0, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createBort(bort));
    }

    @Test
    public void testBortGetByIdSuccess() {
        Boolean bort = providerXml.getBortById(0).isPresent();
        assertTrue(bort);
    }

    @Test
    public void testBortGetByIdFail() {
        Boolean bort = providerXml.getBortById(2).isPresent();
        assertFalse(bort);
    }

    @Test
    public void testBortUpdateSuccess() {
        Bort bort = new Bort(0, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerXml.updateBort(bort);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testBortUpdateFail() {
        Bort bort = new Bort(3, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerXml.updateBort(bort);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testBortDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteBortById(1));
    }

    @Test
    public void testBortDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteBortById(3));
    }


    /*
     тесты класса Transport
    */


    @Test
    public void testTransportCreateSuccess() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.SUCCESS, providerXml.createTransport(transport));
    }

    @Test
    public void testTransportCreateFail() {
        Transport transport = new Transport(0, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createTransport(transport));
    }

    @Test
    public void testTransportGetByIdSuccess() {
        Boolean transport = providerXml.getTransportById(0).isPresent();
        assertTrue(transport);
    }

    @Test
    public void testTransportGetByIdFail() {
        Boolean transport = providerXml.getTransportById(2).isPresent();
        assertFalse(transport);
    }

    @Test
    public void testTransportUpdateSuccess() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        Result result = providerXml.updateTransport(transport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTransportUpdateFail() {
        Transport transport = new Transport(2, "testName", 20000, "АБВГД123", 100);
        Result result = providerXml.updateTransport(transport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteTransportById(1));
    }

    @Test
    public void testTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteTransportById(2));
    }

    /*
     тесты класса Platform
    */

    @Test
    public void testPlatformCreateSuccess() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.SUCCESS, providerXml.createPlatform(platform));
    }

    @Test
    public void testPlatformCreateFail() {
        Platform platform = new Platform(2, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createPlatform(platform));
    }

    @Test
    public void testPlatformGetByIdSuccess() {
        Boolean platform = providerXml.getPlatformById(1).isPresent();
        assertTrue(platform);
    }

    @Test
    public void testPlatformGetByIdFail() {
        Boolean platform = providerXml.getPlatformById(3).isPresent();
        assertFalse(platform);
    }

    @Test
    public void testPlatformUpdateSuccess() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerXml.updatePlatform(platform);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testPlatformUpdateFail() {
        Platform platform = new Platform(3, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerXml.updatePlatform(platform);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testPlatformDeleteSuccess() { assertEquals(Result.SUCCESS, providerXml.deletePlatformById(2)); }

    @Test
    public void testPlatformDeleteFail() { assertEquals(Result.UNSUCCESSFUL, providerXml.deletePlatformById(3)); }


    /*
     тесты класса ClosedTransport
    */


    @Test
    public void testClosedTransportCreateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.SUCCESS, providerXml.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportCreateFail() {
        ClosedTransport closedTransport = new ClosedTransport(0, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportGetByIdSuccess() {
        Boolean closedTransport = providerXml.getClosedTransportById(1).isPresent();
        assertTrue(closedTransport);
    }

    @Test
    public void testClosedTransportGetByIdFail() {
        Boolean closedTransport = providerXml.getClosedTransportById(3).isPresent();
        assertFalse(closedTransport);
    }

    @Test
    public void testClosedTransportUpdateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerXml.updateClosedTransport(closedTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testClosedTransportUpdateFail() {
        ClosedTransport closedTransport = new ClosedTransport(3, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerXml.updateClosedTransport(closedTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testClosedTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteClosedTransportById(0));
    }

    @Test
    public void testClosedTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteClosedTransportById(3));
    }


    /*
     тесты класса OpenTransport
    */


    @Test
    public void testOpenTransportCreateSuccess() {
        OpenTransport openTransport = new OpenTransport(1, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.SUCCESS, providerXml.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportCreateFail() {
        OpenTransport openTransport = new OpenTransport(0, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportGetByIdSuccess() {
        Boolean openTransport = providerXml.getOpenTransportById(0).isPresent();
        assertTrue(openTransport);
    }

    @Test
    public void testOpenTransportGetByIdFail() {
        Boolean openTransport = providerXml.getOpenTransportById(3).isPresent();
        assertFalse(openTransport);
    }

    @Test
    public void testOpenTransportUpdateSuccess() {
        OpenTransport openTransport = new OpenTransport(0, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerXml.updateOpenTransport(openTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testOpenTransportUpdateFail() {
        OpenTransport openTransport = new OpenTransport(2, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerXml.updateOpenTransport(openTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testOpenTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteOpenTransportById(1));
    }

    @Test
    public void testOpenTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteOpenTransportById(3));
    }


    /*
     тесты класса Cargo
    */


    @Test
    public void testCargoCreateSuccess() {
        Cargo cargo = new Cargo(0, "testName", 4000, CargoType.General);
        assertEquals(Result.SUCCESS, providerXml.createCargo(cargo));
    }

    @Test
    public void testCargoCreateFail() {
        Cargo cargo = new Cargo(0, "testName", 4000, CargoType.General);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createCargo(cargo));
    }

    @Test
    public void testCargoGetByIdSuccess() {
        Boolean cargo = providerXml.getCargoById(0).isPresent();
        assertTrue(cargo);
    }

    @Test
    public void testCargoGetByIdFail() {
        Boolean cargo = providerXml.getCargoById(3).isPresent();
        assertFalse(cargo);
    }

    @Test
    public void testCargoUpdateSuccess() {
        Cargo cargo = new Cargo(1, "testName", 4000, CargoType.General);
        Result result = providerXml.updateCargo(cargo);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testCargoUpdateFail() {
        Cargo cargo = new Cargo(3, "testName", 4000, CargoType.General);
        Result result = providerXml.updateCargo(cargo);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testCargoDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteCargoById(1));
    }

    @Test
    public void testCargoDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteCargoById(3));
    }


    /*
     тесты класса Container
    */


    @Test
    public void testContainerCreate() {
        Container container = new Container(1, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.SUCCESS, providerXml.createContainer(container));
    }

    @Test
    public void testContainerCreateFail() {
        Container container = new Container(0, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createContainer(container));
    }

    @Test
    public void testContainerGetByIdSuccess() {
        Boolean container = providerXml.getContainerById(0).isPresent();
        assertTrue(container);
    }

    @Test
    public void testContainerGetByIdFail() {
        Boolean container = providerXml.getContainerById(3).isPresent();
        assertFalse(container);
    }

    @Test
    public void testContainerUpdateSuccess() {
        Container container = new Container(0, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerXml.updateContainer(container);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testContainerUpdateFail() {
        Container container = new Container(3, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerXml.updateContainer(container);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testContainerDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteContainerById(1));
    }

    @Test
    public void testContainerDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteContainerById(3));
    }


    /*
     тесты класса Driver
    */


    @Test
    public void testDriverCreateSuccess() {
        Driver driver = new Driver(1, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.SUCCESS, providerXml.createDriver(driver));
    }

    @Test
    public void testDriverCreateFail() {
        Driver driver = new Driver(0, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createDriver(driver));
    }

    @Test
    public void testDriverGetByIdSuccess() {
        Boolean driver = providerXml.getDriverById(0).isPresent();
        assertTrue(driver);
    }

    @Test
    public void testDriverGetByIdFail() {
        Boolean driver = providerXml.getDriverById(3).isPresent();
        assertFalse(driver);
    }

    @Test
    public void testDriverUpdateSuccess() {
        Driver driver = new Driver(0, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerXml.updateDriver(driver);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testDriverUpdateFail() {
        Driver driver = new Driver(3, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerXml.updateDriver(driver);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testDriverDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteDriverById(1));
    }

    @Test
    public void testDriverDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteDriverById(3));
    }


    /*
     тесты класса Refrigerator
    */


    @Test
    public void testRefrigeratorCreateSuccess() {
        Refrigerator refrigerator = new Refrigerator(1, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.SUCCESS, providerXml.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorCreateFail() {
        Refrigerator refrigerator = new Refrigerator(0, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorGetByIdSuccess() {
        Boolean refrigerator = providerXml.getRefrigeratorById(0).isPresent();
        assertTrue(refrigerator);
    }

    @Test
    public void testRefrigeratorGetByIdFail() {
        Boolean refrigerator = providerXml.getRefrigeratorById(3).isPresent();
        assertFalse(refrigerator);
    }

    @Test
    public void testRefrigeratorUpdateSuccess() {
        Refrigerator refrigerator = new Refrigerator(0, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerXml.updateRefrigerator(refrigerator);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testRefrigeratorUpdateFail() {
        Refrigerator refrigerator = new Refrigerator(3, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerXml.updateRefrigerator(refrigerator);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testRefrigeratorDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteRefrigeratorById(1));
    }

    @Test
    public void testRefrigeratorDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteRefrigeratorById(3));
    }


    /*
     тесты класса Tent
    */


    @Test
    public void testTentCreateSuccess() {
        Tent tent = new Tent(1, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.SUCCESS, providerXml.createTent(tent));
    }

    @Test
    public void testTentCreateFail() {
        Tent tent = new Tent(0, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createTent(tent));
    }

    @Test
    public void testTentGetByIdSuccess() {
        Boolean tent = providerXml.getTentById(0).isPresent();
        assertTrue(tent);
    }

    @Test
    public void testTentGetByIdFail() {
        Boolean tent = providerXml.getTentById(3).isPresent();
        assertFalse(tent);
    }

    @Test
    public void testTentUpdateSuccess() {
        Tent tent = new Tent(0, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerXml.updateTent(tent);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTentUpdateFail() {
        Tent tent = new Tent(3, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerXml.updateTent(tent);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTentDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteTentById(1));
    }

    @Test
    public void testTentDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteTentById(3));
    }


    /*
     тесты класса Traffic
    */


    @Test
    public void testTrafficCreateSuccess() {
        Traffic traffic = new Traffic(1,0,0,0,100);
        assertEquals(Result.SUCCESS, providerXml.createTraffic(traffic));
    }

    @Test
    public void testTrafficCreateFail() {
        Traffic traffic = new Traffic(0,0,0,0,100);
        assertEquals(Result.UNSUCCESSFUL, providerXml.createTraffic(traffic));
    }

    @Test
    public void testTrafficGetByIdSuccess() {
        Boolean traffic = providerXml.getTrafficById(0).isPresent();
        assertTrue(traffic);
    }

    @Test
    public void testTrafficGetByIdFail() {
        Boolean traffic = providerXml.getTrafficById(3).isPresent();
        assertFalse(traffic);
    }

    @Test
    public void testTrafficUpdateSuccess() {
        Traffic traffic = new Traffic(0, 0,0,0,100);
        Result result = providerXml.updateTraffic(traffic);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTrafficUpdateFail() {
        Traffic traffic = new Traffic(3, 0,0,0,100);
        Result result = providerXml.updateTraffic(traffic);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTrafficDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerXml.deleteTrafficById(1));
    }

    @Test
    public void testTrafficDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerXml.deleteTrafficById(3));
    }

}
