package dao;

import java.sql.*;
import java.util.*;
import java.util.function.Function;

public class Connection {

    private java.sql.Connection conn;

    public Connection() throws SQLException {
        String url = "jdbc:oracle:thin:@84.237.50.81:1521:";
        Properties props = new Properties();
        props.setProperty("user", "kartonis");
        props.setProperty("password", "123");
        conn = DriverManager.getConnection(url, props);
    }

    private void createConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        TimeZone.setDefault(timeZone);
        Locale.setDefault(Locale.ENGLISH);
    }

    public void executeQuery(List<String> queryList) throws SQLException {
        createConnection();
        for (String sqlQuery: queryList) {
            try(PreparedStatement preStatement = conn.prepareStatement(sqlQuery)) {
                preStatement.executeUpdate(sqlQuery);
                // ResultSet result = preStatement.executeQuery();
            }
        }
    }
    public void executeQuery(String sqlQuery) throws SQLException {
        createConnection();
        try(PreparedStatement preStatement = conn.prepareStatement(sqlQuery)) {
            preStatement.executeUpdate(sqlQuery);
            //  ResultSet result = preStatement.executeQuery();
        }
    }

    public void insert(List<String> queryList) {

        createConnection();
        for(String query : queryList) {
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.executeUpdate(query);
//                ResultSet result = pstmt.executeQuery();
                System.out.println("INSERT");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<List<String>> select(String sql){
        return select(sql, result -> {
            try {
                ArrayList<String> list = new ArrayList<>(1);
                list.add(result.getString(1));
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }


    public List<List<String>> select(String sql, Function<ResultSet, List<String>> toString){

        createConnection();
        List<List<String>> names = new LinkedList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()){
                names.add(toString.apply(result));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    public String createQuery(String template, String data){
        return template + data;
    }

    public void close() throws SQLException {
        conn.close();
    }


    public void delete(String query) {
        createConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate(query);
          //  ResultSet result = pstmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

