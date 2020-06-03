package dao.inserts;

import dao.Connection;

import java.util.LinkedList;
import java.util.List;

public class InsertCharacteristics {

    private Connection connection;

    public InsertCharacteristics(Connection connection){
        this.connection = connection;
    }

    public void insert(){
        List<String> characteristicsList = new LinkedList<>();
//        String template = "INSERT INTO characteristics(gender, date_bd, voice, height, start_work, child, salary) ";
//        characteristicsList.add(connection.createQuery(template ,"VALUES(2, 1, TO_DATE('1975/10/01', 'yyyy/mm/dd'), 'сопрано', 170," +
//                " TO_DATE('1988/01/01', 'yyyy/mm/dd'), 0, 15000)"));
//        characteristicsList.add(connection.createQuery(template + "VALUES(3, 0, TO_DATE('1940/06/19', 'yyyy/mm/dd'), 'меццо-сопрано', 170," +
//                " TO_DATE('1965/01/01', 'yyyy/mm/dd'), 1, 25000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(4, 1, TO_DATE('1940/06/19', 'yyyy/mm/dd'), 'контральто', 161," +
//                " TO_DATE('1965/01/01', 'yyyy/mm/dd'), 2, 30000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(5, 0, TO_DATE('1950/06/19', 'yyyy/mm/dd'), 'тенор', 195," +
//                " TO_DATE('1975/01/01', 'yyyy/mm/dd'), 3, 40000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(6, 1, TO_DATE('1960/06/19', 'yyyy/mm/dd'), 'баритон', 185," +
//                " TO_DATE('1985/01/01', 'yyyy/mm/dd'), 4, 35000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(7, 0, TO_DATE('1970/06/19', 'yyyy/mm/dd'), 'бас', 175," +
//                " TO_DATE('1985/01/01', 'yyyy/mm/dd'), 5, 40000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(8, 1, TO_DATE('1980/06/19', 'yyyy/mm/dd'), 'сопрано', 165," +
//                " TO_DATE('1995/01/01', 'yyyy/mm/dd'), 0, 45000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(9, 0, TO_DATE('1990/06/19', 'yyyy/mm/dd'), 'меццо-сопрано', 160," +
//                " TO_DATE('2010/01/01', 'yyyy/mm/dd'), 1, 50000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(10, 1, TO_DATE('2000/06/19', 'yyyy/mm/dd'), 'контральто', 190," +
//                " TO_DATE('2017/01/01', 'yyyy/mm/dd'), 2, 55000)");
//        characteristicsList.add(connection.createQuery(template + "VALUES(11, 0, TO_DATE('1999/06/19', 'yyyy/mm/dd'), 'баритон', 180," +
//                " TO_DATE('2018/01/01', 'yyyy/mm/dd'), 3, 60000)");
//        characteristicsList.add(connection.createQuery(VALUES(12, 0, TO_DATE('1960/01/03', 'yyyy/mm/dd'), 'сопрано', 170," +
//                        " TO_DATE('1989/01/01', 'yyyy/mm/dd'), 0, 15000)");
//        characteristicsList.add(connection.createQuery(VALUES(13, 1, TO_DATE('1950/01/03', 'yyyy/mm/dd'), 'меццо-сопрано', 180," +
//                " TO_DATE('1968/01/01', 'yyyy/mm/dd'), 1, 20000)");
//        characteristicsList.add(connection.createQuery(VALUES(14, 0, TO_DATE('1970/01/03', 'yyyy/mm/dd'), 'контральто', 190," +
//                " TO_DATE('1988/01/01', 'yyyy/mm/dd'), 0, 30000)");
//        characteristicsList.add(connection.createQuery(VALUES(15, 1, TO_DATE('1980/01/03', 'yyyy/mm/dd'), 'баритон', 160," +
//                " TO_DATE('1998/01/01', 'yyyy/mm/dd'), 1, 50000)");
//        characteristicsList.add(connection.createQuery(VALUES(16, 0, TO_DATE('1990/01/03', 'yyyy/mm/dd'), 'бас', 170," +
//                " TO_DATE('1999/01/01', 'yyyy/mm/dd'), 0, 60000)");
//        characteristicsList.add(connection.createQuery(VALUES(17, 1, TO_DATE('1999/01/03', 'yyyy/mm/dd'), 'сопрано', 171," +
//                " TO_DATE('2018/01/01', 'yyyy/mm/dd'), 1, 70000)");
//        characteristicsList.add("INSERT INTO characteristics(characteristic_id, gender, date_bd, voice, height, start_work, " +
//                "child, salary) VALUES(18, 0, TO_DATE('2000/01/03', 'yyyy/mm/dd'), 'сопрано', 172," +
//                " TO_DATE('2020/01/01', 'yyyy/mm/dd'), 0, 15000)");
//        characteristicsList.add("INSERT INTO characteristics(characteristic_id, gender, date_bd, voice, height, start_work, " +
//                "child, salary) VALUES(19, 1, TO_DATE('1961/01/03', 'yyyy/mm/dd'), 'сопрано', 173," +
//                " TO_DATE('1988/01/01', 'yyyy/mm/dd'), 1, 16000)");
//        characteristicsList.add("INSERT INTO characteristics(characteristic_id, gender, date_bd, voice, height, start_work, " +
//                "child, salary) VALUES(20, 0, TO_DATE('1962/01/03', 'yyyy/mm/dd'), 'сопрано', 174," +
//                " TO_DATE('1978/01/01', 'yyyy/mm/dd'), 0, 17000)");
//        characteristicsList.add("INSERT INTO characteristics(characteristic_id, gender, date_bd, voice, height, start_work, " +
//                "child, salary) VALUES(21, 1, TO_DATE('1963/01/03', 'yyyy/mm/dd'), 'сопрано', 175," +
//                " TO_DATE('1988/01/01', 'yyyy/mm/dd'), 1, 18000)");
//        characteristicsList.add(connection.createQuery(template, "VALUES(22, 0, TO_DATE('1963/01/03', 'yyyy/mm/dd'), 'сопрано', 175, " +
//                "TO_DATE('1988/01/01', 'yyyy/mm/dd'), 1, 18000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(23, 1, TO_DATE('1966/06/27', 'yyyy/mm/dd'), 'меццо-сопрано', 160, " +
//                "TO_DATE('1998/01/01', 'yyyy/mm/dd'), 0, 28000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(24, 0, TO_DATE('1928/07/07', 'yyyy/mm/dd'), 'сопрано', 165, " +
//                "TO_DATE('1989/01/01', 'yyyy/mm/dd'), 2, 38000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(25, 1, TO_DATE('1936/01/28', 'yyyy/mm/dd'), 'бас', 170, " +
//                "TO_DATE('1990/01/01', 'yyyy/mm/dd'), 3, 48000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(26, 0, TO_DATE('1935/12/01', 'yyyy/mm/dd'), 'сопрано', 180, " +
//                "TO_DATE('1991/01/01', 'yyyy/mm/dd'), 4, 58000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(27, 1, TO_DATE('1978/02/09', 'yyyy/mm/dd'), 'баритон', 185, " +
//                "TO_DATE('1992/01/01', 'yyyy/mm/dd'), 0, 68000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(28, 0, TO_DATE('1976/02/15', 'yyyy/mm/dd'), 'сопрано', 190, " +
//                "TO_DATE('1993/01/01', 'yyyy/mm/dd'), 1, 78000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(29, 1, TO_DATE('1952/10/14', 'yyyy/mm/dd'), 'контральто', 171, " +
//                "TO_DATE('1994/01/01', 'yyyy/mm/dd'), 2, 88000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(30, 0, TO_DATE('1923/04/17', 'yyyy/mm/dd'), 'сопрано', 172, " +
//                "TO_DATE('1995/01/01', 'yyyy/mm/dd'), 3, 98000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(31, 1, TO_DATE('1947/06/05', 'yyyy/mm/dd'), 'меццо-сопрано', 173, " +
//                "TO_DATE('1996/01/01', 'yyyy/mm/dd'), 4, 19000)"));
//
//        characteristicsList.add(connection.createQuery(template, "VALUES(32, 0, TO_DATE('1950/02/04', 'yyyy/mm/dd'), 'сопрано', 175, " +
//                "TO_DATE('1988/01/01', 'yyyy/mm/dd'), 1, 18000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(33, 1, TO_DATE('1980/07/10', 'yyyy/mm/dd'), 'меццо-сопрано', 160, " +
//                "TO_DATE('1998/01/01', 'yyyy/mm/dd'), 0, 28000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(34, 0, TO_DATE('1936/08/28', 'yyyy/mm/dd'), 'сопрано', 165, " +
//                "TO_DATE('1989/01/01', 'yyyy/mm/dd'), 2, 38000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(35, 1, TO_DATE('1957/09/19', 'yyyy/mm/dd'), 'бас', 170, " +
//                "TO_DATE('1990/01/01', 'yyyy/mm/dd'), 3, 48000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(36, 0, TO_DATE('1971/04/19', 'yyyy/mm/dd'), 'сопрано', 180, " +
//                "TO_DATE('1991/01/01', 'yyyy/mm/dd'), 4, 58000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(37, 1, TO_DATE('1975/02/28', 'yyyy/mm/dd'), 'баритон', 185, " +
//                "TO_DATE('1992/01/01', 'yyyy/mm/dd'), 0, 68000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(38, 0, TO_DATE('1945/02/25', 'yyyy/mm/dd'), 'сопрано', 190, " +
//                "TO_DATE('1993/01/01', 'yyyy/mm/dd'), 1, 78000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(39, 1, TO_DATE('1952/04/30', 'yyyy/mm/dd'), 'контральто', 171, " +
//                "TO_DATE('1994/01/01', 'yyyy/mm/dd'), 2, 88000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(40, 0, TO_DATE('1938/02/28', 'yyyy/mm/dd'), 'сопрано', 172, " +
//                "TO_DATE('1995/01/01', 'yyyy/mm/dd'), 3, 98000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(41, 1, TO_DATE('1953/07/20', 'yyyy/mm/dd'), 'меццо-сопрано', 173, " +
//                "TO_DATE('1996/01/01', 'yyyy/mm/dd'), 4, 19000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(42, 0, TO_DATE('1930/02/04', 'yyyy/mm/dd'), 'сопрано', 175, " +
//                "TO_DATE('1988/01/01', 'yyyy/mm/dd'), 1, 18000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(43, 1, TO_DATE('1918/07/10', 'yyyy/mm/dd'), 'меццо-сопрано', 160, " +
//                "TO_DATE('1998/01/01', 'yyyy/mm/dd'), 0, 28000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(44, 0, TO_DATE('1933/08/28', 'yyyy/mm/dd'), 'сопрано', 165, " +
//                "TO_DATE('1989/01/01', 'yyyy/mm/dd'), 2, 38000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(45, 1, TO_DATE('1908/09/19', 'yyyy/mm/dd'), 'бас', 170, " +
//                "TO_DATE('1990/01/01', 'yyyy/mm/dd'), 3, 48000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(46, 0, TO_DATE('1929/04/19', 'yyyy/mm/dd'), 'сопрано', 180, " +
//                "TO_DATE('1991/01/01', 'yyyy/mm/dd'), 4, 58000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(47, 1, TO_DATE('1955/02/28', 'yyyy/mm/dd'), 'баритон', 185, " +
//                "TO_DATE('1992/01/01', 'yyyy/mm/dd'), 0, 68000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(48, 0, TO_DATE('1925/02/25', 'yyyy/mm/dd'), 'сопрано', 190, " +
//                "TO_DATE('1993/01/01', 'yyyy/mm/dd'), 1, 78000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(49, 1, TO_DATE('1914/04/30', 'yyyy/mm/dd'), 'контральто', 171, " +
//                "TO_DATE('1994/01/01', 'yyyy/mm/dd'), 2, 88000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(50, 0, TO_DATE('1943/02/28', 'yyyy/mm/dd'), 'сопрано', 172, " +
//                "TO_DATE('1995/01/01', 'yyyy/mm/dd'), 3, 98000)"));
//        characteristicsList.add(connection.createQuery(template, "VALUES(51, 1, TO_DATE('1927/07/20', 'yyyy/mm/dd'), 'меццо-сопрано', 173, " +
//                "TO_DATE('1996/01/01', 'yyyy/mm/dd'), 4, 19000)"));
        connection.insert(characteristicsList);
    }

    public int insert(int gender, String dateDb, String voice, int height, String startWorkDate, int child, int salary) {
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
}
