package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ru.sfedu.transportmanagementsystem.entities.RefrigeratorClass;
/**
 * Class Refrigerator
 */
@Root (name = "Refrigerator")
public class Refrigerator extends ClosedTransport {
  @Attribute
  @CsvBindByPosition(position = 7)
  public int temperature;
  @CsvBindByPosition(position = 6)
  @Element
  public RefrigeratorClass fridgeClass;

  public Refrigerator () { }
  public Refrigerator(int id, String name, int maxWeight, String plates, int totalDistance, int kuzovVolume , int temperature , RefrigeratorClass fridgeClass){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovVolume(kuzovVolume);
    setFridgeClass(fridgeClass);
    setTemperature(temperature);
  }

  public void setTemperature (int temperature) {
    this.temperature = temperature;
  }
  public int getTemperature () {
    return temperature;
  }


  public void setFridgeClass (RefrigeratorClass fridgeClass) {
    this.fridgeClass = fridgeClass;
  }
  public RefrigeratorClass getFridgeClass () {
    return fridgeClass;
  }

  @Override
  public String toString() {
    return "Транспорт типа рефрижератор: " +
            "ID=" + id +
            ", Наименование='" + name + ", Макс. вес=" + maxWeight + ", Номер=" +plates + ", Пробег=" + totalDistance +", Объём кузова=" +kuzovVolume + ", Температура=" + temperature +", Класс холодильника=" + fridgeClass + '\'';
  }
}
