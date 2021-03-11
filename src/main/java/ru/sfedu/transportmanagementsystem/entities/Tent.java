package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ru.sfedu.transportmanagementsystem.entities.TentType;
/**
 * Class Tent
 */
@Root (name = "Tent")
public class Tent extends ClosedTransport {
  @CsvBindByPosition(position = 6)
  @Element
  public TentType tentType;

  public Tent () { };
  public Tent(int id, String name, int maxWeight, String plates, int totalDistance, int kuzovVolume, TentType tentType){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovVolume(kuzovVolume);
    setTentType(tentType);
  }


  public void setTentType(TentType tentType) {
    this.tentType = tentType;
  }
  public TentType getTentType() {
    return tentType;
  }

  @Override
  public String toString() {
    return "Tent{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance +", kuzovVolume="+ kuzovVolume + ", TentType=" +tentType + '\'' +
            '}';
  }

}
