package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

import ru.sfedu.transportmanagementsystem.entities.*;
import ru.sfedu.transportmanagementsystem.api.JdbcDataProvider;
import ru.sfedu.transportmanagementsystem.api.IDataProvider;

/**
 *
 * @author HOME
 */

public class TestJDBC {

    private static final Logger log = LogManager.getLogger(TestJDBC.class);
    IDataProvider providerJDBC = new JdbcDataProvider();

    public TestJDBC() {
    }


    /*
     тесты класса Bort
    */


    @Test
    public void testBortCreateSuccess() {
        Bort bort = new Bort(2, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.SUCCESS, providerJDBC.createBort(bort));
    }


    @Test
    public void testBortCreateFail() {
        Bort bort = new Bort(1, "testName", 20000, "АБВГД123", 100, 40, 80);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createBort(bort));
    }

    @Test
    public void testBortGetByIdSuccess(){
        Boolean bort = providerJDBC.getBortById(1).isPresent();
        assertTrue(bort);
    }

    @Test
    public void testBortGetByIdFail(){
        Boolean bort = providerJDBC.getBortById(2).isPresent();
        assertFalse(bort);
    }
    @Test
    public void testBortUpdateSuccess() {
        Bort bort = new Bort(1, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerJDBC.updateBort(bort);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testBortUpdateFail() {
        Bort bort = new Bort(3, "testName", 20000, "АБВГД123", 200, 40, 80);
        Result result = providerJDBC.updateBort(bort);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testBortDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteBortById(2));
    }

    @Test
    public void testBortDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteBortById(3));
    }


    /*
     тесты класса Transport
    */


    @Test
    public void testTransportCreateSuccess() {
        Transport transport = new Transport(2, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.SUCCESS, providerJDBC.createTransport(transport));
    }

    @Test
    public void testTransportCreateFail() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createTransport(transport));
    }

    @Test
    public void testTransportGetByIdSuccess() {
        Boolean transport = providerJDBC.getTransportById(1).isPresent();
        assertTrue(transport);
    }

    @Test
    public void testTransportGetByIdFail() {
        Boolean transport = providerJDBC.getTransportById(3).isPresent();
        assertFalse(transport);
    }

    @Test
    public void testTransportUpdateSuccess() {
        Transport transport = new Transport(1, "testName", 20000, "АБВГД123", 100);
        Result result = providerJDBC.updateTransport(transport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTransportUpdateFail() {
        Transport transport = new Transport(3, "testName", 20000, "АБВГД123", 100);
        Result result = providerJDBC.updateTransport(transport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteTransportById(2));
    }

    @Test
    public void testTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteTransportById(3));
    }


    /*
     тесты класса Platform
    */


    @Test
    public void testPlatformCreateSuccess() {
        Platform platform = new Platform(2, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.SUCCESS, providerJDBC.createPlatform(platform));
    }

    @Test
    public void testPlatformCreateFail() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createPlatform(platform));
    }

    @Test
    public void testPlatformGetByIdSuccess() {
        Boolean platform = providerJDBC.getPlatformById(1).isPresent();
        assertTrue(platform);
    }

    @Test
    public void testPlatformGetByIdFail() {
        Boolean platform = providerJDBC.getPlatformById(3).isPresent();
        assertFalse(platform);
    }

    @Test
    public void testPlatformUpdateSuccess() {
        Platform platform = new Platform(1, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerJDBC.updatePlatform(platform);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testPlatformUpdateFail() {
        Platform platform = new Platform(3, "testName", 20000, "АБВГД123", 100, 40, 60);
        Result result = providerJDBC.updatePlatform(platform);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testPlatformDeleteSuccess() { assertEquals(Result.SUCCESS, providerJDBC.deletePlatformById(2)); }

    @Test
    public void testPlatformDeleteFail() { assertEquals(Result.UNSUCCESSFUL, providerJDBC.deletePlatformById(3)); }


    /*
     тесты класса ClosedTransport
    */


    @Test
    public void testClosedTransportCreateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(2, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.SUCCESS, providerJDBC.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportCreateFail() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createClosedTransport(closedTransport));
    }

    @Test
    public void testClosedTransportGetByIdSuccess() {
        Boolean closedTransport = providerJDBC.getClosedTransportById(1).isPresent();
        assertTrue(closedTransport);
    }

    @Test
    public void testClosedTransportGetByIdFail() {
        Boolean closedTransport = providerJDBC.getClosedTransportById(3).isPresent();
        assertFalse(closedTransport);
    }

    @Test
    public void testClosedTransportUpdateSuccess() {
        ClosedTransport closedTransport = new ClosedTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerJDBC.updateClosedTransport(closedTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testClosedTransportUpdateFail() {
        ClosedTransport closedTransport = new ClosedTransport(3, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerJDBC.updateClosedTransport(closedTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testClosedTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteClosedTransportById(2));
    }

    @Test
    public void testClosedTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteClosedTransportById(3));
    }


    /*
     тесты класса OpenTransport
    */


    @Test
    public void testOpenTransportCreateSuccess() {
        OpenTransport openTransport = new OpenTransport(2, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.SUCCESS, providerJDBC.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportCreateFail() {
        OpenTransport openTransport = new OpenTransport(1, "testName", 20000, "АБВГД123", 100, 40);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createOpenTransport(openTransport));
    }

    @Test
    public void testOpenTransportGetByIdSuccess() {
        Boolean openTransport = providerJDBC.getOpenTransportById(1).isPresent();
        assertTrue(openTransport);
    }

    @Test
    public void testOpenTransportGetByIdFail() {
        Boolean openTransport = providerJDBC.getOpenTransportById(3).isPresent();
        assertFalse(openTransport);
    }

    @Test
    public void testOpenTransportUpdateSuccess() {
        OpenTransport openTransport = new OpenTransport(1, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerJDBC.updateOpenTransport(openTransport);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testOpenTransportUpdateFail() {
        OpenTransport openTransport = new OpenTransport(3, "testName", 20000, "АБВГД123", 100, 400);
        Result result = providerJDBC.updateOpenTransport(openTransport);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testOpenTransportDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteOpenTransportById(2));
    }

    @Test
    public void testOpenTransportDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteOpenTransportById(3));
    }


   /*
     тесты класса Cargo
    */


    @Test
    public void testCargoCreateSuccess() {
        Cargo cargo = new Cargo(2, "testName", 4000, CargoType.General);
        assertEquals(Result.SUCCESS, providerJDBC.createCargo(cargo));
    }

    @Test
    public void testCargoCreateFail() {
        Cargo cargo = new Cargo(1, "testName", 4000, CargoType.General);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createCargo(cargo));
    }

    @Test
    public void testCargoGetByIdSuccess() {
        Boolean cargo = providerJDBC.getCargoById(1).isPresent();
        assertTrue(cargo);
    }

    @Test
    public void testCargoGetByIdFail() {
        Boolean cargo = providerJDBC.getCargoById(3).isPresent();
        assertFalse(cargo);
    }

    @Test
    public void testCargoUpdateSuccess() {
        Cargo cargo = new Cargo(1, "testName", 4000, CargoType.General);
        Result result = providerJDBC.updateCargo(cargo);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testCargoUpdateFail() {
        Cargo cargo = new Cargo(3, "testName", 4000, CargoType.General);
        Result result = providerJDBC.updateCargo(cargo);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testCargoDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteCargoById(2));
    }

    @Test
    public void testCargoDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteCargoById(3));
    }

      /*
     тесты класса Container
    */


    @Test
    public void testContainerCreate() {
        Container container = new Container(2, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.SUCCESS, providerJDBC.createContainer(container));
    }

    @Test
    public void testContainerCreateFail() {
        Container container = new Container(1, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createContainer(container));
    }

    @Test
    public void testContainerGetByIdSuccess() {
        Boolean container = providerJDBC.getContainerById(1).isPresent();
        assertTrue(container);
    }

    @Test
    public void testContainerGetByIdFail() {
        Boolean container = providerJDBC.getContainerById(3).isPresent();
        assertFalse(container);
    }

    @Test
    public void testContainerUpdateSuccess() {
        Container container = new Container(1, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerJDBC.updateContainer(container);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testContainerUpdateFail() {
        Container container = new Container(3, "testName", 4000,"АБВГД123",150,600,ContainerType._20f);
        Result result = providerJDBC.updateContainer(container);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testContainerDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteContainerById(2));
    }

    @Test
    public void testContainerDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteContainerById(3));
    }


    /*
     тесты класса Driver
    */


    @Test
    public void testDriverCreateSuccess() {
        Driver driver = new Driver(2, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.SUCCESS, providerJDBC.createDriver(driver));
    }

    @Test
    public void testDriverCreateFail() {
        Driver driver = new Driver(1, "testName","1234 56789",DrivingLicenseGrade.D);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createDriver(driver));
    }

    @Test
    public void testDriverGetByIdSuccess() {
        Boolean driver = providerJDBC.getDriverById(1).isPresent();
        assertTrue(driver);
    }

    @Test
    public void testDriverGetByIdFail() {
        Boolean driver = providerJDBC.getDriverById(3).isPresent();
        assertFalse(driver);
    }

    @Test
    public void testDriverUpdateSuccess() {
        Driver driver = new Driver(1, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerJDBC.updateDriver(driver);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testDriverUpdateFail() {
        Driver driver = new Driver(3, "testName","1234 56789",DrivingLicenseGrade.D);
        Result result = providerJDBC.updateDriver(driver);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testDriverDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteDriverById(2));
    }

    @Test
    public void testDriverDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteDriverById(3));
    }


    /*
     тесты класса Refrigerator
    */


    @Test
    public void testRefrigeratorCreateSuccess() {
        Refrigerator refrigerator = new Refrigerator(2, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.SUCCESS, providerJDBC.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorCreateFail() {
        Refrigerator refrigerator = new Refrigerator(1, "testName", 4000,"АБВГД123",150,600,-15,RefrigeratorClass.B);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createRefrigerator(refrigerator));
    }

    @Test
    public void testRefrigeratorGetByIdSuccess() {
        Boolean refrigerator = providerJDBC.getRefrigeratorById(1).isPresent();
        assertTrue(refrigerator);
    }

    @Test
    public void testRefrigeratorGetByIdFail() {
        Boolean refrigerator = providerJDBC.getRefrigeratorById(3).isPresent();
        assertFalse(refrigerator);
    }

    @Test
    public void testRefrigeratorUpdateSuccess() {
        Refrigerator refrigerator = new Refrigerator(1, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerJDBC.updateRefrigerator(refrigerator);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testRefrigeratorUpdateFail() {
        Refrigerator refrigerator = new Refrigerator(3, "testName", 4000,"АБВГД123",150,600,-20,RefrigeratorClass.A);
        Result result = providerJDBC.updateRefrigerator(refrigerator);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testRefrigeratorDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteRefrigeratorById(2));
    }

    @Test
    public void testRefrigeratorDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteRefrigeratorById(3));
    }


    /*
     тесты класса Tent
    */


    @Test
    public void testTentCreateSuccess() {
        Tent tent = new Tent(2, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.SUCCESS, providerJDBC.createTent(tent));
    }

    @Test
    public void testTentCreateFail() {
        Tent tent = new Tent(1, "testName", 20000, "АБВГД123", 100, 400,TentType.Hard);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createTent(tent));
    }

    @Test
    public void testTentGetByIdSuccess() {
        Boolean tent = providerJDBC.getTentById(1).isPresent();
        assertTrue(tent);
    }

    @Test
    public void testTentGetByIdFail() {
        Boolean tent = providerJDBC.getTentById(3).isPresent();
        assertFalse(tent);
    }

    @Test
    public void testTentUpdateSuccess() {
        Tent tent = new Tent(1, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerJDBC.updateTent(tent);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTentUpdateFail() {
        Tent tent = new Tent(3, "testName", 20000, "АБВГД123", 100, 400,TentType.Soft);
        Result result = providerJDBC.updateTent(tent);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTentDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteTentById(2));
    }

    @Test
    public void testTentDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteTentById(3));
    }


     /*
     тесты класса Traffic
    */


    @Test
    public void testTrafficCreateSuccess() {
        Traffic traffic = new Traffic(2,0,0,0,100);
        assertEquals(Result.SUCCESS, providerJDBC.createTraffic(traffic));
    }

    @Test
    public void testTrafficCreateFail() {
        Traffic traffic = new Traffic(1,0,0,0,100);
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.createTraffic(traffic));
    }

    @Test
    public void testTrafficGetByIdSuccess() {
        Boolean traffic = providerJDBC.getTrafficById(1).isPresent();
        assertTrue(traffic);
    }

    @Test
    public void testTrafficGetByIdFail() {
        Boolean traffic = providerJDBC.getTrafficById(3).isPresent();
        assertFalse(traffic);
    }

    @Test
    public void testTrafficUpdateSuccess() {
        Traffic traffic = new Traffic(1, 0,0,0,100);
        Result result = providerJDBC.updateTraffic(traffic);
        assertEquals(Result.SUCCESS,result);
    }

    @Test
    public void testTrafficUpdateFail() {
        Traffic traffic = new Traffic(3, 0,0,0,100);
        Result result = providerJDBC.updateTraffic(traffic);
        assertEquals(Result.UNSUCCESSFUL,result);
    }

    @Test
    public void testTrafficDeleteSuccess() {
        assertEquals(Result.SUCCESS, providerJDBC.deleteTrafficById(1));
    }

    @Test
    public void testTrafficDeleteFail() {
        assertEquals(Result.UNSUCCESSFUL, providerJDBC.deleteTrafficById(3));
    }

}
