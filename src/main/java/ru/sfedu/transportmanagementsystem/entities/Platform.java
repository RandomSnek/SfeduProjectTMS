package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
/**
 * Class Platform
 */
@Root (name = "Platform")
public class Platform extends OpenTransport {
  @Attribute
  @CsvBindByPosition(position = 6)
  public int loadingHeight;

  public Platform () { };
  public Platform(int id, String name, int maxWeight, String plates, int totalDistance, int kuzovLength, int loadingHeight){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovLength(kuzovLength);
    setLoadingHeight(loadingHeight);
  }

  public void setLoadingHeight (int loadingHeight) {
    this.loadingHeight = loadingHeight;
  }
  public int getLoadingHeight () {
    return loadingHeight;
  }

  @Override
  public String toString() {
    return "Platform{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance + ", kuzovLength=" + kuzovLength + ", loadingHeight=" +loadingHeight + '\'' +
            '}';
  }

}
