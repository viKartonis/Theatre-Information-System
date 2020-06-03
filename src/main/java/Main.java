import dao.Connection;
import dao.CreateTables;
import dao.inserts.InsertCharacteristics;
import dao.inserts.InsertInto;
import dao.inserts.InsertPerformances;
import dao.inserts.InsertWorkers;
import gui.LogIn;
import gui.Menu;

import java.sql.SQLException;

public class Main {

    private static void initDataBase(Connection connection) {

        CreateTables createTables = new CreateTables(connection);
        createTables.create();

//        InsertCharacteristics insertCharacteristics = new InsertCharacteristics(connection);
//        insertCharacteristics.insert();
//
//        InsertWorkers insertWorkers = new InsertWorkers(connection);
//        insertWorkers.insert();
//
//        InsertInto insertInto = new InsertInto(connection);
//        insertInto.insertProducers();
//        insertInto.insertProductorDesigners();
//        insertInto.insertPerformanceCategory();
//        insertInto.insertConductor();
//        insertInto.insertCountries();
//        insertInto.insertAuthors();
//        insertInto.insertGenres();
//
//        InsertPerformances insertPerformances = new InsertPerformances(connection);
//        insertPerformances.insert();
//
//        insertInto.insertRoles();
//
//        insertInto.insertTours();
//        insertInto.insertTourActors();
//        insertInto.insertTourProducer();
        }

    public static void main(String[] args) {
        try {
            Connection connection = new Connection();
            initDataBase(connection);
            LogIn logIn = new LogIn(connection);
            logIn.loginInApplication();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
