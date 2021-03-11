package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Class Cargo
 */
@Root (name = "Cargo")
public class Cargo {
  @Attribute
  @CsvBindByPosition(position = 2)
  public int weight;
  @Element
  @CsvBindByPosition(position = 3)
  public CargoType type;
  @Attribute
  @CsvBindByPosition(position = 1)
  public String name;
  @Attribute
  @CsvBindByPosition(position = 0)
  public int id;

  public Cargo () { };
  public Cargo (int id, String name, int weight, CargoType type) {
    setWeight(weight);
    setCargoType(type);
    setName(name);
    setId(id);
  };

  public void setWeight (int weight) {
    this.weight = weight;
  }
  public int getWeight () {
    return weight;
  }

  public void setCargoType(CargoType type) {
    this.type = type;
  }
  public CargoType getCargoType () {
    return type;
  }

  public void setName (String name) {
    this.name = name;
  }
  public String getName () {
    return name;
  }

  public void setId (int id){this.id = id;}
  public int getId (){return id;}

  @Override
  public String toString() {
    return "Cargo{" +
            "id=" + id +
            ", name='" + name + ", weight=" + weight + ", type=" +type + '\'' +
            '}';
  }









}
