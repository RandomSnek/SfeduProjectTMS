package ru.sfedu.transportmanagementsystem.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.transportmanagementsystem.entities.*;
import ru.sfedu.transportmanagementsystem.entities.Driver;
import ru.sfedu.transportmanagementsystem.entities.Bort;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

import static ru.sfedu.transportmanagementsystem.Constants.*;
import static ru.sfedu.transportmanagementsystem.utils.ConfigUtil.getConfigurationEntry;

public class JdbcDataProvider implements IDataProvider {
    private static final Logger log = LogManager.getLogger(JdbcDataProvider.class);

    private Result update(String sql) {
        try {
            Statement statement = initialize().createStatement();
            statement.executeUpdate(sql);
            initialize().close();
            return Result.SUCCESS;
        } catch (Exception exception) {
            log.error(exception);
            return Result.UNSUCCESSFUL;
        }
    }

    private ResultSet select(String sql) {
        try {
            PreparedStatement preparedStatement = initialize().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            initialize().close();
            return resultSet;
        } catch (Exception exception) {
            log.error(exception);
            return null;
        }
    }


    private Connection initialize() throws IOException, SQLException, ClassNotFoundException {
        Class.forName(getConfigurationEntry(JDBC_DRIVER));
        String url = getConfigurationEntry(JDBC_CONNECT);
        String user = getConfigurationEntry(JDBC_USER);
        String password =getConfigurationEntry(JDBC_PASS);
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(true);
        return connection;
    }

    @Override
    public Result createBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        }
 return update(String.format(BORT_JDBC_INSERT,bort.getId(),bort.getName(),bort.getMaxWeight(), bort.getPlates(),bort.getTotalDistance(),bort.getKuzovLength(),bort.getBortLength()));
    }

    @Override
    public Optional<Bort> getBortById(int id) {
        try {
            ResultSet rs = select(String.format(BORT_JDBC_SELECT,id));
             Bort bort = new Bort();
             rs.next();
             bort.setId(rs.getInt(1));
             bort.setName(rs.getString(2));
             bort.setMaxWeight(rs.getInt(3));
             bort.setPlates(rs.getString(4));
             bort.setTotalDistance(rs.getInt(5));
             bort.setKuzovLength(rs.getInt(6));
             bort.setBortLength(rs.getInt(7));
            return Optional.of(bort);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateBort(Bort bort) {
        if (getBortById(bort.getId()).isPresent()) {
            return update(String.format(BORT_JDBC_UPDATE,bort.getName(),bort.getMaxWeight(), bort.getPlates(),bort.getTotalDistance(),bort.getKuzovLength(),bort.getBortLength(),bort.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteBortById(int id) {
        if (getBortById(id).isPresent()) {
            return update(String.format(BORT_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }



    @Override
    public Result createTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(TRANSPORT_JDBC_INSERT,transport.getId(),transport.getName(),transport.getMaxWeight(), transport.getPlates(),transport.getTotalDistance()));
    }

    @Override
    public Optional<Transport> getTransportById(int id) {
        try {
            ResultSet rs = select(String.format(TRANSPORT_JDBC_SELECT,id));
            Transport transport = new Transport();
            rs.next();
            transport.setId(rs.getInt(1));
            transport.setName(rs.getString(2));
            transport.setMaxWeight(rs.getInt(3));
            transport.setPlates(rs.getString(4));
            transport.setTotalDistance(rs.getInt(5));
            return Optional.of(transport);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateTransport(Transport transport) {
        if (getTransportById(transport.getId()).isPresent()) {
            return update(String.format(TRANSPORT_JDBC_UPDATE,transport.getName(),transport.getMaxWeight(), transport.getPlates(),transport.getTotalDistance(),transport.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTransportById(int id) {
        if (getTransportById(id).isPresent()) {
            return update(String.format(TRANSPORT_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }


    @Override
    public Result createCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(CARGO_JDBC_INSERT,cargo.getId(),cargo.getName(),cargo.getWeight(), cargo.getCargoType().name()));
    }

    @Override
    public Optional<Cargo> getCargoById(int id) {
        try {
            ResultSet rs = select(String.format(CARGO_JDBC_SELECT,id));
            Cargo cargo = new Cargo();
            rs.next();
            cargo.setId(rs.getInt(1));
            cargo.setName(rs.getString(2));
            cargo.setWeight(rs.getInt(3));
            cargo.setCargoType(CargoType.valueOf(rs.getString(4)));
            return Optional.of(cargo);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateCargo(Cargo cargo) {
        if (getCargoById(cargo.getId()).isPresent()) {
            return update(String.format(CARGO_JDBC_UPDATE,cargo.getName(),cargo.getWeight(),cargo.getCargoType().name() ,cargo.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteCargoById(int id) {
        if (getCargoById(id).isPresent()) {
            return update(String.format(CARGO_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(CLOSED_TRANSPORT_JDBC_INSERT,closedTransport.getId(),closedTransport.getName(),closedTransport.getMaxWeight(), closedTransport.getPlates(),closedTransport.getTotalDistance(),closedTransport.getKuzovVolume()));
    }

    @Override
    public Optional<ClosedTransport> getClosedTransportById(int id) {
        try {
            ResultSet rs = select(String.format(CLOSED_TRANSPORT_JDBC_SELECT,id));
            ClosedTransport closedTransport = new ClosedTransport();
            rs.next();
            closedTransport.setId(rs.getInt(1));
            closedTransport.setName(rs.getString(2));
            closedTransport.setMaxWeight(rs.getInt(3));
            closedTransport.setPlates(rs.getString(4));
            closedTransport.setTotalDistance(rs.getInt(5));
            closedTransport.setKuzovVolume(rs.getInt(6));
            return Optional.of(closedTransport);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateClosedTransport(ClosedTransport closedTransport) {
        if (getClosedTransportById(closedTransport.getId()).isPresent()) {
            return update(String.format(CLOSED_TRANSPORT_JDBC_UPDATE,closedTransport.getName(),closedTransport.getMaxWeight(), closedTransport.getPlates(),closedTransport.getTotalDistance(),closedTransport.getKuzovVolume() ,closedTransport.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteClosedTransportById(int id) {
        if (getClosedTransportById(id).isPresent()) {
            return update(String.format(CLOSED_TRANSPORT_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(CONTAINER_JDBC_INSERT,container.getId(),container.getName(),container.getMaxWeight(), container.getPlates(),container.getTotalDistance(),container.getKuzovVolume() ,container.getContainerType().name() ));
    }

    @Override
    public Optional<Container> getContainerById(int id) {
        try {
            ResultSet rs = select(String.format(CONTAINER_JDBC_SELECT,id));
            Container container = new Container();
            rs.next();
            container.setId(rs.getInt(1));
            container.setName(rs.getString(2));
            container.setMaxWeight(rs.getInt(3));
            container.setPlates(rs.getString(4));
            container.setTotalDistance(rs.getInt(5));
            container.setKuzovVolume(rs.getInt(6));
            container.setContainerType(ContainerType.valueOf(rs.getString(7)));
            return Optional.of(container);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateContainer(Container container) {
        if (getContainerById(container.getId()).isPresent()) {
            return update(String.format(CONTAINER_JDBC_UPDATE,container.getName(),container.getMaxWeight(), container.getPlates(),container.getTotalDistance(),container.getKuzovVolume() ,container.getContainerType().name() ,container.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteContainerById(int id) {
        if (getContainerById(id).isPresent()) {
            return update(String.format(CONTAINER_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(DRIVER_JDBC_INSERT,driver.getId(),driver.getFio(),driver.getPassport(),driver.getDrivingLicenseGrade().name()));
    }

    @Override
    public Optional<Driver> getDriverById(int id) {
        try {
            ResultSet rs = select(String.format(DRIVER_JDBC_SELECT,id));
            Driver driver = new Driver();
            rs.next();
            driver.setId(rs.getInt(1));
            driver.setFio(rs.getString(2));
            driver.setPassport(rs.getString(3));
            driver.setDrivingLicenseGrade(DrivingLicenseGrade.valueOf(rs.getString(4)));
            return Optional.of(driver);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateDriver(Driver driver) {
        if (getDriverById(driver.getId()).isPresent()) {
            return update(String.format(DRIVER_JDBC_UPDATE,driver.getFio(),driver.getPassport(),driver.getDrivingLicenseGrade().name() ,driver.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteDriverById(int id) {
        if (getDriverById(id).isPresent()) {
            return update(String.format(DRIVER_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }


    @Override
    public Result createOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(OPEN_TRANSPORT_JDBC_INSERT,openTransport.getId(),openTransport.getName(),openTransport.getMaxWeight(), openTransport.getPlates(),openTransport.getTotalDistance(),openTransport.getKuzovLength()));
    }

    @Override
    public Optional<OpenTransport> getOpenTransportById(int id) {
        try {
            ResultSet rs = select(String.format(OPEN_TRANSPORT_JDBC_SELECT,id));
            OpenTransport openTransport = new OpenTransport();
            rs.next();
            openTransport.setId(rs.getInt(1));
            openTransport.setName(rs.getString(2));
            openTransport.setMaxWeight(rs.getInt(3));
            openTransport.setPlates(rs.getString(4));
            openTransport.setTotalDistance(rs.getInt(5));
            openTransport.setKuzovLength(rs.getInt(6));
            return Optional.of(openTransport);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateOpenTransport(OpenTransport openTransport) {
        if (getOpenTransportById(openTransport.getId()).isPresent()) {
            return update(String.format(OPEN_TRANSPORT_JDBC_UPDATE,openTransport.getName(),openTransport.getMaxWeight(), openTransport.getPlates(),openTransport.getTotalDistance(),openTransport.getKuzovLength() ,openTransport.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteOpenTransportById(int id) {
        if (getOpenTransportById(id).isPresent()) {
            return update(String.format(OPEN_TRANSPORT_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createPlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(PLATFORM_JDBC_INSERT,platform.getId(),platform.getName(),platform.getMaxWeight(), platform.getPlates(),platform.getTotalDistance(),platform.getKuzovLength(),platform.getLoadingHeight()));
    }

    @Override
    public Optional<Platform> getPlatformById(int id) {
        try {
            ResultSet rs = select(String.format(PLATFORM_JDBC_SELECT,id));
            Platform platform = new Platform();
            rs.next();
            platform.setId(rs.getInt(1));
            platform.setName(rs.getString(2));
            platform.setMaxWeight(rs.getInt(3));
            platform.setPlates(rs.getString(4));
            platform.setTotalDistance(rs.getInt(5));
            platform.setKuzovLength(rs.getInt(6));
            platform.setLoadingHeight(rs.getInt(7));
            return Optional.of(platform);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updatePlatform(Platform platform) {
        if (getPlatformById(platform.getId()).isPresent()) {
            return update(String.format(PLATFORM_JDBC_UPDATE,platform.getName(),platform.getMaxWeight(), platform.getPlates(),platform.getTotalDistance(),platform.getKuzovLength(),platform.getLoadingHeight() ,platform.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deletePlatformById(int id) {
        if (getPlatformById(id).isPresent()) {
            return update(String.format(PLATFORM_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(REFRIGERATOR_JDBC_INSERT,refrigerator.getId(),refrigerator.getName(),refrigerator.getMaxWeight(), refrigerator.getPlates(),refrigerator.getTotalDistance(),refrigerator.getKuzovVolume(),refrigerator.getTemperature(),refrigerator.getFridgeClass().name()));
    }

    @Override
    public Optional<Refrigerator> getRefrigeratorById(int id) {
        try {
            ResultSet rs = select(String.format(REFRIGERATOR_JDBC_SELECT,id));
            Refrigerator refrigerator = new Refrigerator();
            rs.next();
            refrigerator.setId(rs.getInt(1));
            refrigerator.setName(rs.getString(2));
            refrigerator.setMaxWeight(rs.getInt(3));
            refrigerator.setPlates(rs.getString(4));
            refrigerator.setTotalDistance(rs.getInt(5));
            refrigerator.setKuzovVolume(rs.getInt(6));
            refrigerator.setTemperature(rs.getInt(7));
            refrigerator.setFridgeClass(RefrigeratorClass.valueOf(rs.getString(8)));
            return Optional.of(refrigerator);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateRefrigerator(Refrigerator refrigerator) {
        if (getRefrigeratorById(refrigerator.getId()).isPresent()) {
            return update(String.format(REFRIGERATOR_JDBC_UPDATE,refrigerator.getName(),refrigerator.getMaxWeight(), refrigerator.getPlates(),refrigerator.getTotalDistance(),refrigerator.getKuzovVolume(),refrigerator.getTemperature(),refrigerator.getFridgeClass().name(),refrigerator.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteRefrigeratorById(int id) {
        if (getRefrigeratorById(id).isPresent()) {
            return update(String.format(REFRIGERATOR_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }




    @Override
    public Result createTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(TENT_JDBC_INSERT,tent.getId(),tent.getName(),tent.getMaxWeight(), tent.getPlates(),tent.getTotalDistance(),tent.getKuzovVolume(),tent.getTentType().name()));
    }

    @Override
    public Optional<Tent> getTentById(int id) {
        try {
            ResultSet rs = select(String.format(TENT_JDBC_SELECT,id));
            Tent tent = new Tent();
            rs.next();
            tent.setId(rs.getInt(1));
            tent.setName(rs.getString(2));
            tent.setMaxWeight(rs.getInt(3));
            tent.setPlates(rs.getString(4));
            tent.setTotalDistance(rs.getInt(5));
            tent.setKuzovVolume(rs.getInt(6));
            tent.setTentType(TentType.valueOf(rs.getString(7)));
            return Optional.of(tent);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateTent(Tent tent) {
        if (getTentById(tent.getId()).isPresent()) {
            return update(String.format(TENT_JDBC_UPDATE,tent.getName(),tent.getMaxWeight(), tent.getPlates(),tent.getTotalDistance(),tent.getKuzovVolume(),tent.getTentType().name() ,tent.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTentById(int id) {
        if (getTentById(id).isPresent()) {
            return update(String.format(TENT_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }


    @Override
    public Result createTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            return Result.UNSUCCESSFUL;
        } else return update(String.format(TRAFFIC_JDBC_INSERT,traffic.getId(),traffic.getCargoId(),traffic.getTransportId(),traffic.getDriverId(),traffic.getDistance()));
    }

    @Override
    public Optional<Traffic> getTrafficById(int id) {
        try {
            ResultSet rs = select(String.format(TRAFFIC_JDBC_SELECT,id));
            Traffic traffic = new Traffic();
            rs.next();
            traffic.setId(rs.getInt(1));
            traffic.setCargoId(rs.getInt(2));
            traffic.setTransportId(rs.getInt(3));
            traffic.setDriverId(rs.getInt(4));
            traffic.setDistance(rs.getInt(5));
            return Optional.of(traffic);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Result updateTraffic(Traffic traffic) {
        if (getTrafficById(traffic.getId()).isPresent()) {
            return update(String.format(TRAFFIC_JDBC_UPDATE, traffic.getCargoId(),traffic.getTransportId(),traffic.getDriverId(),traffic.getDistance(),traffic.getId()));
        }
        else return Result.UNSUCCESSFUL;
    }

    @Override
    public Result deleteTrafficById(int id) {
        if (getTrafficById(id).isPresent()) {
            return update(String.format(TRAFFIC_JDBC_DELETE,id));
        }
        else return Result.UNSUCCESSFUL;
    }


}
