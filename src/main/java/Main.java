import dao.Connection;
import dao.CreateTables;
import dao.InsertInto;
import gui.LogIn;

import java.sql.SQLException;

public class Main {

    private static void initDataBase(Connection connection) {

        CreateTables createTables = new CreateTables(connection);
        createTables.create();
        InsertInto insertInto = new InsertInto(connection);
        insertInto.insert();
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
