/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.transportmanagementsystem.api;

import ru.sfedu.transportmanagementsystem.entities.Transport;
import ru.sfedu.transportmanagementsystem.entities.Bort;
import ru.sfedu.transportmanagementsystem.entities.Result;
import ru.sfedu.transportmanagementsystem.entities.Cargo;
import ru.sfedu.transportmanagementsystem.entities.ClosedTransport;
import ru.sfedu.transportmanagementsystem.entities.OpenTransport;
import ru.sfedu.transportmanagementsystem.entities.Container;
import ru.sfedu.transportmanagementsystem.entities.Platform;
import ru.sfedu.transportmanagementsystem.entities.Refrigerator;
import ru.sfedu.transportmanagementsystem.entities.Tent;
import ru.sfedu.transportmanagementsystem.entities.Driver;
import ru.sfedu.transportmanagementsystem.entities.Traffic;
import java.util.Optional;

/**
 *
 * @author HOME
 */
public interface IDataProvider {
    Result createTransport(Transport transport);
    Result updateTransport(Transport transport);
    Result deleteTransportById(int id);
    Optional <Transport> getTransportById(int id);

    Result createBort(Bort bort);
    Result updateBort(Bort bort);
    Result deleteBortById(int id);
    Optional<Bort> getBortById(int id);

    Result createClosedTransport(ClosedTransport closedTransport);
    Result updateClosedTransport(ClosedTransport closedTransport);
    Result deleteClosedTransportById(int id);
    Optional <ClosedTransport> getClosedTransportById(int id);

    Result createContainer(Container container);
    Result updateContainer(Container container);
    Result deleteContainerById(int id);
    Optional <Container> getContainerById(int id);

    Result createOpenTransport(OpenTransport openTransport);
    Result updateOpenTransport(OpenTransport openTransport);
    Result deleteOpenTransportById(int id);
    Optional <OpenTransport> getOpenTransportById(int id);

    Result createPlatform(Platform platform);
    Result updatePlatform(Platform platform);
    Result deletePlatformById(int id);
    Optional <Platform> getPlatformById(int id);

    Result createRefrigerator(Refrigerator refrigerator);
    Result updateRefrigerator(Refrigerator refrigerator);
    Result deleteRefrigeratorById(int id);
    Optional <Refrigerator> getRefrigeratorById(int id);

    Result createTent(Tent tent);
    Result updateTent(Tent tent);
    Result deleteTentById(int id);
    Optional <Tent> getTentById(int id);

    Result createCargo(Cargo cargo);
    Result updateCargo(Cargo cargo);
    Result deleteCargoById(int id);
    Optional <Cargo> getCargoById(int id);

    Result createDriver(Driver driver);
    Result updateDriver(Driver driver);
    Result deleteDriverById(int id);
    Optional <Driver> getDriverById(int id);

    Result createTraffic(Traffic traffic);
    Result updateTraffic(Traffic traffic);
    Result deleteTrafficById(int id);
    Optional <Traffic> getTrafficById(int id);
}
