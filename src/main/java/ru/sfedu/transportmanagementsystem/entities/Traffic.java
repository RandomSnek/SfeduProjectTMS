package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import java.util.Optional;

/**
 * Class Traffic
 */
@Root (name = "Traffic")
public class Traffic  {
  @Attribute
  @CsvBindByPosition(position = 0)
  public int id;
  @Attribute
  @CsvBindByPosition(position = 1)
  public int cargoId;
  @Attribute
  @CsvBindByPosition(position = 2)
  public int transportId;
  @Attribute
  @CsvBindByPosition(position = 3)
  public int driverId;
  @Attribute
  @CsvBindByPosition(position = 4)
  public int distance;
  @Element
  public Optional<Transport> trafficTransport;
  @Element
  public Optional<Driver> trafficDriver;
  @Element
  public Optional<Cargo> trafficCargo;

  public Traffic () {};
  public Traffic (int id ,int cargoId, int transportId, int driverId, int distance){
    setId(id);
    setCargoId(cargoId);
    setTransportId(transportId);
    setDriverId(driverId);
    setDistance(distance);
  }
  public Traffic (int id, int cargoId, int transportId, int driverId, int distance, Transport trafficTransport, Driver trafficDriver, Cargo trafficCargo){
    setId(id);
    setCargoId(cargoId);
    setTransportId(transportId);
    setDriverId(driverId);
    setDistance(distance);
    setTrafficTransport(Optional.ofNullable(trafficTransport));
    setTrafficDriver(Optional.ofNullable(trafficDriver));
    setTrafficCargo(Optional.ofNullable(trafficCargo));
  }

  public void setId(int id){this.id = id;}
  public int getId(){return id;}

  public void setCargoId (int cargoId) {this.cargoId = cargoId; }
  public int getCargoId () {
    return cargoId;
  }

  public void setTransportId (int transportId) {
    this.transportId = transportId;
  }
  public int getTransportId () {
    return transportId;
  }

  public void setDriverId (int driverId) {
    this.driverId = driverId;
  }
  public int getDriverId () {
    return driverId;
  }

  public void setDistance (int distance) {this.distance = distance; }
  public int getDistance () {
    return distance;
  }

  public void setTrafficTransport (Optional<Transport> trafficTransport) {
    this.trafficTransport = trafficTransport;
  }
  public Optional<Transport> getTrafficTransport () {
    return trafficTransport;
  }

  public void setTrafficDriver (Optional<Driver> trafficDriver) {
    this.trafficDriver = trafficDriver;
  }
  public Optional<Driver> getTrafficDriver () {
    return trafficDriver;
  }

  public void setTrafficCargo (Optional<Cargo> trafficCargo) {
    this.trafficCargo =  trafficCargo;
  }
  public Optional<Cargo> getTrafficCargo () {
    return trafficCargo;
  }

  @Override
  public String toString() {
    return "Traffic{" +
            "id=" + id +
            ", cargoId='" + cargoId + ", transportId=" + transportId + ", driverId=" +driverId + ", Distance" + distance + '\'' +
            '}';
  }

}
