package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.LinkedList;
import java.util.List;

public class CreateTables {

    private Connection connection;
    private List<String> tablesName;

    public CreateTables(Connection connection)
    {
        this.connection = connection;
        tablesName = new LinkedList<>();
        tablesName.add("Characteristics.sql");
        tablesName.add("Workers.sql");
        tablesName.add("Rewards.sql");
        tablesName.add("Countries.sql");
        tablesName.add("Actors.sql");
        tablesName.add("Authors.sql");
        tablesName.add("Conductors.sql");
        tablesName.add("Genres.sql");
        tablesName.add("Musicians.sql");
        tablesName.add("PerformanceCategories.sql");
        tablesName.add("Producers.sql");
        tablesName.add("ProductorDesigners.sql");
        tablesName.add("Performances.sql");
        tablesName.add("Roles.sql");

        tablesName.add("ToureActor.sql");
        tablesName.add("ToureProducers.sql");
        tablesName.add("Toures.sql");
        tablesName.add("UserRoles.sql");
        tablesName.add("Users.sql");
    }

    private String writeScriptFromFile(String relativePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(
                    "/Users/kartonis/Projects/Theatre-Information-System/src/main/resources/" + relativePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> addSequences() {
        List<String> sequences = new LinkedList<>();
        for(String name : tablesName)
        {
            sequences.add(writeScriptFromFile("sequences/" + name));
        }
        return sequences;
    }

    private List<String> addAutoincrement() {
        List<String> autoIncrements = new LinkedList<>();
        for(String name : tablesName)
        {
            autoIncrements.add(writeScriptFromFile("autoincrements/" + name));
        }
        return autoIncrements;
    }

    private void execForAll(List<String> queries) {
        for (String q : queries) {
            try {
                connection.executeQuery(q);
            } catch (SQLException ignored) {
               // ignored.printStackTrace();
            }
        }
    }

    public void create() {
        List<String> createList = new LinkedList<>();
        for(String name : tablesName)
        {
            createList.add(writeScriptFromFile("create/" + name));
        }
        try {
            connection.executeQuery(writeScriptFromFile("procedures/createIfNotExists.sql"));
        }
        catch (SQLSyntaxErrorException e) {
          //  return;
            e.printStackTrace();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        execForAll(createList);
        execForAll(addSequences());
        execForAll(addAutoincrement());
    }
}
