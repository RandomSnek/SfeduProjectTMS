/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.transportmanagementsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.transportmanagementsystem.api.JdbcDataProvider;
import ru.sfedu.transportmanagementsystem.api.XmlDataProvider;
import ru.sfedu.transportmanagementsystem.api.CsvDataProvider;
import ru.sfedu.transportmanagementsystem.api.IDataProvider;
import ru.sfedu.transportmanagementsystem.entities.*;

import java.io.InputStream;
import java.util.Scanner;

import static ru.sfedu.transportmanagementsystem.Constants.INPUT_ERROR;

/**
 *
 * @author HOME
 */

public class Main {
  private static Logger log = LogManager.getLogger(Main.class);
    Main() {
        log.debug("TransportManagementSystemClient: starting application.........");
    }

    public static void main(String[] args) {
//      try {
      Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип провайдера для приложения ('CSV' для CSV, 'DB' для JDBC, 'XML' для XML) ");
        String input = scanner.nextLine().toUpperCase();
        IDataProvider provider = newDataSource(input);
      System.out.println("Введите какое действие вы хотите выполнить (команды для типов действий можно найти в README.txt) ");

//      }
    }





//private static Result chooseRecordType(String recordType) {
//      switch (InputKeys.valueOf(recordType.toUpperCase()) ){
//        case DRIVER:
//          return driver();
//        case CARGO:
//        return cargo();
//        case TRANSPORT:
//          return transport();
//          default:
//            log.info(INPUT_ERROR);
//      }
//}


  private static IDataProvider newDataSource(String provider){
    switch (InputKeys.valueOf(provider.toUpperCase())) {
      case CSV:
        return new CsvDataProvider();
      case DB:
        return new JdbcDataProvider();
      case XML:
        return new XmlDataProvider();
      default:
        log.info(INPUT_ERROR);
    }
    return null;
  }





}
