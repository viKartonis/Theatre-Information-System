package dao.inserts;

import dao.Connection;

import java.util.LinkedList;
import java.util.List;

public class InsertPerformances {

    private Connection connection;
    private static int id = 10;

    public InsertPerformances(Connection connection){
        this.connection = connection;
    }

    public void insert() {
        List<String> performances = new LinkedList<>();
        String template = "INSERT INTO performances(performance_id, name, producer_id, productor_designer_id, " +
                "performance_category_id, coast, conductor_id, sales, author_id, is_premier, performance_date, " +
                "genre_id) ";
        performances.add(connection.createQuery(template, "VALUES(0, 'Фабрика слов', 0, 0, 0, 500, 0, 0, 0, 0, " +
                "TO_DATE('2020/05/01', 'yyyy/mm/dd'), 0)"));
        performances.add(connection.createQuery(template, "VALUES(1, 'Кот в сапогах', 1, 1, 1, 1000, 1, 10, 1, 1, " +
                "TO_DATE('2020/06/01', 'yyyy/mm/dd'), 1)"));
        performances.add(connection.createQuery(template, "VALUES(2, 'Агата возвращается домой', 2, 2, 2, 1500, 2, 20, 2, 0, " +
                "TO_DATE('2020/07/01', 'yyyy/mm/dd'), 2)"));
        performances.add(connection.createQuery(template, "VALUES(3, 'Тайна тетушки Мэлкин', 3, 3, 0, 2000, 3, 30, 3, 1, " +
                "TO_DATE('2020/08/01', 'yyyy/mm/dd'), 3)"));
        performances.add(connection.createQuery(template, "VALUES(4, 'Кролик Эдвард', 4, 4, 1, 2500, 4, 40, 4, 0, " +
                "TO_DATE('2020/09/01', 'yyyy/mm/dd'), 4)"));
        performances.add(connection.createQuery(template, "VALUES(5, 'Удивительное путешествие кролика Эдварда', 5, 5, " +
                " 2, 3000, 5, 50, 5, 1, TO_DATE('2020/10/01', 'yyyy/mm/dd'), 5)"));
        performances.add(connection.createQuery(template, "VALUES(6, 'Сотворившая чудо', 6, 6, 0, 3500, 6, 60, 6, 0, " +
                "TO_DATE('2020/11/01', 'yyyy/mm/dd'), 6)"));
        performances.add(connection.createQuery(template, "VALUES(7, 'Майская ночь', 7, 7, 1, 4000, 7, 70, 7, 1, " +
                "TO_DATE('2020/12/01', 'yyyy/mm/dd'), 7)"));
        performances.add(connection.createQuery(template, "VALUES(8, 'Альма и Брут', 8, 8, 2, 4500, 8, 80, 8, 0, " +
                "TO_DATE('2020/05/02', 'yyyy/mm/dd'), 9)"));
        performances.add(connection.createQuery(template, "VALUES(9, 'Инь и Ян', 9, 9, 0, 5000, 9, 90, 9, 1, " +
                "TO_DATE('2020/05/03', 'yyyy/mm/dd'), 8)"));

        connection.insert(performances);
    }
    public void insert(String name, int producer_id, int productorDesigner_id, int performanceCategory, int coast,
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
}
