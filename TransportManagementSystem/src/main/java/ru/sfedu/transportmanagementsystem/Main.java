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

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static ru.sfedu.transportmanagementsystem.Constants.*;
import static ru.sfedu.transportmanagementsystem.utils.ConfigUtil.getConfigurationEntry;

/**
 *
 * @author HOME
 */

public class Main {
  private static Logger log = LogManager.getLogger(Main.class);
  public static IDataProvider provider;

  Main() {
        log.debug("TransportManagementSystemClient: starting application.........");
    }

    public static void main(String[] args) {
     try {
      Scanner scanner = new Scanner(System.in);
        log.info(String.format("Введите тип провайдера для приложения ('CSV' для CSV, 'DB' для JDBC, 'XML' для XML), %n" +
                " какое действие нужно совершить (полный список действий указан в README.txt) %n  вместе с параметрами: "));
        String[] input = scanner.nextLine().toUpperCase().split(INPUT_SPLIT,3);
        IDataProvider provider = newDataSource(input[0]);
       chooseAction(InputKeys.valueOf(input[1].toUpperCase()),input[2],provider);
    }
     catch (Exception exception){
       log.error(INPUT_ERROR);
       log.error(exception);
     }
    }


  private static Result chooseAction(InputKeys key,String values, IDataProvider provider) throws IOException {
    switch (key) {
      case CHECK_TRAFFIC:
        return checkTraffic(values,provider);
      case CHANGE_TRAFFIC:
        return changeTraffic(values,provider);
      case SEND_TRAFFIC:
        return sendTraffic(values,provider);

      case ADD_BORT:
        return addRecord("BORT",values,provider);
      case ADD_CARGO:
        log.debug("test");
        return addRecord("CARGO",values,provider);
      case ADD_CLOSEDTRANSPORT:
        return addRecord("CLOSEDTRANSPORT",values,provider);
      case ADD_CONTAINER:
        return addRecord("CONTAINER",values,provider);
      case ADD_DRIVER:
        return addRecord("DRIVER",values,provider);
      case ADD_OPENTRANSPORT:
        return addRecord("OPENTRANSPORT",values,provider);
      case ADD_PLATFORM:
        return addRecord("PLATFORM",values,provider);
      case ADD_REFRIGERATOR:
        return addRecord("REFRIGERATOR",values,provider);
      case ADD_TENT:
        return addRecord("TENT",values,provider);
      case ADD_TRAFFIC:
        return addRecord("TRAFFIC",values,provider);
      case ADD_TRANSPORT:
        return addRecord("TRANSPORT",values,provider);

      case GET_BORT:
        return getRecordById("BORT",values,provider);
      case GET_CARGO:
        return getRecordById("CARGO",values,provider);
      case GET_CLOSEDTRANSPORT:
        return getRecordById("CLOSEDTRANSPORT",values,provider);
      case GET_CONTAINER:
        return getRecordById("CONTAINER",values,provider);
      case GET_DRIVER:
        return getRecordById("DRIVER",values,provider);
      case GET_OPENTRANSPORT:
        return getRecordById("OPENTRANSPORT",values,provider);
      case GET_PLATFORM:
        return getRecordById("PLATFORM",values,provider);
      case GET_REFRIGERATOR:
        return getRecordById("REFRIGERATOR",values,provider);
      case GET_TENT:
        return getRecordById("TENT",values,provider);
      case GET_TRAFFIC:
        return getRecordById("TRAFFIC",values,provider);
      case GET_TRANSPORT:
        return getRecordById("TRANSPORT",values,provider);

      case UPD_BORT:
        return updRecord("BORT",values,provider);
      case UPD_CARGO:
        return updRecord("CARGO",values,provider);
      case UPD_CLOSEDTRANSPORT:
        return updRecord("CLOSEDTRANSPORT",values,provider);
      case UPD_CONTAINER:
        return updRecord("CONTAINER",values,provider);
      case UPD_DRIVER:
        return updRecord("DRIVER",values,provider);
      case UPD_OPENTRANSPORT:
        return updRecord("OPENTRANSPORT",values,provider);
      case UPD_PLATFORM:
        return updRecord("PLATFORM",values,provider);
      case UPD_REFRIGERATOR:
        return updRecord("REFRIGERATOR",values,provider);
      case UPD_TENT:
        return updRecord("TENT",values,provider);
      case UPD_TRAFFIC:
        return updRecord("TRAFFIC",values,provider);
      case UPD_TRANSPORT:
        return updRecord("TRANSPORT",values,provider);

      case DEL_BORT:
        return deleteRecordById("BORT",values,provider);
      case DEL_CARGO:
        return deleteRecordById("CARGO",values,provider);
      case DEL_CLOSEDTRANSPORT:
        return deleteRecordById("CLOSEDTRANSPORT",values,provider);
      case DEL_CONTAINER:
        return deleteRecordById("CONTAINER",values,provider);
      case DEL_DRIVER:
        return deleteRecordById("DRIVER",values,provider);
      case DEL_OPENTRANSPORT:
        return deleteRecordById("OPENTRANSPORT",values,provider);
      case DEL_PLATFORM:
        return deleteRecordById("PLATFORM",values,provider);
      case DEL_REFRIGERATOR:
        return deleteRecordById("REFRIGERATOR",values,provider);
      case DEL_TENT:
        return deleteRecordById("TENT",values,provider);
      case DEL_TRAFFIC:
        return deleteRecordById("TRAFFIC",values,provider);
      case DEL_TRANSPORT:
        return deleteRecordById("TRANSPORT",values,provider);

      default:
        log.error(INPUT_ERROR);
    }
    return Result.UNSUCCESSFUL;
  }




  private static IDataProvider newDataSource(String provider){
        switch (InputKeys.valueOf(provider.toUpperCase())) {
          case CSV:
            return new CsvDataProvider();
          case DB:
            return new JdbcDataProvider();
          case XML:
            return new XmlDataProvider();
          default:
            log.error(INPUT_ERROR);
        }
    return null;
  }


public static Result checkTraffic(String trafficId,IDataProvider provider){
     String[] values = parse(trafficId,1);
  assert values != null;
  int id = Integer.parseInt(values[0]);
    Traffic traffic = provider.getTrafficById(id).get();
    log.info(traffic);
  if (provider.getTrafficById(id).isEmpty()) {
    return Result.UNSUCCESSFUL;
  } else {
    if (provider.getCargoById(traffic.cargoId).isPresent()){
      log.info(provider.getCargoById(traffic.cargoId).get());
    }
    else {return Result.UNSUCCESSFUL;}
    if (provider.getTransportById(traffic.transportId).isPresent()){
    log.info(provider.getTransportById(traffic.transportId).get());}
    else {return Result.UNSUCCESSFUL;}
    if (provider.getDriverById(traffic.driverId).isPresent()){
    log.info(provider.getDriverById(traffic.driverId).get());}
    else {return Result.UNSUCCESSFUL;}
    return Result.SUCCESS;
  }
};

  public static Result sendTraffic(String params,IDataProvider provider) throws IOException {
    int updCount = 1;
    switch(getConfigurationEntry(UPD_BEFORE_SENDOFF).toUpperCase()){
      case "TRUE": updCount = 5;
      break;
      case "FALSE": break;
      default: log.error(UPD_BEFORE_SENDOFF_ERROR);
      return Result.UNSUCCESSFUL;
    }
    log.debug(updCount);
    String[] values = parse(params,updCount);
    assert values != null;
    int id = Integer.parseInt(values[0]);
    Traffic traffic = provider.getTrafficById(id).get();
    if (provider.getTrafficById(id).isEmpty()) {
      return Result.UNSUCCESSFUL;
    } else {
      if (provider.getCargoById(traffic.cargoId).isPresent()){
        log.info(provider.getCargoById(traffic.cargoId).get());
      }
      else {return Result.UNSUCCESSFUL;}
      if (provider.getTransportById(traffic.transportId).isPresent()){
        log.info(provider.getTransportById(traffic.transportId).get());
      }
      else {return Result.UNSUCCESSFUL;}
      if (provider.getDriverById(traffic.driverId).isPresent()){
        log.info(provider.getDriverById(traffic.driverId).get());
      }
      else {return Result.UNSUCCESSFUL;}
      if (getConfigurationEntry(UPD_BEFORE_SENDOFF).toUpperCase().equals("TRUE") &&  (updCount == 5) ){
         traffic.setCargoId(Integer.parseInt(values[1]));
         traffic.setTransportId(Integer.parseInt(values[2]));
         traffic.setDriverId(Integer.parseInt(values[3]));
         traffic.setDistance(Integer.parseInt(values[4]));
      }
      log.info(traffic);
      Transport transport = provider.getTransportById(traffic.transportId).get();
      transport.setTotalDistance(transport.getTotalDistance() + traffic.getDistance());
      provider.updateTransport(transport);
      log.info("Отправка произведена успешно.");
      return Result.SUCCESS;
    }
  };



public static Result changeTraffic(String params, IDataProvider provider){
  String[] values = parse(params,5);
  assert values != null;
  int id = Integer.parseInt(values[0]);
  int cargoId = Integer.parseInt(values[1]);
  int transportId = Integer.parseInt(values[2]);
  int driverId = Integer.parseInt(values[3]);
  int distance = Integer.parseInt(values[4]);
Traffic traffic = new Traffic(id,cargoId,transportId,driverId,distance);
return provider.updateTraffic(traffic);
};




  private static Result addRecord (String type, String values, IDataProvider provider){
    switch (EntityKeys.valueOf(type.toUpperCase())) {
      case BORT:
        String[] bortValues = parse(values,7);
        assert bortValues != null;
        Bort bort = new Bort(Integer.parseInt(bortValues[0]),bortValues[1],Integer.parseInt(bortValues[2]),bortValues[3],Integer.parseInt(bortValues[4]),
                Integer.parseInt(bortValues[5]),Integer.parseInt(bortValues[6]));
        return provider.createBort(bort);
      case CARGO:
        String[] cargoValues = parse(values,4);
        assert cargoValues != null;
        Cargo cargo = new Cargo(Integer.parseInt(cargoValues[0]),cargoValues[1],Integer.parseInt(cargoValues[2]),CargoType.valueOf(cargoValues[3].toUpperCase()));
        return provider.createCargo(cargo);
      case CLOSEDTRANSPORT:
        String[] ctValues = parse(values,6);
        assert ctValues != null;
        ClosedTransport closedTransport = new ClosedTransport(Integer.parseInt(ctValues[0]),ctValues[1],Integer.parseInt(ctValues[2]),ctValues[3],Integer.parseInt(ctValues[4]),
                Integer.parseInt(ctValues[5]));
        return provider.createClosedTransport(closedTransport);
      case CONTAINER:
        String[] contValues = parse(values,7);
        assert contValues != null;
        Container container = new Container(Integer.parseInt(contValues[0]),contValues[1],Integer.parseInt(contValues[2]),contValues[3],Integer.parseInt(contValues[4]),
                Integer.parseInt(contValues[5]),ContainerType.valueOf(contValues[6]));
        return provider.createContainer(container);
      case DRIVER:
        String[] driverValues = parse(values,4);
        assert driverValues != null;
        Driver driver = new Driver(Integer.parseInt(driverValues[0]),driverValues[1],driverValues[2],DrivingLicenseGrade.valueOf(driverValues[3]));
        return provider.createDriver(driver);
      case OPENTRANSPORT:
        String[] otValues = parse(values,6);
        assert otValues != null;
        OpenTransport openTransport = new OpenTransport(Integer.parseInt(otValues[0]),otValues[1],Integer.parseInt(otValues[2]),otValues[3],Integer.parseInt(otValues[4]),
                Integer.parseInt(otValues[5]));
        return provider.createOpenTransport(openTransport);
      case PLATFORM:
        String[] platValues = parse(values,7);
        assert platValues != null;
        Platform platform = new Platform(Integer.parseInt(platValues[0]),platValues[1],Integer.parseInt(platValues[2]),platValues[3],Integer.parseInt(platValues[4]),
                Integer.parseInt(platValues[5]),Integer.parseInt(platValues[6]));
        return provider.createPlatform(platform);
      case REFRIGERATOR:
        String[] fridgeValues = parse(values,8);
        assert fridgeValues != null;
        Refrigerator refrigerator = new Refrigerator(Integer.parseInt(fridgeValues[0]),fridgeValues[1],Integer.parseInt(fridgeValues[2]),fridgeValues[3],Integer.parseInt(fridgeValues[4]),
                Integer.parseInt(fridgeValues[5]),Integer.parseInt(fridgeValues[6]),RefrigeratorClass.valueOf(fridgeValues[7]));
        return provider.createRefrigerator(refrigerator);
      case TENT:
        String[] tentValues = parse(values,7);
        assert tentValues != null;
        Tent tent = new Tent(Integer.parseInt(tentValues[0]),tentValues[1],Integer.parseInt(tentValues[2]),tentValues[3],Integer.parseInt(tentValues[4]),
                Integer.parseInt(tentValues[5]),TentType.valueOf(tentValues[6]));
        return provider.createTent(tent);
      case TRAFFIC:
        String[] trafficValues = parse(values,4);
        assert trafficValues != null;
        Traffic traffic = new Traffic(Integer.parseInt(trafficValues[0]),Integer.parseInt(trafficValues[1]),Integer.parseInt(trafficValues[2]),Integer.parseInt(trafficValues[3]),
                Integer.parseInt(trafficValues[4]));
        return provider.createTraffic(traffic);
      case TRANSPORT:
        String[] tValues = parse(values,5);
        assert tValues != null;
        Transport transport = new Transport(Integer.parseInt(tValues[0]),tValues[1],Integer.parseInt(tValues[2]),tValues[3],Integer.parseInt(tValues[4]));
        return provider.createTransport(transport);
      default: log.error(INPUT_ERROR);
    }
    return Result.UNSUCCESSFUL;
  }


  private static Result updRecord (String type, String values, IDataProvider provider){
    switch (EntityKeys.valueOf(type.toUpperCase())) {
      case BORT:
        String[] bortValues = parse(values,7);
        assert bortValues != null;
        Bort bort = new Bort(Integer.parseInt(bortValues[0]),bortValues[1],Integer.parseInt(bortValues[2]),bortValues[3],Integer.parseInt(bortValues[4]),
                Integer.parseInt(bortValues[5]),Integer.parseInt(bortValues[6]));
        return provider.updateBort(bort);
      case CARGO:
        String[] cargoValues = parse(values,4);
        assert cargoValues != null;
        Cargo cargo = new Cargo(Integer.parseInt(cargoValues[0]),cargoValues[1],Integer.parseInt(cargoValues[2]),CargoType.valueOf(cargoValues[3].toUpperCase()));
        return provider.updateCargo(cargo);
      case CLOSEDTRANSPORT:
        String[] ctValues = parse(values,6);
        assert ctValues != null;
        ClosedTransport closedTransport = new ClosedTransport(Integer.parseInt(ctValues[0]),ctValues[1],Integer.parseInt(ctValues[2]),ctValues[3],Integer.parseInt(ctValues[4]),
                Integer.parseInt(ctValues[5]));
        return provider.updateClosedTransport(closedTransport);
      case CONTAINER:
        String[] contValues = parse(values,7);
        assert contValues != null;
        Container container = new Container(Integer.parseInt(contValues[0]),contValues[1],Integer.parseInt(contValues[2]),contValues[3],Integer.parseInt(contValues[4]),
                Integer.parseInt(contValues[5]),ContainerType.valueOf(contValues[6]));
        return provider.updateContainer(container);
      case DRIVER:
        String[] driverValues = parse(values,4);
        assert driverValues != null;
        Driver driver = new Driver(Integer.parseInt(driverValues[0]),driverValues[1],driverValues[2],DrivingLicenseGrade.valueOf(driverValues[3]));
        return provider.updateDriver(driver);
      case OPENTRANSPORT:
        String[] otValues = parse(values,6);
        assert otValues != null;
        OpenTransport openTransport = new OpenTransport(Integer.parseInt(otValues[0]),otValues[1],Integer.parseInt(otValues[2]),otValues[3],Integer.parseInt(otValues[4]),
                Integer.parseInt(otValues[5]));
        return provider.updateOpenTransport(openTransport);
      case PLATFORM:
        String[] platValues = parse(values,7);
        assert platValues != null;
        Platform platform = new Platform(Integer.parseInt(platValues[0]),platValues[1],Integer.parseInt(platValues[2]),platValues[3],Integer.parseInt(platValues[4]),
                Integer.parseInt(platValues[5]),Integer.parseInt(platValues[6]));
        return provider.updatePlatform(platform);
      case REFRIGERATOR:
        String[] fridgeValues = parse(values,8);
        assert fridgeValues != null;
        Refrigerator refrigerator = new Refrigerator(Integer.parseInt(fridgeValues[0]),fridgeValues[1],Integer.parseInt(fridgeValues[2]),fridgeValues[3],Integer.parseInt(fridgeValues[4]),
                Integer.parseInt(fridgeValues[5]),Integer.parseInt(fridgeValues[6]),RefrigeratorClass.valueOf(fridgeValues[7]));
        return provider.updateRefrigerator(refrigerator);
      case TENT:
        String[] tentValues = parse(values,7);
        assert tentValues != null;
        Tent tent = new Tent(Integer.parseInt(tentValues[0]),tentValues[1],Integer.parseInt(tentValues[2]),tentValues[3],Integer.parseInt(tentValues[4]),
                Integer.parseInt(tentValues[5]),TentType.valueOf(tentValues[6]));
        return provider.updateTent(tent);
      case TRAFFIC:
        String[] trafficValues = parse(values,5);
        assert trafficValues != null;
        Traffic traffic = new Traffic(Integer.parseInt(trafficValues[0]),Integer.parseInt(trafficValues[1]),Integer.parseInt(trafficValues[2]),Integer.parseInt(trafficValues[3]),
                Integer.parseInt(trafficValues[4]));
        return provider.updateTraffic(traffic);
      case TRANSPORT:
        String[] tValues = parse(values,5);
        assert tValues != null;
        Transport transport = new Transport(Integer.parseInt(tValues[0]),tValues[1],Integer.parseInt(tValues[2]),tValues[3],Integer.parseInt(tValues[4]));
        return provider.updateTransport(transport);
      default: log.error(INPUT_ERROR);
    }
    return Result.UNSUCCESSFUL;
  }



  private static Result deleteRecordById (String type, String recordId, IDataProvider provider){
    String[] values = parse(recordId,1);
    assert values != null;
    int id = Integer.parseInt(values[0]);
    switch (EntityKeys.valueOf(type.toUpperCase())) {
      case BORT:  return provider.deleteBortById(id);
      case CARGO: return provider.deleteCargoById(id);
      case CLOSEDTRANSPORT:return provider.deleteClosedTransportById(id);
      case CONTAINER: return provider.deleteContainerById(id);
      case DRIVER: return provider.deleteDriverById(id);
      case OPENTRANSPORT: return provider.deleteOpenTransportById(id);
      case PLATFORM: return provider.deletePlatformById(id);
      case REFRIGERATOR: return provider.deleteRefrigeratorById(id);
      case TENT: return provider.deleteTentById(id);
      case TRAFFIC: return provider.deleteTrafficById(id);
      case TRANSPORT: return provider.deleteTransportById(id);
      default: log.error(INPUT_ERROR);
    }
    return Result.UNSUCCESSFUL;
  }

  private static Result getRecordById (String type, String recordId, IDataProvider provider){
    String[] values = parse(recordId,1);
    assert values != null;
    int id = Integer.parseInt(values[0]);
    Object record;
      switch (EntityKeys.valueOf(type.toUpperCase())) {
        case BORT:
          if (provider.getBortById(id).isPresent()){
            log.info(provider.getBortById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case CARGO:
          if (provider.getCargoById(id).isPresent()){
            log.info(provider.getCargoById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case CLOSEDTRANSPORT:
          if (provider.getClosedTransportById(id).isPresent()){
            log.info(provider.getClosedTransportById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case CONTAINER:
          if (provider.getContainerById(id).isPresent()){
            log.info(provider.getContainerById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case DRIVER:
          if (provider.getDriverById(id).isPresent()){
            log.info(provider.getDriverById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case OPENTRANSPORT:
          if (provider.getOpenTransportById(id).isPresent()){
            log.info(provider.getOpenTransportById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case PLATFORM:
          if (provider.getPlatformById(id).isPresent()){
            log.info(provider.getPlatformById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case REFRIGERATOR:
          if (provider.getRefrigeratorById(id).isPresent()){
            log.info(provider.getRefrigeratorById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case TENT:
          if (provider.getTentById(id).isPresent()){
            log.info(provider.getTentById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case TRAFFIC:
          if (provider.getTrafficById(id).isPresent()){
            log.info(provider.getTrafficById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
        case TRANSPORT:
          if (provider.getTransportById(id).isPresent()){
            log.info(provider.getTransportById(id).get());
            return Result.SUCCESS;
          }
          else {return Result.UNSUCCESSFUL;}
      }
      return Result.UNSUCCESSFUL;
  }



  private static String[] parse(String values, int count) {

    String[] value = values.split(INPUT_SPLIT);
    if (value.length != count) {
      log.error(PARSE_ERROR);
      log.error(value.length);
      log.error(values);
      log.error(Arrays.toString(value));
      return null;
    }
    return value;
  }
}
