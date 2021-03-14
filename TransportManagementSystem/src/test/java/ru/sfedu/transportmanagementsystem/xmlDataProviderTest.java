package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import ru.sfedu.transportmanagementsystem.api.XmlDataProvider;
import ru.sfedu.transportmanagementsystem.entities.*;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.sfedu.transportmanagementsystem.Constants.*;
import static ru.sfedu.transportmanagementsystem.Main.*;
import static ru.sfedu.transportmanagementsystem.utils.ConfigUtil.getConfigurationEntry;


public class xmlDataProviderTest {
    private static final Logger log = LogManager.getLogger(xmlDataProviderTest.class);
    XmlDataProvider provider = new XmlDataProvider();

    @Before
    public void before() {
        Bort bort = new Bort(9,"test",10000,"test",1000,100,100);
        provider.createBort(bort);
        Cargo cargo = new Cargo(9,"test",100,CargoType.GENERAL);
        provider.createCargo(cargo);
        ClosedTransport closedTransport = new ClosedTransport(9,"test",10000,"test",100,100);
        provider.createClosedTransport(closedTransport);
        Container container = new Container(9,"test",10000,"test",1000,100,ContainerType._20f);
        provider.createContainer(container);
        Driver driver = new Driver(9,"test","test",DrivingLicenseGrade.C);
        provider.createDriver(driver);
        OpenTransport openTransport = new OpenTransport(9,"test",10000,"test",100,100);
        provider.createOpenTransport(openTransport);
        Platform platform = new Platform(9,"test",10000,"test",100,100,100);
        provider.createPlatform(platform);
        Refrigerator refrigerator = new Refrigerator(9,"test",10000,"test",100,100,-20,RefrigeratorClass.A);
        provider.createRefrigerator(refrigerator);
        Tent tent = new Tent(9,"test",10000,"test",100,100,TentType.Soft);
        provider.createTent(tent);
        Traffic traffic = new Traffic(9,1,1,1,100);
        provider.createTraffic(traffic);
        Transport transport = new Transport(9,"test", 10000,"test",100);
        provider.createTransport(transport);
    }

    @Test
    public void addRecord() {
//       Класс Bort
        List<Bort> allBorts = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Bort bort = new Bort();
            bort.setId(i);
            bort.setName("test");
            bort.setMaxWeight(10000);
            bort.setPlates("test");
            bort.setTotalDistance(1000);
            bort.setKuzovLength(100);
            bort.setBortLength(100);
            allBorts.add(bort);
        }
        assertEquals(Result.SUCCESS,provider.update(allBorts, BORT_XML_KEY));

//      Класс  Cargo
        List<Cargo> allCargo = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Cargo cargo = new Cargo();
            cargo.setId(i);
            cargo.setName("test");
            cargo.setWeight(100);
            cargo.setCargoType(CargoType.GENERAL);
            allCargo.add(cargo);
        }
        assertEquals(Result.SUCCESS,provider.update(allCargo, CARGO_XML_KEY));

//       Класс ClosedTransport
        List<ClosedTransport> allClosedTransports = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            ClosedTransport closedTransport = new ClosedTransport();
            closedTransport.setId(i);
            closedTransport.setName("test");
            closedTransport.setMaxWeight(10000);
            closedTransport.setPlates("test");
            closedTransport.setTotalDistance(100);
            closedTransport.setKuzovVolume(100);
            allClosedTransports.add(closedTransport);
        }
        assertEquals(Result.SUCCESS,provider.update(allClosedTransports, CLOSED_TRANSPORT_XML_KEY));

//        Класс Container
        List<Container> allContainers = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Container container = new Container();
            container.setId(i);
            container.setName("test");
            container.setMaxWeight(10000);
            container.setPlates("test");
            container.setTotalDistance(100);
            container.setKuzovVolume(100);
            container.setContainerType(ContainerType._20f);
            allContainers.add(container);
        }
        assertEquals(Result.SUCCESS,provider.update(allContainers, CONTAINER_XML_KEY));

//        Класс Driver
        List<Driver> allDrivers = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Driver driver = new Driver();
            driver.setId(i);
            driver.setFio("test");
            driver.setPassport("test");
            driver.setDrivingLicenseGrade(DrivingLicenseGrade.C);
            allDrivers.add(driver);
        }
        assertEquals(Result.SUCCESS,provider.update(allDrivers, DRIVER_XML_KEY));

//        Класс OpenTransport
        List<OpenTransport> allOpenTransports = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            OpenTransport openTransport = new OpenTransport();
            openTransport.setId(i);
            openTransport.setName("test");
            openTransport.setMaxWeight(10000);
            openTransport.setPlates("test");
            openTransport.setTotalDistance(100);
            openTransport.setKuzovLength(100);
            allOpenTransports.add(openTransport);
        }
        assertEquals(Result.SUCCESS, provider.update(allOpenTransports, OPEN_TRANSPORT_XML_KEY));
        //        Класс Platform
        List<Platform> allPlatforms = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Platform platform = new Platform();
            platform.setId(i);
            platform.setName("test");
            platform.setMaxWeight(10000);
            platform.setPlates("test");
            platform.setTotalDistance(100);
            platform.setKuzovLength(100);
            platform.setLoadingHeight(100);
            allPlatforms.add(platform);
        }
        assertEquals(Result.SUCCESS, provider.update(allPlatforms, PLATFORM_XML_KEY));


        //        Класс Refrigerator
        List<Refrigerator> allRefrigerators = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Refrigerator refrigerator = new Refrigerator();
            refrigerator.setId(i);
            refrigerator.setName("test");
            refrigerator.setMaxWeight(10000);
            refrigerator.setPlates("test");
            refrigerator.setTotalDistance(100);
            refrigerator.setKuzovVolume(100);
            refrigerator.setTemperature(-10);
            refrigerator.setFridgeClass(RefrigeratorClass.A);
            allRefrigerators.add(refrigerator);
        }
        assertEquals(Result.SUCCESS, provider.update(allRefrigerators, REFRIGERATOR_XML_KEY));

//        Класс Tent
        List<Tent> allTents = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Tent tent = new Tent();
            tent.setId(i);
            tent.setName("test");
            tent.setMaxWeight(10000);
            tent.setPlates("test");
            tent.setTotalDistance(100);
            tent.setKuzovVolume(100);
            tent.setTentType(TentType.Soft);
            allTents.add(tent);
        }
        assertEquals(Result.SUCCESS, provider.update(allTents, TENT_XML_KEY));

        //        Класс Traffic
        List<Traffic> allTraffics = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Traffic traffic = new Traffic();
            traffic.setId(i);
            traffic.setCargoId(1);
            traffic.setTransportId(1);
            traffic.setDriverId(1);
            traffic.setDistance(100);
            allTraffics.add(traffic);
        }
        assertEquals(Result.SUCCESS, provider.update(allTraffics, TRAFFIC_XML_KEY));

        //        Класс Transport
        List<Transport> allTransports = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            Transport transport = new Transport();
            transport.setId(i);
            transport.setName("test");
            transport.setMaxWeight(10000);
            transport.setPlates("test");
            transport.setTotalDistance(100);
            allTransports.add(transport);
        }
        assertEquals(Result.SUCCESS, provider.update(allTransports, TRANSPORT_XML_KEY));


    }

    @Test
    public void getRecordById() {
        //    Класс Bort

        for (int i=0; i<=9; i++) {
            boolean result = provider.getBortById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Cargo

        for (int i=0; i<=9; i++) {
            boolean result = provider.getCargoById(i).isPresent();
            assertTrue(result);
        }

        //    Класс ClosedTransport

        for (int i=0; i<=9; i++) {
            boolean result = provider.getClosedTransportById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Container

        for (int i=0; i<=9; i++) {
            boolean result = provider.getContainerById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Driver

        for (int i=0; i<=9; i++) {
            boolean result = provider.getDriverById(i).isPresent();
            assertTrue(result);
        }

        //    Класс OpenTransport

        for (int i=0; i<=9; i++) {
            boolean result = provider.getOpenTransportById(i).isPresent();
            assertTrue(result);
        }


        //    Класс Platform

        for (int i=0; i<=9; i++){
            boolean result = provider.getPlatformById(i).isPresent();
            assertTrue(result);
        }


        //    Класс Refrigerator

        for (int i=0; i<=9; i++) {
            boolean result = provider.getRefrigeratorById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Tent

        for (int i=0; i<=9; i++){
            boolean result = provider.getTentById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Traffic

        for (int i=0; i<=9; i++){
            boolean result = provider.getTrafficById(i).isPresent();
            assertTrue(result);
        }

        //    Класс Transport

        for (int i=0; i<=9; i++){
            boolean result = provider.getTransportById(i).isPresent();
            assertTrue(result);
        }

    }
    @Test
    public void deleteRecordById(){

        //    Класс Bort

        assertEquals(Result.SUCCESS,provider.deleteBortById(9));

        //    Класс Cargo

        assertEquals(Result.SUCCESS,provider.deleteCargoById(9));

        //    Класс ClosedTransport

        assertEquals(Result.SUCCESS,provider.deleteClosedTransportById(9));

        //    Класс Container

        assertEquals(Result.SUCCESS,provider.deleteContainerById(9));

        //    Класс Driver

        assertEquals(Result.SUCCESS,provider.deleteDriverById(9));

        //    Класс OpenTransport

        assertEquals(Result.SUCCESS,provider.deleteOpenTransportById(9));

        //    Класс Platform

        assertEquals(Result.SUCCESS,provider.deletePlatformById(9));

        //    Класс Refrigerator

        assertEquals(Result.SUCCESS,provider.deleteRefrigeratorById(9));

        //    Класс Tent

        assertEquals(Result.SUCCESS,provider.deleteTentById(9));

        //    Класс Traffic

        assertEquals(Result.SUCCESS,provider.deleteTrafficById(9));

        //    Класс Transport

        assertEquals(Result.SUCCESS,provider.deleteTransportById(9));

    }

    @Test
    public void updateRecordTest(){

        // Класс Bort

        Bort bort = new Bort(9,"test",10000,"test",1000,100,100);
        assertEquals(Result.SUCCESS,provider.updateBort(bort));

        // Класс Cargo

        Cargo cargo = new Cargo(9,"test",100,CargoType.GENERAL);
        assertEquals(Result.SUCCESS,provider.updateCargo(cargo));

        //Класс ClosedTransport

        ClosedTransport closedTransport = new ClosedTransport(9,"test",10000,"test",100,100);
        assertEquals(Result.SUCCESS,provider.updateClosedTransport(closedTransport));

        //Класс Container

        Container container = new Container(9,"test",10000,"test",100,100,ContainerType._20f);
        assertEquals(Result.SUCCESS,provider.updateContainer(container));

        //Класс Driver

        Driver driver = new Driver(9,"test","test",DrivingLicenseGrade.C);
        assertEquals(Result.SUCCESS,provider.updateDriver(driver));

        //Класс OpenTransport

        OpenTransport openTransport = new OpenTransport(9,"test",10000,"test",100,100);
        assertEquals(Result.SUCCESS,provider.updateOpenTransport(openTransport));

//Класс Platform

        Platform platform = new Platform(9,"test",10000,"test",100,100,100);
        assertEquals(Result.SUCCESS,provider.updatePlatform(platform));

        //Класс Refrigerator

        Refrigerator refrigerator = new Refrigerator(9,"test",10000,"test",100,100,-20,RefrigeratorClass.A);
        assertEquals(Result.SUCCESS,provider.updateRefrigerator(refrigerator));

        //Класс Tent

        Tent tent = new Tent(9,"test",10000,"test",100,100,TentType.Soft);
        assertEquals(Result.SUCCESS,provider.updateTent(tent));

        //Класс Traffic

        Traffic traffic = new Traffic(9,1,1,1,100);
        assertEquals(Result.SUCCESS,provider.updateTraffic(traffic));

        //Класс Transport

        Transport transport = new Transport(9,"test", 10000,"test",100);
        assertEquals(Result.SUCCESS,provider.updateTransport(transport));
    }

    @Test
    public void changeTrafficTest(){
        String params = "9,0,0,0,100";
        assertEquals(Result.SUCCESS,changeTraffic(params,provider));
    }

    @Test
    public void checkTrafficTest(){
        String trafficId = "0";
        assertEquals(Result.SUCCESS,checkTraffic(trafficId,provider));
    }

    @Test
    public void sendTrafficTest() throws IOException {
        String params;
        if (getConfigurationEntry(UPD_BEFORE_SENDOFF).toUpperCase().equals("TRUE")){
            params = "9,9,9,9,100";
        } else {params = "9";}
        assertEquals(Result.SUCCESS,sendTraffic(params,provider));
    }

}
