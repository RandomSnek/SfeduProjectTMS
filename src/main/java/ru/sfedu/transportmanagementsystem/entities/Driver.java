package ru.sfedu.transportmanagementsystem.entities;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import ru.sfedu.transportmanagementsystem.entities.DrivingLicenseGrade;
/**
 * Class Driver
 */
@Root (name = "Driver")
public class Driver {
  @Attribute
  @CsvBindByPosition(position = 1)
  public String fio;
  @Element
  @CsvBindByPosition(position = 3)
  public DrivingLicenseGrade drivingGrade;
  @Attribute
  @CsvBindByPosition(position = 2)
  public String passport;
  @Attribute
  @CsvBindByPosition(position = 0)
  public int id;

  public Driver () { };
  public Driver (int id, String fio,String passport, DrivingLicenseGrade drivingGrade){
    setFio(fio);
    setDrivingLicenseGrade(drivingGrade);
    setPassport(passport);
    setId(id);
  }

  public void setFio(String fio) {
    this.fio = fio;
  }
  public String getFio() {
    return fio;
  }

  public void setDrivingLicenseGrade (DrivingLicenseGrade drivingGrade) {
     this.drivingGrade = drivingGrade;
  }
  public DrivingLicenseGrade getDrivingLicenseGrade () {
    return drivingGrade;
  }

  public void setPassport (String passport) {
    this.passport = passport;
  }
  public String getPassport () {
    return passport;
  }

  public void setId (int id) {
    this.id = id;
  }
  public int getId () {
    return id;
  }

  @Override
  public String toString() {
    return "Driver{" +
            "id=" + id +
            ", fio='" + fio + ", drivingGrade=" + drivingGrade + ", passport=" +passport + '\'' +
            '}';
  }
}
