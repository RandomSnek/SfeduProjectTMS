package ru.sfedu.transportmanagementsystem.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.transportmanagementsystem.entities.Result;
import ru.sfedu.transportmanagementsystem.entities.Bort;
import ru.sfedu.transportmanagementsystem.entities.Transport;
import ru.sfedu.transportmanagementsystem.entities.Cargo;
import ru.sfedu.transportmanagementsystem.entities.ClosedTransport;
import ru.sfedu.transportmanagementsystem.entities.OpenTransport;
import ru.sfedu.transportmanagementsystem.entities.Container;
import ru.sfedu.transportmanagementsystem.entities.Platform;
import ru.sfedu.transportmanagementsystem.entities.Refrigerator;
import ru.sfedu.transportmanagementsystem.entities.Tent;
import ru.sfedu.transportmanagementsystem.entities.Driver;
import ru.sfedu.transportmanagementsystem.entities.Traffic;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static ru.sfedu.transportmanagementsystem.Constants.*;
import static ru.sfedu.transportmanagementsystem.utils.ConfigUtil.getConfigurationEntry;

public class CsvDataProvider implements IDataProvider {
    private static final Logger log = LogManager.getLogger(CsvDataProvider.class);
    /*
    * CRUD Методы класса Transport
     */

    @Override
    public Result createTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(transport), TRANSPORT_CSV_KEY, true);
    }

    @Override
    public Result updateTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            List <Transport> allElements = readAll(Transport.class, TRANSPORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(transport.getId())));
            allElements.add(transport.getId(),transport);
            return update(allElements, TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTransportById(int id) {
        if (getTransportById(id).isPresent()) {
         List <Transport> allElements = readAll(Transport.class, TRANSPORT_CSV_KEY);
         allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Optional<Transport> getTransportById(int id) {
        return readAll(Transport.class, TRANSPORT_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    /*
     * Общие методы записи в файл и чтения файла update и readAll
     */

    private <T> Result update(List<T> bean, String filePath, Boolean append) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(getConfigurationEntry(filePath), append));
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).withApplyQuotesToAll(false).build();
            beanToCsv.write(bean);
            writer.close();
            return Result.SUCCESS;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.UNSUCCESSFUL;
    }

    public <T> List<T> readAll(Class<T> _class, String filePath) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(getConfigurationEntry(filePath)));
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .withType(_class).build();
            List<T> list = csvToBean.parse();
            return (List<T>) list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /*
     * CRUD Методы класса Bort
     */

    @Override
    public Result createBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(bort), BORT_CSV_KEY, true);
    }

    @Override
    public Optional<Bort> getBortById(int id) {
        return readAll(Bort.class, BORT_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            List <Bort> allElements = readAll(Bort.class, BORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(bort.getId())));
            allElements.add(bort.getId(),bort);
            return update(allElements, BORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteBortById(int id) {
        if (getBortById(id).isPresent()) {
            List <Bort> allElements = readAll(Bort.class, BORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, BORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса ClosedTransport
     */

    @Override
    public Result createClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(closedTransport), CLOSED_TRANSPORT_CSV_KEY, true);
    }

    @Override
    public Optional<ClosedTransport> getClosedTransportById(int id) {
        return readAll(ClosedTransport.class, CLOSED_TRANSPORT_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            List <ClosedTransport> allElements = readAll(ClosedTransport.class, CLOSED_TRANSPORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(closedTransport.getId())));
            allElements.add(closedTransport.getId(),closedTransport);
            return update(allElements, CLOSED_TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteClosedTransportById(int id) {
        if (getClosedTransportById(id).isPresent()) {
            List <ClosedTransport> allElements = readAll(ClosedTransport.class, CLOSED_TRANSPORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CLOSED_TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Container
     */

    @Override
    public Result createContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(container), CONTAINER_CSV_KEY, true);
    }

    @Override
    public Optional<Container> getContainerById(int id) {
        return readAll(Container.class, CONTAINER_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            List <Container> allElements = readAll(Container.class, CONTAINER_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(container.getId())));
            allElements.add(container.getId(),container);
            return update(allElements, CONTAINER_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteContainerById(int id) {
        if (getContainerById(id).isPresent()) {
            List <Container> allElements = readAll(Container.class, CONTAINER_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CONTAINER_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса OpenTransport
     */

    @Override
    public Result createOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(openTransport), OPEN_TRANSPORT_CSV_KEY, true);
    }

    @Override
    public Optional<OpenTransport> getOpenTransportById(int id) {
        return readAll(OpenTransport.class, OPEN_TRANSPORT_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            List <OpenTransport> allElements = readAll(OpenTransport.class, OPEN_TRANSPORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(openTransport.getId())));
            allElements.add(openTransport.getId(),openTransport);
            return update(allElements, OPEN_TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteOpenTransportById(int id) {
        if (getOpenTransportById(id).isPresent()) {
            List <OpenTransport> allElements = readAll(OpenTransport.class, OPEN_TRANSPORT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, OPEN_TRANSPORT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Platform
     */

    @Override
    public Result createPlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(platform), PLATFORM_CSV_KEY, true);
    }

    @Override
    public Optional<Platform> getPlatformById(int id) {
        return readAll(Platform.class, PLATFORM_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updatePlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            List <Platform> allElements = readAll(Platform.class, PLATFORM_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(platform.getId())));
            allElements.add(platform.getId(),platform);
            return update(allElements, PLATFORM_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deletePlatformById(int id) {
        if (getPlatformById(id).isPresent()) {
            List <Platform> allElements = readAll(Platform.class, PLATFORM_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, PLATFORM_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Refrigerator
     */

    @Override
    public Result createRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(refrigerator), REFRIGERATOR_CSV_KEY, true);
    }

    @Override
    public Optional<Refrigerator> getRefrigeratorById(int id) {
        return readAll(Refrigerator.class, REFRIGERATOR_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            List <Refrigerator> allElements = readAll(Refrigerator.class, REFRIGERATOR_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(refrigerator.getId())));
            allElements.add(refrigerator.getId(),refrigerator);
            return update(allElements, REFRIGERATOR_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteRefrigeratorById(int id) {
        if (getRefrigeratorById(id).isPresent()) {
            List <Refrigerator> allElements = readAll(Refrigerator.class, REFRIGERATOR_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, REFRIGERATOR_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Tent
     */

    @Override
    public Result createTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(tent), TENT_CSV_KEY, true);
    }

    @Override
    public Optional<Tent> getTentById(int id) {
        return readAll(Tent.class, TENT_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            List <Tent> allElements = readAll(Tent.class, TENT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(tent.getId())));
            allElements.add(tent.getId(),tent);
            return update(allElements, TENT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTentById(int id) {
        if (getTentById(id).isPresent()) {
            List <Tent> allElements = readAll(Tent.class, TENT_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TENT_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Cargo
     */

    @Override
    public Result createCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(cargo), CARGO_CSV_KEY, true);
    }

    @Override
    public Optional<Cargo> getCargoById(int id) {
        return readAll(Cargo.class, CARGO_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            List <Cargo> allElements = readAll(Cargo.class, CARGO_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(cargo.getId())));
            allElements.add(cargo.getId(),cargo);
            return update(allElements, CARGO_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteCargoById(int id) {
        if (getCargoById(id).isPresent()) {
            List <Cargo> allElements = readAll(Cargo.class, CARGO_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CARGO_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Driver
     */

    @Override
    public Result createDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(driver), DRIVER_CSV_KEY, true);
    }

    @Override
    public Optional<Driver> getDriverById(int id) {
        return readAll(Driver.class, DRIVER_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            List <Driver> allElements = readAll(Driver.class, DRIVER_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(driver.getId())));
            allElements.add(driver.getId(),driver);
            return update(allElements, DRIVER_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteDriverById(int id) {
        if (getDriverById(id).isPresent()) {
            List <Driver> allElements = readAll(Driver.class, DRIVER_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, DRIVER_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Traffic;
     */

    @Override
    public Result createTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(Collections.singletonList(traffic), TRAFFIC_CSV_KEY, true);
    }

    @Override
    public Optional<Traffic> getTrafficById(int id) {
        return readAll(Traffic.class, TRAFFIC_CSV_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            List <Traffic> allElements = readAll(Traffic.class, TRAFFIC_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(traffic.getId())));
            traffic.setTrafficCargo(getCargoById(traffic.cargoId));
            traffic.setTrafficTransport(getTransportById(traffic.transportId));
            traffic.setTrafficDriver(getDriverById(traffic.driverId));
            allElements.add(traffic.getId(),traffic);
            return update(allElements, TRAFFIC_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTrafficById(int id) {
        if (getTrafficById(id).isPresent()) {
            List <Traffic> allElements = readAll(Traffic.class, TRAFFIC_CSV_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TRAFFIC_CSV_KEY, false);
        }
        else return Result.UNSUCCESSFUL;
    }

}