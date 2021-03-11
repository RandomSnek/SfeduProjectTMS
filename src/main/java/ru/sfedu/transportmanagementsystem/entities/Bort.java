package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
/**
 * Class Bort
 */
@Root (name = "Bort")
public class Bort extends OpenTransport {

  @CsvBindByPosition(position = 6)
  @Attribute
  public int bortLength;

  public Bort () { };
  public Bort (int id, String name, int maxWeight, String plates, int totalDistance, int kuzovLength, int bortLength){
    setBortLength(bortLength);
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovLength(kuzovLength);
  }


  public void setBortLength (int bortLength) {
    this.bortLength = bortLength;
  }
  public int getBortLength () { return bortLength;}

  @Override
  public String toString() {
    return "Transport{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance +", kuzovLength=" +kuzovLength +", bortLength=" +bortLength + '\'' +
            '}';
  }

}
