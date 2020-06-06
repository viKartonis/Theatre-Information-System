package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertInto {

    private Connection connection;
    private List<String> tablesName;

    public InsertInto(Connection connection)
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

    private List<String> writeScriptFromFile(String relativePath) {
        try {
            Scanner scanner = new Scanner(new String(Files.readAllBytes(Paths.get(
                    "/Users/kartonis/Projects/Theatre-Information-System/src/main/resources/" + relativePath))));
            List<String> queries = new LinkedList<>();
            while (scanner.hasNext()) {
                String script = scanner.nextLine();
                queries.add(script);
            }
            return queries;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void execForAll(List<String> queries) {
        for (String q : queries) {
            try {
                connection.executeQuery(q);
            } catch (SQLException ignored) {
            }
        }
    }

    public void insert() {
        List<String> execList = new LinkedList<>();
        for(String name : tablesName)
        {
            List<String> list = writeScriptFromFile("inserts/" + name);
            for(int i = 0; i < list.size(); ++i) {
                execList.add(list.get(i));
            }
            execForAll(list);
        }
    }

    public int insertCharacteristics(int gender, String dateDb, String voice, int height, String startWorkDate, int child, int salary) {
        List<String> characteristicsList = new LinkedList<>();
        characteristicsList.add(
                "INSERT INTO characteristics(gender, date_bd, voice, height, start_work, child, salary) "
                        + "VALUES(" + gender + ", TO_DATE('" + dateDb + "', 'yyyy/mm/dd'), '" +
                        voice + "', " + height + ", " + "TO_DATE('" + startWorkDate + "', 'yyyy/mm/dd'), "
                        + child + ", " + salary + ")");
        connection.insert(characteristicsList);
        List<List<String>> chars = connection.select("SELECT characteristics.characteristic_id FROM characteristics");

        return Integer.parseInt(chars.get(chars.size() - 1).get(0));
    }

    public void insertUser(String email, String password, int role){
        List<String> user = new LinkedList<>();
        user.add("INSERT INTO users(email, password, user_role_id) VALUES('" + email + "', '" + password + "', " + role + ")");
        connection.insert(user);
    }

    public void insertActor(int workerId, int isStudent) {
        List<String> actorsList = new LinkedList<>();
        actorsList.add("INSERT INTO actors(worker_id, reward_id, is_student) VALUES (" +
                workerId + ", NULL, " + isStudent + ")");
        connection.insert(actorsList);
    }

    public void insertProducer(int workerId) {
        List<String> producers = new LinkedList<>();
        producers.add("INSERT INTO producers(worker_id) VALUES(" + workerId + ")");
        connection.insert(producers);
    }

    public void insertDesigner(int workerId) {
        List<String> designer = new LinkedList<>();
        designer.add("INSERT INTO productor_designers(worker_id) VALUES(" + workerId + ")");
        connection.insert(designer);
    }

    public void insertMusician(int workerId) {
        List<String> musicianList = new LinkedList<>();
        musicianList.add("INSERT INTO musician(worker_id) VALUES(" + workerId + ")");
        connection.insert(musicianList);
    }

    public void insertConductor(int workerId) {
        List<String> conductor = new LinkedList<>();
        conductor.add("INSERT INTO conductors(worker_id) VALUES(" + workerId +  ")");
        connection.insert(conductor);
    }

    public void insertPerformance(String name, int producer_id, int productorDesigner_id, int performanceCategory, int coast,
                       int conductorId, int authorId, int isPremier, String performanceDate, int genreId){
        List<String> performances = new LinkedList<>();
        performances.add("INSERT INTO performances(name, producer_id, productor_designer_id, " +
                "performance_category_id, coast, conductor_id, sales, author_id, is_premier, performance_date, " +
                "genre_id) VALUES('" + name + "', " + producer_id + ", "+ productorDesigner_id + ", " +
                performanceCategory + ", " + coast + ", " + conductorId + ", NULL, " + authorId + ", " + isPremier
                + ", TO_DATE('" + performanceDate + "', 'yyyy/mm/dd'), " + genreId + ")");
        System.out.println("INSERT");
        connection.insert(performances);
    }

    public int insertWorker(String name, int characteristicId) {
        List<String> workersList = new LinkedList<>();
        workersList.add("INSERT INTO workers(name, characteristic_id) VALUES('" + name + "', " +
                characteristicId + ")");
        connection.insert(workersList);
        List<List<String>> chars = connection.select("SELECT workers.worker_id FROM workers");
        return Integer.parseInt(chars.get(chars.size() - 1).get(0));
    }
}
