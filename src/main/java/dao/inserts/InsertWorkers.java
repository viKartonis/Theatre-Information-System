package dao.inserts;

import dao.Connection;

import java.util.LinkedList;
import java.util.List;

public class InsertWorkers {

    private Connection connection;

    public InsertWorkers(Connection connection){
        this.connection = connection;
    }

    public void insert(){
        List<String> workersList = new LinkedList<>();
        String template = "INSERT INTO workers(worker_id, name, characteristic_id) ";
        String worker1 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(0, 'Снигирь Юлия', 12)";
        String worker2 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(1, 'Чулпан Хаматова', 13)";
        String worker3 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(2, 'Евгения Уралова', 14)";
        String worker4 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(3, 'Александра Родина', 15)";
        String worker5 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(4, 'Юлия Пересильд', 16)";
        String worker6 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(5, 'Маврина Юлия', 17)";
        String worker7 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(6, 'Медина Ольга', 18)";
        String worker8 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(7, 'Андоленко Карина', 19)";
        String worker9 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(8, 'Александр Романцов', 20)";
        String worker10 = "INSERT INTO workers(worker_id, name, characteristic_id) VALUES(9, 'Валерий Кузин', 21)";

        workersList.add(connection.createQuery(template, "VALUES(20, 'ПОЛ ТОМАС АНДЕРСОН', 22)"));
        workersList.add(connection.createQuery(template, "VALUES(21, 'МАЙЯ АНЖЕЛУ', 23)"));
        workersList.add(connection.createQuery(template, "VALUES(22, 'ДАНИЭЛ АНКЕР', 24)"));
        workersList.add(connection.createQuery(template, "VALUES(23, 'КЕЙТ БАРКЕР-ФРЕЙЛАНД', 25)"));
        workersList.add(connection.createQuery(template, "VALUES(24, 'ПЭРИС БАРКЛЭЙ', 26)"));
        workersList.add(connection.createQuery(template, "VALUES(25, 'ТРОЙЭН БЕЛЛИСАРИО', 27)"));
        workersList.add(connection.createQuery(template, "VALUES(26, 'ДЖЕК БЕНДЕР', 28)"));
        workersList.add(connection.createQuery(template, "VALUES(27, 'АНДРЕА БЕРЛОФФ', 29)"));
        workersList.add(connection.createQuery(template, "VALUES(28, 'ЭДВАРД БЕРНС', 30)"));
        workersList.add(connection.createQuery(template, "VALUES(29, 'КЭТРИН БИГЕЛОУ', 31)"));

        workersList.add(connection.createQuery(template, "VALUES(30, 'СЕРГЕЙ АЙНУТДИНОВ', 32)"));
        workersList.add(connection.createQuery(template, "VALUES(31, 'ИРИНА АКИМОВА', 33)"));
        workersList.add(connection.createQuery(template, "VALUES(32, 'АЛЕКСЕЙ АКСЁНОВ', 34)"));
        workersList.add(connection.createQuery(template, "VALUES(33, 'АВДОТЬЯ АЛЕКСАНДРОВА', 35)"));
        workersList.add(connection.createQuery(template, "VALUES(34, 'РОМАН АЛЕКСАШЕВ', 36)"));
        workersList.add(connection.createQuery(template, "VALUES(35, 'ИРИНА АЛЕКСЕЕВА', 37)"));
        workersList.add(connection.createQuery(template, "VALUES(36, 'СЕРГЕЙ АЛИБЕКОВ', 38)"));
        workersList.add(connection.createQuery(template, "VALUES(37, 'ЕЛЕНА АМШИНСКАЯ', 39)"));
        workersList.add(connection.createQuery(template, "VALUES(38, 'РОМАН АНИСИМОВ', 40)"));
        workersList.add(connection.createQuery(template, "VALUES(39, 'АЛЕКСАНДРА АНТОНОВА', 41)"));

        workersList.add(connection.createQuery(template, "VALUES(40, 'Карлос Клайбер', 32)"));
        workersList.add(connection.createQuery(template, "VALUES(41, 'Абдурахманова Дильбар Гулямовна', 33)"));
        workersList.add(connection.createQuery(template, "VALUES(42, 'Клаудио Аббадо', 34)"));
        workersList.add(connection.createQuery(template, "VALUES(43, 'Аим Эммануэль', 35)"));
        workersList.add(connection.createQuery(template, "VALUES(44, 'Леонард Бернстайн', 36)"));
        workersList.add(connection.createQuery(template, "VALUES(45, 'Белинфанте Фрида', 37)"));
        workersList.add(connection.createQuery(template, "VALUES(46, 'Герберт фон Караян', 38)"));
        workersList.add(connection.createQuery(template, "VALUES(47, 'Бройнинг-Сторм Гунна', 39)"));
        workersList.add(connection.createQuery(template, "VALUES(48, 'Николаус Арнонкур ', 40)"));
        workersList.add(connection.createQuery(template, "VALUES(49, 'Буланже Надя', 41)"));

//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(10, 'Абряров Шамиль', 12)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(11, 'Анастасия', 13)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(12, 'Анчаров Михаил', 14)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(13, 'Добржанская Любовь', 15)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(14, 'Дольский Александр', 16)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(15, 'Дягилева Янка', 17)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(16, 'Есипов Борис', 18)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(17, 'Захарченко Любовь', 19)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(18, 'Зыков Юрий', 20)");
//        workersList.add("INSERT INTO workers(worker_id, name, characteristic_id) VALUES(19, 'Игнатова Елена', 21)");

        connection.insert(workersList);
    }

    public int insert(String name, int characteristicId) {
        List<String> workersList = new LinkedList<>();
        workersList.add("INSERT INTO workers(name, characteristic_id) VALUES('" + name + "', " +
                characteristicId + ")");
        connection.insert(workersList);
        List<List<String>> chars = connection.select("SELECT workers.worker_id FROM workers");

        return Integer.parseInt(chars.get(chars.size() - 1).get(0));
    }
}
