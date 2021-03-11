package ru.sfedu.transportmanagementsystem.entities;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
/**
 * Class OpenTransport
 */
@Root (name = "OpenTransport")
public class OpenTransport extends Transport {
  @Attribute
  @CsvBindByPosition(position = 5)
  public int kuzovLength;

  public OpenTransport () { };
  public OpenTransport (int id, String name, int maxWeight, String plates, int totalDistance, int kuzovLength) {
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovLength(kuzovLength);
  };
  

  public void setKuzovLength (int kuzovLength) {
    this.kuzovLength = kuzovLength;
  }
  public int getKuzovLength () {
    return kuzovLength;
  }

  @Override
  public String toString() {
    return "Open Transport{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance +", kuzovLength=" +kuzovLength + '\'' +
            '}';
  }

}
