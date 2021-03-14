package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
/**
 * Class Transport
 */
@Root (name = "Transport")
public class Transport {
@Attribute
  @CsvBindByPosition(position = 0)
  public int id;
@Attribute
  @CsvBindByPosition(position = 1)
  public String name;
@Attribute
  @CsvBindByPosition(position = 2)
  public int maxWeight;
@Attribute
  @CsvBindByPosition(position = 3)
  public String plates;
@Attribute
  @CsvBindByPosition(position = 4)
  public int totalDistance;
  

  public Transport () { }

  public Transport(int id, String name, int maxWeight, String plates, int totalDistance){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
  }

  public void setMaxWeight (int maxWeight) {
    this.maxWeight = maxWeight;
  }
  public int getMaxWeight () {
    return maxWeight;
  }

  public void setPlates (String plates) {
    this.plates = plates;
  }
  public String getPlates () {
    return plates;
  }

  public void setName (String name) {
    this.name = name;
  }
  public String getName () {
    return name;
  }

  public void setId (int id) {
    this.id = id;
  }
  public int getId () {
    return id;
  }

  public void setTotalDistance (int totalDistance) {
    this.totalDistance = totalDistance;
  }
  public int getTotalDistance () {
    return totalDistance;
  }

  @Override
  public String toString() {
    return "Транспорт: " +
            "ID=" + id +
            ", Наименование='" + name + ", Макс. вес=" + maxWeight + ", Номер=" +plates + ", Пробег=" + totalDistance + '\'';
  }

}
