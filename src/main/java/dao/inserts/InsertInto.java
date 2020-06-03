package dao.inserts;
import dao.Connection;

import java.util.*;

public class InsertInto {

    private Connection connection;

    public InsertInto(Connection connection) {
        this.connection = connection;
    }

    public void insertRewards() {
        List<String> rewardList = new LinkedList<>();
        String rewardTemplate = "INSERT INTO rewards(reward_id, name, date_b) ";
        rewardList.add(rewardTemplate + "VALUES(4, 'Оскар', TO_DATE('2003/06/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(5, 'Оскар', TO_DATE('2004/05/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(6, 'Золотой глобус', TO_DATE('2003/05/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(7, 'Золотой глобус', TO_DATE('2005/05/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(8, 'Золотой глобус', TO_DATE('2003/07/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(9, 'Премия Британской Академии', TO_DATE('2003/05/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(10, 'Премия Британской Академии', TO_DATE('2006/08/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(11, 'Премия Британской Академии', TO_DATE('2003/05/10', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(12, 'Сезар', TO_DATE('2003/05/04', 'yyyy/mm/dd'))");
        rewardList.add(rewardTemplate + "VALUES(13, 'Сезар', TO_DATE('2007/05/04', 'yyyy/mm/dd'))");
        connection.insert(rewardList);
    }

    public void insert(String name) {
        List<String> list = new LinkedList<>();
        Scanner sc = new Scanner(name);
        while (sc.hasNext())
        {
            list.add(sc.nextLine());
        }
        connection.insert(list);
    }

    public void insertMusician(){
        List<String> musicianList = new LinkedList<>();
        String template = "";
        connection.insert(musicianList);
    }

    public void insertProducers(){
        List<String> producers = new LinkedList<>();
        String template = "INSERT INTO producers(producer_id, worker_id)";
        producers.add(connection.createQuery(template, "VALUES(0, 20)"));
        producers.add(connection.createQuery(template, "VALUES(1, 21)"));
        producers.add(connection.createQuery(template, "VALUES(2, 22)"));
        producers.add(connection.createQuery(template, "VALUES(3, 23)"));
        producers.add(connection.createQuery(template, "VALUES(4, 24)"));
        producers.add(connection.createQuery(template, "VALUES(5, 25)"));
        producers.add(connection.createQuery(template, "VALUES(6, 26)"));
        producers.add(connection.createQuery(template, "VALUES(7, 27)"));
        producers.add(connection.createQuery(template, "VALUES(8, 28)"));
        producers.add(connection.createQuery(template, "VALUES(9, 29)"));
        connection.insert(producers);

    }

    public void insertProductorDesigners(){
        List<String> productorDesigners = new LinkedList<>();
        String template = "INSERT INTO productor_designers(productor_designers_id, worker_id)";
        productorDesigners.add(connection.createQuery(template, "VALUES(0, 30)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(1, 31)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(2, 32)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(3, 33)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(4, 34)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(5, 35)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(6, 36)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(7, 37)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(8, 38)"));
        productorDesigners.add(connection.createQuery(template, "VALUES(9, 39)"));
        connection.insert(productorDesigners);

    }

    public void insertConductor(){
        List<String> conductors = new LinkedList<>();
        String template = "INSERT INTO conductors(conductor_id, worker_id)";
        conductors.add(connection.createQuery(template, "VALUES(0, 40)"));
        conductors.add(connection.createQuery(template, "VALUES(1, 41)"));
        conductors.add(connection.createQuery(template, "VALUES(2, 42)"));
        conductors.add(connection.createQuery(template, "VALUES(3, 43)"));
        conductors.add(connection.createQuery(template, "VALUES(4, 44)"));
        conductors.add(connection.createQuery(template, "VALUES(5, 45)"));
        conductors.add(connection.createQuery(template, "VALUES(6, 46)"));
        conductors.add(connection.createQuery(template, "VALUES(7, 47)"));
        conductors.add(connection.createQuery(template, "VALUES(8, 48)"));
        conductors.add(connection.createQuery(template, "VALUES(9, 49)"));
        connection.insert(conductors);

    }

    public void insertPerformanceCategory(){
        List<String> categories = new LinkedList<>();
        String template = "INSERT INTO performance_categories(performance_category_id, name)";
        categories.add(connection.createQuery(template, "VALUES(0, 'детские')"));
        categories.add(connection.createQuery(template, "VALUES(1, 'молодёжные')"));
        categories.add(connection.createQuery(template, "VALUES(2, 'взрослые')"));
        connection.insert(categories);
    }

    public void insertCountries(){
        List<String> countries = new LinkedList<>();
        String template = "INSERT INTO countries(country_id, name)";

        connection.insert(countries);

    }

    public void insertAuthors(){
        List<String> authors = new LinkedList<>();
        String template = "INSERT INTO author(author_id, name, country_id, century) ";
        authors.add(connection.createQuery(template, "VALUES(0, 'Виолетта Баженова', 0, 16)"));
        authors.add(connection.createQuery(template, "VALUES(1, 'Евгения Богинская', 1, 17)"));
        authors.add(connection.createQuery(template, "VALUES(2, 'Юрий Бутусов', 2, 18)"));
        authors.add(connection.createQuery(template, "VALUES(3, 'Олег Ерёмин', 3, 19)"));
        authors.add(connection.createQuery(template, "VALUES(4, 'Айдар Заббаров', 4, 20)"));
        authors.add(connection.createQuery(template, "VALUES(5, 'Олег Зорин', 5, 21)"));
        authors.add(connection.createQuery(template, "VALUES(6, 'Вера Камышникова', 6, 20)"));
        authors.add(connection.createQuery(template, "VALUES(7, 'Роман Кочержевский', 7, 19)"));
        authors.add(connection.createQuery(template, "VALUES(8, 'Олег Леваков', 8, 18)"));
        authors.add(connection.createQuery(template, "VALUES(9, 'Дмитрий Луговкин', 9, 17)"));
        connection.insert(authors);

    }

    public void insertGenres(){
        List<String> genres = new LinkedList<>();
        String template = "";
;
        connection.insert(genres);
    }

    public void insertRoles(){
        List<String> roles = new LinkedList<>();
        String template = "INSERT INTO roles(role_id, name, characteristic_id, actor_id, understudy_id, performance_is ) ";
        roles.add(connection.createQuery(template, "VALUES(0, 'Папа Оскара', 5, 9, 8, 0)"));
        roles.add(connection.createQuery(template, "VALUES(1, 'Волшебник', 3, 8, 9, 1)"));
        roles.add(connection.createQuery(template, "VALUES(2, 'Старший сын мельника', 5, 9, 8, 1)"));
        roles.add(connection.createQuery(template, "VALUES(3, 'Тетушка Мэлкин', 0, 0, 1, 3)"));
        roles.add(connection.createQuery(template, "VALUES(4, 'Король', 3, 8, 9,  3)"));
        roles.add(connection.createQuery(template, "VALUES(5, 'Эдвард', 5, 9, 8, 5)"));
        roles.add(connection.createQuery(template, "VALUES(6, 'Люси', 21, 2, 0, 6)"));
        roles.add(connection.createQuery(template, "VALUES(7, 'Абилин', 19, 3, 4, 8)"));
        roles.add(connection.createQuery(template, "VALUES(8, 'Пелегрина', 17,  4, 5, 8)"));
        roles.add(connection.createQuery(template, "VALUES(9, 'МАСА', 15, 5, 6, 9)"));

        connection.insert(roles);
    }

    public void insertTours(){
        List<String> tours = new LinkedList<>();
        String template = "INSERT INTO toures(toure_id, performance_id, is_local, date_start, date_end ) ";
        tours.add(connection.createQuery(template, "VALUES(0, 0, 1, TO_DATE('2003/06/04', 'yyyy/mm/dd'), " +
                "TO_DATE('2003/07/04', 'yyyy/mm/dd'))"));
        tours.add(connection.createQuery(template, "VALUES(1, 1, 0, TO_DATE('2005/06/04', 'yyyy/mm/dd'), " +
                "TO_DATE('2005/07/04', 'yyyy/mm/dd'))"));
        tours.add(connection.createQuery(template, "VALUES(2, 2, 0, TO_DATE('2008/06/04', 'yyyy/mm/dd'), " +
                "TO_DATE('2008/07/04', 'yyyy/mm/dd'))"));
        tours.add(connection.createQuery(template, "VALUES(3, 3, 0, TO_DATE('2012/06/04', 'yyyy/mm/dd'), " +
                "TO_DATE('2012/07/04', 'yyyy/mm/dd'))"));
        tours.add(connection.createQuery(template, "VALUES(4, 4, 0, TO_DATE('2017/06/04', 'yyyy/mm/dd'), " +
                "TO_DATE('2017/07/04', 'yyyy/mm/dd'))"));
        connection.insert(tours);
    }

    public void insertTourActors(){
        List<String> tourActors = new LinkedList<>();
        String template = "INSERT INTO toureActor(toureActor_id, toure_id, actor_id ) ";
        tourActors.add(connection.createQuery(template, "VALUES(0, 0, 0)"));
        tourActors.add(connection.createQuery(template, "VALUES(1, 1, 1)"));
        tourActors.add(connection.createQuery(template, "VALUES(2, 2, 2)"));
        tourActors.add(connection.createQuery(template, "VALUES(3, 3, 3)"));
        tourActors.add(connection.createQuery(template, "VALUES(4, 4, 4)"));
        connection.insert(tourActors);
    }
    public void insertTourProducer(){
        List<String> tourProducer = new LinkedList<>();
        String template = "INSERT INTO toureProducer(toureProducer_id, toure_id, producer_id ) ";
        tourProducer.add(connection.createQuery(template, "VALUES(0, 0, 0)"));
        tourProducer.add(connection.createQuery(template, "VALUES(1, 1, 1)"));
        tourProducer.add(connection.createQuery(template, "VALUES(2, 2, 2)"));
        tourProducer.add(connection.createQuery(template, "VALUES(3, 3, 3)"));
        tourProducer.add(connection.createQuery(template, "VALUES(4, 4, 4)"));
        connection.insert(tourProducer);
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
}
