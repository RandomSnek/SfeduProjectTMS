package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ru.sfedu.transportmanagementsystem.entities.ContainerType;
/**
 * Class Container
 */
@Root (name = "Container")
public class Container extends ClosedTransport {
  @Element
  @CsvBindByPosition(position = 6)
  public ContainerType containerType;

  public Container(){
  }
  public Container(int id, String name, int maxWeight, String plates, int totalDistance, int kuzovVolume, ContainerType containerType){
    setId(id);
    setName(name);
    setMaxWeight(maxWeight);
    setPlates(plates);
    setTotalDistance(totalDistance);
    setKuzovVolume(kuzovVolume);
    setContainerType(containerType);
  }


  public void setContainerType (ContainerType containerType) {
    this.containerType = containerType;
  }
  public ContainerType getContainerType() {
    return containerType;
  }

  @Override
  public String toString() {
    return "Container{" +
            "id=" + id +
            ", name='" + name + ", maxWeight=" + maxWeight + ", plates=" +plates + ", totalDistance=" + totalDistance +", kuzovVolume="+ kuzovVolume + ", containerType=" +containerType + '\'' +
            '}';
  }

}
