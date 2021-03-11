/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.transportmanagementsystem.api.JdbcDataProvider;
import ru.sfedu.transportmanagementsystem.api.XmlDataProvider;
import ru.sfedu.transportmanagementsystem.api.CsvDataProvider;
import ru.sfedu.transportmanagementsystem.api.IDataProvider;
import ru.sfedu.transportmanagementsystem.entities.*;
/**
 *
 * @author HOME
 */

public class Main {
  private static Logger log = LogManager.getLogger(Main.class);
    Main() {
        log.debug("TransportManagementSystemClient[0]: starting application........."); 
    }
   protected static void logTransport() {
       IDataProvider provider = new CsvDataProvider();
       JdbcDataProvider providerJDBC = new JdbcDataProvider();
       Transport transport = new Transport( 1, "MAN540",10000,"АБГ3990",100);
       log.info("Launching the application...");
       log.info("Result of createTransport: " + provider.createTransport(transport));
       log.info("Result of getTransportById: " + provider.getTransportById(transport.getId()));
       log.info("Result of updateTransport: " + provider.updateTransport(transport));
       log.info("Result of deleteTransport: " +provider.deleteTransportById(transport.getId()) );
   }

    protected static void logBort() {
        IDataProvider provider = new CsvDataProvider();
        Bort bort = new Bort(1, "MAN540",10000,"АБГ3790",100, 20, 70);
        log.info("Bort debugging starts...");
        log.info("Result of createBort: " + provider.createBort(bort));
        log.info("Result of getBortById: " + provider.getBortById(bort.getId()));
        log.info("Result of updateBort: " + provider.updateBort(bort));
        log.info("Result of deleteBort: " + provider.deleteBortById(bort.getId()));
    }

    protected static void logClosedTransport() {
        IDataProvider provider = new CsvDataProvider();
        ClosedTransport closedTransport = new ClosedTransport(1, "MAN540",10000,"АБГ3790",100, 450);
        log.info("ClosedTransport debugging starts...");
        log.info("Result of createClosedTransport: " + provider.createClosedTransport(closedTransport));
        log.info("Result of getClosedTransportById: " + provider.getClosedTransportById(closedTransport.getId()));
        log.info("Result of updateClosedTransport: " + provider.updateClosedTransport(closedTransport));
        log.info("Result of deleteClosedTransport: " + provider.deleteClosedTransportById(closedTransport.getId()));
    }

    protected static void logOpenTransport() {
        IDataProvider provider = new CsvDataProvider();
        OpenTransport openTransport = new OpenTransport(1, "MAN540",10000,"АБГ4000",100, 88);
        log.info("OpenTransport debugging starts...");
        log.info("Result of createOpenTransport: " + provider.createOpenTransport(openTransport));
        log.info("Result of getOpenTransportById: " + provider.getOpenTransportById(openTransport.getId()));
       log.info("Result of updateOpenTransport: " + provider.updateOpenTransport(openTransport));
        log.info("Result of deleteOpenTransport: " + provider.deleteOpenTransportById(openTransport.getId()));
    }

    protected static void logContainer() {
        IDataProvider provider = new CsvDataProvider();
        Container container = new Container(1, "MAN540",10000,"АБГ4000",100, 900, ContainerType._40f);
        log.info("Container debugging starts...");
        log.info("Result of createContainer: " + provider.createContainer(container));
        log.info("Result of getContainerById: " + provider.getContainerById(container.getId()));
        log.info("Result of updateContainer: " + provider.updateContainer(container));
        log.info("Result of deleteContainer: " + provider.deleteContainerById(container.getId()));
    }

    protected static void logPlatform() {
        IDataProvider provider = new CsvDataProvider();
        Platform platform = new Platform(1, "MAN540",10000,"АБГ3790",100, 40, 60);
        log.info("Platform debugging starts...");
        log.info("Result of createPlatform: " + provider.createPlatform(platform));
        log.info("Result of getPlatformById: " + provider.getPlatformById(platform.getId()));
        log.info("Result of updatePlatform: " + provider.updatePlatform(platform));
        log.info("Result of deletePlatform: " + provider.deletePlatformById(platform.getId()));
    }

    protected static void logRefrigerator() {
        IDataProvider provider = new CsvDataProvider();
        Refrigerator refrigerator = new Refrigerator(1, "MAN540",10000,"АБГ3790",100, 60,-12, RefrigeratorClass.B);
        log.info("Refrigerator debugging starts...");
        log.info("Result of createRefrigerator: " + provider.createRefrigerator(refrigerator));
        log.info("Result of getRefrigeratorById: " + provider.getRefrigeratorById(refrigerator.getId()));
        log.info("Result of updateRefrigerator: " + provider.updateRefrigerator(refrigerator));
        log.info("Result of deleteRefrigerator: " + provider.deleteRefrigeratorById(refrigerator.getId()));
    }

    protected static void logTent() {
        IDataProvider provider = new CsvDataProvider();
        Tent tent = new Tent(1, "MAN540",10000,"АБГ3790",100, 60, TentType.Soft);
        log.info("Tent debugging starts...");
        log.info("Result of createTent: " + provider.createTent(tent));
        log.info("Result of getTentById: " + provider.getTentById(tent.getId()));
        log.info("Result of updateTent: " + provider.updateTent(tent));
        log.info("Result of deleteTent: " + provider.deleteTentById(tent.getId()));
    }

    protected static void logCargo() {
        IDataProvider provider = new XmlDataProvider();
        Cargo cargo = new Cargo(1,"Aluminium",500, CargoType.General);
        log.info("Cargo debugging starts...");
        log.info("Result of createCargo: " + provider.createCargo(cargo));
        log.info("Result of getCargoById: " + provider.getCargoById(cargo.getId()));
        log.info("Result of updateCargo: " + provider.updateCargo(cargo));
        log.info("Result of deleteCargo: " + provider.deleteCargoById(cargo.getId()));
    }

    protected static void logDriver() {
        IDataProvider provider = new CsvDataProvider();
        Driver driver = new Driver(1, "Ivan Ivanov Ivanovich", "6011 23456", DrivingLicenseGrade.C1);
        log.info("Driver debugging starts...");
        log.info("Result of createDriver: " + provider.createDriver(driver));
        log.info("Result of getDriverById: " + provider.getDriverById(driver.getId()));
        log.info("Result of updateDriver: " + provider.updateDriver(driver));
        log.info("Result of deleteDriver: " + provider.deleteDriverById(driver.getId()));
    }

    protected static void logTraffic() {
        IDataProvider provider = new CsvDataProvider();
        Traffic traffic = new Traffic(1,0,0,0,200);
        log.info("Traffic debugging starts...");
        log.info("Result of createTraffic: " + provider.createTraffic(traffic));
        log.info("Result of getTrafficById: " + provider.getTrafficById(traffic.getId()));
        log.info("Result of updateTraffic: " + provider.updateTraffic(traffic));
        log.info("Result of deleteTraffic: " + provider.deleteTrafficById(traffic.getId()));
    }

    public static void main(String[] args) {
//   logTransport();
//   logBort();
//   logClosedTransport();
//    logContainer();
//        logOpenTransport();
//        logPlatform();
//        logRefrigerator();
//        logTent();
//        logCargo();
//        logDriver();
//       logTraffic();

    }
}
