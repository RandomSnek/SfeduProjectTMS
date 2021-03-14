package ru.sfedu.transportmanagementsystem;

public final class Constants {
    public static final String BORT_CSV_KEY = "csvBort";
    public static final String ENV_PROP_KEY = "env";
    public static final String ENV_PROP_VALUE = "./src/main/resources/environment.properties";
    public static final String TRANSPORT_CSV_KEY = "csvTransport";
    public static final String CARGO_CSV_KEY = "csvCargo";
    public static final String CLOSED_TRANSPORT_CSV_KEY = "csvClosedTransport";
    public static final String CONTAINER_CSV_KEY = "csvContainer";
    public static final String DRIVER_CSV_KEY ="csvDriver";
    public static final String OPEN_TRANSPORT_CSV_KEY ="csvOpenTransport";
    public static final String PLATFORM_CSV_KEY = "csvPlatform";
    public static final String REFRIGERATOR_CSV_KEY = "csvRefrigerator";
    public static final String TENT_CSV_KEY = "csvTent";
    public static final String TRAFFIC_CSV_KEY = "csvTraffic";

    public static final String BORT_XML_KEY = "xmlBort";
    public static final String TRANSPORT_XML_KEY = "xmlTransport";
    public static final String CARGO_XML_KEY = "xmlCargo";
    public static final String CLOSED_TRANSPORT_XML_KEY = "xmlClosedTransport";
    public static final String CONTAINER_XML_KEY = "xmlContainer";
    public static final String DRIVER_XML_KEY ="xmlDriver";
    public static final String OPEN_TRANSPORT_XML_KEY ="xmlOpenTransport";
    public static final String PLATFORM_XML_KEY = "xmlPlatform";
    public static final String REFRIGERATOR_XML_KEY = "xmlRefrigerator";
    public static final String TENT_XML_KEY = "xmlTent";
    public static final String TRAFFIC_XML_KEY = "xmlTraffic";

    public static final String BORT_JDBC_INSERT = "INSERT INTO BORT VALUES(%d, '%s',%d,'%s',%d,%d,%d)";
    public static final String TRANSPORT_JDBC_INSERT = "INSERT INTO TRANSPORT VALUES (%d,'%s',%d,'%s',%d)";
    public static final String CARGO_JDBC_INSERT = "INSERT INTO CARGO VALUES (%d,'%s',%d,'%s')";
    public static final String CLOSED_TRANSPORT_JDBC_INSERT = "INSERT INTO CLOSEDTRANSPORT VALUES (%d,'%s',%d,'%s',%d,%d)";
    public static final String CONTAINER_JDBC_INSERT = "INSERT INTO CONTAINER VALUES (%d,'%s',%d,'%s',%d,%d,'%s')";
    public static final String DRIVER_JDBC_INSERT = "INSERT INTO DRIVER VALUES (%d,'%s','%s','%s')";
    public static final String OPEN_TRANSPORT_JDBC_INSERT ="INSERT INTO OPENTRANSPORT VALUES (%d,'%s',%d,'%s',%d,%d)";
    public static final String PLATFORM_JDBC_INSERT = "INSERT INTO PLATFORM VALUES (%d,'%s',%d,'%s',%d,%d,%d)";
    public static final String REFRIGERATOR_JDBC_INSERT = "INSERT INTO REFRIGERATOR VALUES (%d,'%s',%d,'%s',%d,%d,%d,'%s')";
    public static final String TENT_JDBC_INSERT = "INSERT INTO TENT VALUES (%d,'%s',%d,'%s',%d,%d,'%s')";
    public static final String TRAFFIC_JDBC_INSERT = "INSERT INTO TRAFFIC VALUES (%d,%d,%d,%d,%d)";

    public static final String BORT_JDBC_SELECT = "SELECT ID,NAME,MAXWEIGHT,PLATES,TOTALDISTANCE,KUZOVLENGTH,BORTLENGTH FROM BORT WHERE ID= %d";
    public static final String TRANSPORT_JDBC_SELECT = "SELECT * FROM TRANSPORT WHERE ID=%d";
    public static final String CARGO_JDBC_SELECT = "SELECT ID,NAME,WEIGHT,CARGOTYPE FROM CARGO WHERE ID=%d";
    public static final String CLOSED_TRANSPORT_JDBC_SELECT = "SELECT * FROM CLOSEDTRANSPORT WHERE ID=%d";
    public static final String CONTAINER_JDBC_SELECT = "SELECT * FROM CONTAINER WHERE ID=%d";
    public static final String DRIVER_JDBC_SELECT ="SELECT * FROM DRIVER WHERE ID=%d";
    public static final String OPEN_TRANSPORT_JDBC_SELECT ="SELECT * FROM OPENTRANSPORT WHERE ID=%d";
    public static final String PLATFORM_JDBC_SELECT = "SELECT * FROM PLATFORM WHERE ID=%d";
    public static final String REFRIGERATOR_JDBC_SELECT = "SELECT * FROM REFRIGERATOR WHERE ID=%d";
    public static final String TENT_JDBC_SELECT = "SELECT * FROM TENT WHERE ID=%d";
    public static final String TRAFFIC_JDBC_SELECT = "SELECT * FROM TRAFFIC WHERE ID=%d";

    public static final String BORT_JDBC_UPDATE = "UPDATE BORT SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVLENGTH=%d, BORTLENGTH=%d WHERE ID=%d";
    public static final String TRANSPORT_JDBC_UPDATE = "UPDATE TRANSPORT SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d WHERE ID=%d";
    public static final String CARGO_JDBC_UPDATE = "UPDATE CARGO SET NAME='%s', WEIGHT=%d, CARGOTYPE='%s' WHERE ID=%d";
    public static final String CLOSED_TRANSPORT_JDBC_UPDATE = "UPDATE CLOSEDTRANSPORT SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVVOLUME=%d WHERE ID=%d";
    public static final String CONTAINER_JDBC_UPDATE = "UPDATE CONTAINER SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVVOLUME=%d, CONTAINERTYPE='%s' WHERE ID=%d";
    public static final String DRIVER_JDBC_UPDATE = "UPDATE DRIVER SET FIO='%s', PASSPORT='%s', DRIVINGGRADE='%s' WHERE ID=%d";
    public static final String OPEN_TRANSPORT_JDBC_UPDATE = "UPDATE OPENTRANSPORT SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVLENGTH=%d WHERE ID=%d";
    public static final String PLATFORM_JDBC_UPDATE = "UPDATE PLATFORM SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVLENGTH=%d, LOADINGHEIGHT=%d WHERE ID=%d";
    public static final String REFRIGERATOR_JDBC_UPDATE = "UPDATE REFRIGERATOR SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVVOLUME=%d, TEMPERATURE=%d, REFRIGERATORGRADE='%s' WHERE ID=%d";
    public static final String TENT_JDBC_UPDATE = "UPDATE TENT SET NAME='%s',MAXWEIGHT=%d ,PLATES='%s', TOTALDISTANCE=%d, KUZOVVOLUME=%d, TENTTYPE='%s' WHERE ID=%d";
    public static final String TRAFFIC_JDBC_UPDATE = "UPDATE TRAFFIC SET CARGOID=%d, TRANSPORTID=%d, DRIVERID=%d, DISTANCE=%d WHERE ID=%d";

    public static final String BORT_JDBC_DELETE = "DELETE FROM BORT WHERE ID=%d";
    public static final String TRANSPORT_JDBC_DELETE = "DELETE FROM TRANSPORT WHERE ID=%d";
    public static final String CARGO_JDBC_DELETE = "DELETE FROM CARGO WHERE ID=%d";
    public static final String CLOSED_TRANSPORT_JDBC_DELETE = "DELETE FROM CLOSEDTRANSPORT WHERE ID=%d";
    public static final String CONTAINER_JDBC_DELETE = "DELETE FROM CONTAINER WHERE ID=%d";
    public static final String DRIVER_JDBC_DELETE = "DELETE FROM DRIVER WHERE ID=%d";
    public static final String OPEN_TRANSPORT_JDBC_DELETE ="DELETE FROM OPENTRANSPORT WHERE ID=%d";
    public static final String PLATFORM_JDBC_DELETE = "DELETE FROM PLATFORM WHERE ID=%d";
    public static final String REFRIGERATOR_JDBC_DELETE = "DELETE FROM REFRIGERATOR WHERE ID=%d";
    public static final String TENT_JDBC_DELETE = "DELETE FROM TENT WHERE ID=%d";
    public static final String TRAFFIC_JDBC_DELETE = "DELETE FROM TRAFFIC WHERE ID=%d";

    public static final String JDBC_DRIVER = "dbDriver";
    public static final String JDBC_CONNECT = "dbConnect";
    public static final String JDBC_USER = "dbUser";
    public static final String JDBC_PASS = "dbPass";

    public static final String INPUT_ERROR = "Недопустимый ввод ";
    public static final String UPD_BEFORE_SENDOFF_ERROR =  "Недопустимый параметр updSendOff в файле properties (принимает только значения true и false)";
    public static final String INPUT_SPLIT = "\\W+";
    public static final String PARSE_ERROR ="Неправильное кол-во аргументов";
    public static final String UPD_BEFORE_SENDOFF ="updSendOff";
}
