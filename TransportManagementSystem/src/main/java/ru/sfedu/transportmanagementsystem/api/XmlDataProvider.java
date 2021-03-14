package ru.sfedu.transportmanagementsystem.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ru.sfedu.transportmanagementsystem.entities.XmlContainer;
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

import static ru.sfedu.transportmanagementsystem.Constants.*;
import static ru.sfedu.transportmanagementsystem.utils.ConfigUtil.getConfigurationEntry;

public class XmlDataProvider implements IDataProvider {
    private static final Logger log = LogManager.getLogger(XmlDataProvider.class);

    /*
     * Общие методы записи в файл и чтения файла update и readAll
     */

    public <T> Result update(List<T> object, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(getConfigurationEntry(filePath), false);
            Serializer serializer;
            serializer = new Persister();
            XmlContainer<T> container = new XmlContainer(object);
            serializer.write(container, fileWriter);
            return Result.SUCCESS;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return Result.UNSUCCESSFUL;
        }
    }

    public <T> List<T> readAll(Class<T> _class, String filePath) {
        Reader fileReader;
        Serializer serializer;
        try {
            fileReader = new FileReader(getConfigurationEntry(filePath));
             serializer = new Persister();
            XmlContainer<T> container = serializer.read(XmlContainer.class, fileReader);
            return container.getCollection();
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return new ArrayList<>();
    }

    /*
     * CRUD Методы класса Transport
     */

    @Override
    public Result createTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Transport> list = readAll(Transport.class,TRANSPORT_XML_KEY);
            list.add(transport);
            return update(list, TRANSPORT_XML_KEY);
        }
    }

    @Override
    public Result updateTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            List<Transport> allElements = readAll(Transport.class, TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(transport.getId())));
            allElements.add(transport.getId(), transport);
            return update(allElements, TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTransportById(int id) {
        if (getTransportById(id).isPresent()) {
            List<Transport> allElements = readAll(Transport.class, TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Optional<Transport> getTransportById(int id) {
        return readAll(Transport.class, TRANSPORT_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }


    /*
     * CRUD Методы класса Bort
     */

    @Override
    public Result createBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Bort> list = readAll(Bort.class, BORT_XML_KEY);
            list.add(bort);
            return update(list, BORT_XML_KEY);
        }
    }

    @Override
    public Optional<Bort> getBortById(int id) {
        return readAll(Bort.class, BORT_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            List<Bort> allElements = readAll(Bort.class, BORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(bort.getId())));
            allElements.add(bort.getId(), bort);
            return update(allElements, BORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteBortById(int id) {
        if (getBortById(id).isPresent()) {
            List<Bort> allElements = readAll(Bort.class, BORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, BORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса ClosedTransport
     */

    @Override
    public Result createClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<ClosedTransport> list = readAll(ClosedTransport.class, CLOSED_TRANSPORT_XML_KEY);
            list.add(closedTransport);
            return update(list, CLOSED_TRANSPORT_XML_KEY);
        }
    }

    @Override
    public Optional<ClosedTransport> getClosedTransportById(int id) {
        return readAll(ClosedTransport.class, CLOSED_TRANSPORT_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            List<ClosedTransport> allElements = readAll(ClosedTransport.class, CLOSED_TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(closedTransport.getId())));
            allElements.add(closedTransport.getId(), closedTransport);
            return update(allElements, CLOSED_TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteClosedTransportById(int id) {
        if (getClosedTransportById(id).isPresent()) {
            List<ClosedTransport> allElements = readAll(ClosedTransport.class, CLOSED_TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CLOSED_TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Container
     */

    @Override
    public Result createContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Container> list = readAll(Container.class, CONTAINER_XML_KEY);
            list.add(container);
            return update(list, CONTAINER_XML_KEY);
        }
    }

    @Override
    public Optional<Container> getContainerById(int id) {
        return readAll(Container.class, CONTAINER_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            List<Container> allElements = readAll(Container.class, CONTAINER_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(container.getId())));
            allElements.add(container.getId(), container);
            return update(allElements, CONTAINER_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteContainerById(int id) {
        if (getContainerById(id).isPresent()) {
            List<Container> allElements = readAll(Container.class, CONTAINER_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CONTAINER_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса OpenTransport
     */

    @Override
    public Result createOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<OpenTransport> list = readAll(OpenTransport.class, OPEN_TRANSPORT_XML_KEY);
            list.add(openTransport);
            return update(list, OPEN_TRANSPORT_XML_KEY);
        }
    }

    @Override
    public Optional<OpenTransport> getOpenTransportById(int id) {
        return readAll(OpenTransport.class, OPEN_TRANSPORT_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            List<OpenTransport> allElements = readAll(OpenTransport.class, OPEN_TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(openTransport.getId())));
            allElements.add(openTransport.getId(), openTransport);
            return update(allElements, OPEN_TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteOpenTransportById(int id) {
        if (getOpenTransportById(id).isPresent()) {
            List<OpenTransport> allElements = readAll(OpenTransport.class, OPEN_TRANSPORT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, OPEN_TRANSPORT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Platform
     */

    @Override
    public Result createPlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Platform> list = readAll(Platform.class, PLATFORM_XML_KEY);
            list.add(platform);
            return update(list, PLATFORM_XML_KEY);
        }
    }

    @Override
    public Optional<Platform> getPlatformById(int id) {
        return readAll(Platform.class, PLATFORM_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updatePlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            List<Platform> allElements = readAll(Platform.class, PLATFORM_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(platform.getId())));
            allElements.add(platform.getId(), platform);
            return update(allElements, PLATFORM_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deletePlatformById(int id) {
        if (getPlatformById(id).isPresent()) {
            List<Platform> allElements = readAll(Platform.class, PLATFORM_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, PLATFORM_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Refrigerator
     */

    @Override
    public Result createRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Refrigerator> list = readAll(Refrigerator.class, REFRIGERATOR_XML_KEY);
            list.add(refrigerator);
            return update(list, REFRIGERATOR_XML_KEY);
        }
    }

    @Override
    public Optional<Refrigerator> getRefrigeratorById(int id) {
        return readAll(Refrigerator.class, REFRIGERATOR_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            List<Refrigerator> allElements = readAll(Refrigerator.class, REFRIGERATOR_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(refrigerator.getId())));
            allElements.add(refrigerator.getId(), refrigerator);
            return update(allElements, REFRIGERATOR_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteRefrigeratorById(int id) {
        if (getRefrigeratorById(id).isPresent()) {
            List<Refrigerator> allElements = readAll(Refrigerator.class, REFRIGERATOR_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, REFRIGERATOR_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Tent
     */

    @Override
    public Result createTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Tent> list = readAll(Tent.class, TENT_XML_KEY);
            list.add(tent);
            return update(list, TENT_XML_KEY);
        }
    }

    @Override
    public Optional<Tent> getTentById(int id) {
        return readAll(Tent.class, TENT_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            List<Tent> allElements = readAll(Tent.class, TENT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(tent.getId())));
            allElements.add(tent.getId(), tent);
            return update(allElements, TENT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTentById(int id) {
        if (getTentById(id).isPresent()) {
            List<Tent> allElements = readAll(Tent.class, TENT_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TENT_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Cargo
     */

    @Override
    public Result createCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Cargo> list = readAll(Cargo.class, CARGO_XML_KEY);
            list.add(cargo);
            return update(list, CARGO_XML_KEY);
        }
    }

    @Override
    public Optional<Cargo> getCargoById(int id) {
        return readAll(Cargo.class, CARGO_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            List<Cargo> allElements = readAll(Cargo.class, CARGO_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(cargo.getId())));
            allElements.add(cargo.getId(), cargo);
            return update(allElements, CARGO_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteCargoById(int id) {
        if (getCargoById(id).isPresent()) {
            List<Cargo> allElements = readAll(Cargo.class, CARGO_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, CARGO_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Driver
     */

    @Override
    public Result createDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Driver> list = readAll(Driver.class, DRIVER_XML_KEY);
            list.add(driver);
            return update(list, DRIVER_XML_KEY);
        }
    }

    @Override
    public Optional<Driver> getDriverById(int id) {
        return readAll(Driver.class, DRIVER_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            List<Driver> allElements = readAll(Driver.class, DRIVER_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(driver.getId())));
            allElements.add(driver.getId(), driver);
            return update(allElements, DRIVER_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteDriverById(int id) {
        if (getDriverById(id).isPresent()) {
            List<Driver> allElements = readAll(Driver.class, DRIVER_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, DRIVER_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    /*
     * CRUD Методы класса Traffic;
     */

    @Override
    public Result createTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else {
            List<Traffic> list = readAll(Traffic.class, TRAFFIC_XML_KEY);
            list.add(traffic);
            return update(list, TRAFFIC_XML_KEY);
        }
    }

    @Override
    public Optional<Traffic> getTrafficById(int id) {
        return readAll(Traffic.class, TRAFFIC_XML_KEY).stream().filter(o -> o.getId() == (id)).findFirst();
    }

    @Override
    public Result updateTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            List<Traffic> allElements = readAll(Traffic.class, TRAFFIC_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(traffic.getId())));
            allElements.add(traffic.getId(), traffic);
            return update(allElements, TRAFFIC_XML_KEY);
        } else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTrafficById(int id) {
        if (getTrafficById(id).isPresent()) {
            List<Traffic> allElements = readAll(Traffic.class, TRAFFIC_XML_KEY);
            allElements.removeIf(t -> t.equals(allElements.get(id)));
            return update(allElements, TRAFFIC_XML_KEY);
        } else return Result.UNSUCCESSFUL;

    }
}
