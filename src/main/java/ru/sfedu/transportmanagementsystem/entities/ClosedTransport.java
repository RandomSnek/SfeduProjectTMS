package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
/**
 * Class ClosedTransport
 */
@Root (name = "ClosedTransport")
public class ClosedTransport extends Transport {
  @Attribute
  @CsvBindByPosition(position = 5)
  public int kuzovVolume;

  public ClosedTransport() { };
  public ClosedTransport(int id, String name, int maxWeight, String plates, int totalDistance, int kuzovVolume){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovVolume(kuzovVolume);
  }


  public void setKuzovVolume (int kuzovVolume) { this.kuzovVolume = kuzovVolume; }
  public int getKuzovVolume () {
    return kuzovVolume;
  }

  @Override
  public String toString() {
    return "Closed Transport{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance +", kuzovVolume=" +kuzovVolume + '\'' +
            '}';
  }
}
