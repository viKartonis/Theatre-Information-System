package gui;

import dao.Connection;
import dao.InsertInto;
import gui.menuItems.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

public class DirectorForm {

    private Connection connection;
    private InsertInto insertInto;


    public DirectorForm(Connection connection) {
        this.connection = connection;
        insertInto = new InsertInto(connection);
    }

    private int selects(String query)
    {
        return Integer.valueOf(connection.select(query).get(0).get(0));
    }

    private List<String> selectList(String query)
    {
        List<List<String>> list = connection.select(query);
        List<String> names = new LinkedList<>();
        for(int i = 0; i < list.size(); ++i)
        {
            names.add(list.get(i).get(0));
        }
        return names;
    }

    private void initPressAddPerformance() {
        JLabel performanceName = new JLabel("Название спектакля");
        JLabel producer = new JLabel("");
        JLabel productorDesigner = new JLabel("");
        JLabel performanceCategory = new JLabel("");
        JLabel coast = new JLabel("Стоимость");
        JLabel conductor = new JLabel("");
        JLabel author = new JLabel("");
        JLabel isPremier = new JLabel("Премьера?");
        JLabel date = new JLabel("Дата в формате гггг/мм/дд");
        JLabel genre = new JLabel("");

        JTextField performanceNameText = new JTextField();
        MenuProducer producerMenu = new MenuProducer(selectList("SELECT workers.name FROM workers JOIN producers" +
                " ON workers.worker_id = producers.worker_id"), producer);

        MenuProductorDesigner designer = new MenuProductorDesigner(
                selectList("SELECT workers.name FROM workers JOIN productor_designers" +
                " ON workers.worker_id = productor_designers.worker_id"), productorDesigner);
        MenuPerformanceCategory performanceCategoryMenu = new MenuPerformanceCategory(
                selectList("SELECT performance_categories.name FROM performance_categories"), performanceCategory);
        JTextField coastText = new JTextField();
        MenuConductors conductors = new MenuConductors(selectList("SELECT workers.name FROM workers JOIN conductors" +
                " ON workers.worker_id = conductors.worker_id"),conductor);
        MenuAuthor menuAuthor = new MenuAuthor(selectList("SELECT author.name FROM author"), author);
        JTextField isPremierText = new JTextField();
        JTextField dateText = new JTextField();
        MenuGenres menuGenres = new MenuGenres(selectList("SELECT genres.name FROM genres"), genre);

        java.util.List<Component> componentList = new LinkedList<>();
        componentList.add(performanceName);
        componentList.add(performanceNameText);
        componentList.add(coast);
        componentList.add(coastText);
        componentList.add(isPremier);
        componentList.add(isPremierText);
        componentList.add(date);
        componentList.add(dateText);


        componentList.add(producerMenu.getRole());
        componentList.add(producer);
        componentList.add(designer.getRole());
        componentList.add(productorDesigner);
        componentList.add(performanceCategoryMenu.getRole());
        componentList.add(performanceCategory);


        componentList.add(conductors.getRole());
        componentList.add(conductor);

        componentList.add(menuAuthor.getRole());
        componentList.add(author);

        componentList.add(menuGenres.getRole());
        componentList.add(genre);

        JButton next = new JButton("Далее");
        componentList.add(next);
        JFrame frame = ButtonMethods.setFrameParameters("Добавление спектакля", 500, 400, componentList);


        next.addActionListener((ActionEvent event) -> {
            int producer_id = selects("SELECT producer_id FROM producers " +
                    "JOIN workers ON workers.worker_id = producers.worker_id " +
                    "WHERE workers.name LIKE '" + producerMenu.getProducerName() + "'");

            int productorDesigner_id = selects("SELECT PRODUCTOR_DESIGNERS_ID FROM productor_designers " +
                    "JOIN workers ON workers.worker_id = productor_designers.worker_id " +
                    "WHERE workers.name LIKE '" + designer.getName() + "'");

            int performanceCategoryId = selects("SELECT performance_category_id FROM performance_categories " +
                    "WHERE performance_categories.name LIKE '" + performanceCategoryMenu.getName() + "'");

            int conductorId = selects("SELECT conductor_id FROM conductors " +
                    "JOIN workers ON workers.worker_id = conductors.worker_id " +
                    "WHERE workers.name LIKE '" + conductors.getName() + "'");

            int authorId = selects("SELECT author_id FROM author WHERE author.name LIKE '" + menuAuthor.getName() + "'");

            int genreId = selects("SELECT genres_id FROM genres WHERE genres.name LIKE '" + menuGenres.getName() + "'");

            insertInto.insertPerformance(performanceNameText.getText(), producer_id, productorDesigner_id, performanceCategoryId,
                    Integer.valueOf(coastText.getText()), conductorId, authorId, isPremierText.getText().equals("Да") ? 1 : 0,
                    dateText.getText(), genreId);
            System.out.println("INSERT");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }


    private void initPressDeletePerformance() {
        JLabel inputLabel = new JLabel("Введите название спектакля");
        JTextArea inputText = new JTextArea();
        JButton inputNext = new JButton("Далее");
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(inputText);
        componentList.add(inputNext);
        JFrame frame = ButtonMethods.setFrameParameters("Удаление спектакля из репертуара", 250, 100, componentList);
        inputNext.addActionListener((ActionEvent event) -> {
            connection.delete("DELETE FROM performances WHERE performances.name LIKE '" + inputText.getText() + "'");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }

    private void initPressProfit(){
        JLabel inputLabel = new JLabel("Введите название спектакля");
        JTextArea inputText = new JTextArea();
        JButton inputNext = new JButton("Далее");
        JLabel coast = new JLabel();
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(inputText);
        componentList.add(coast);
        componentList.add(inputNext);
        ButtonMethods.setFrameParameters("Прибыль со спектакля", 250, 100, componentList);
        inputNext.addActionListener((ActionEvent event) -> {
           int money =  selects("SELECT performances.sales*performances.coast " +
                    "    FROM performances " +
                    "    WHERE performances.name LIKE '" + inputText.getText() + "'");
            coast.setText(String.valueOf(money));
        });
    }

    private void initPressSoldTickets() {
        JLabel inputLabel = new JLabel("Введите название спектакля");
        JTextArea inputText = new JTextArea();
        JButton inputNext = new JButton("Далее");
        JLabel coast = new JLabel();
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(inputText);
        componentList.add(coast);
        componentList.add(inputNext);
        ButtonMethods.setFrameParameters("Количество проданных билетов", 250, 100, componentList);
        inputNext.addActionListener((ActionEvent event) -> {
            int money =  selects("SELECT performances.sales " +
                    "    FROM performances " +
                    "    WHERE performances.name LIKE '" + inputText.getText() + "'");
            coast.setText(money + "/200");
        });
    }


    private void addWorkers(){
        JLabel name = new JLabel("Введите имя");
        JLabel gender = new JLabel("");
        JLabel date_bd = new JLabel("Введите дату рождения в формате гггг/мм/дд");
        JLabel voice = new JLabel("");
        JLabel height = new JLabel("Введите рост");
        JLabel start_work = new JLabel("Введите дату приёма на работу в формате гггг/мм/дд");
        JLabel child = new JLabel("Введите количество детей");
        JLabel salary = new JLabel("Введите зарплату");
        JLabel isStudent = new JLabel("Студент?");
        JLabel position = new JLabel("");

        JTextField nameText = new JTextField();
        MenuGender genderMenu = new MenuGender(gender);
        JTextField date_bdText = new JTextField();
        MenuVoice voiceMenu = new MenuVoice(selectList("SELECT DISTINCT characteristics.voice FROM characteristics"), voice);
        JTextField heightText = new JTextField();
        JTextField start_workText = new JTextField();
        JTextField childText = new JTextField();
        JTextField salaryText = new JTextField();
        JTextField isStudentText = new JTextField();
        MenuPosition positionMenu = new MenuPosition(position);

        JButton next = new JButton("Далее");

        java.util.List<Component> componentList = new LinkedList<>();
        componentList.add(name);
        componentList.add(nameText);

        componentList.add(date_bd);
        componentList.add(date_bdText);

        componentList.add(height);
        componentList.add(heightText);
        componentList.add(start_work);
        componentList.add(start_workText);
        componentList.add(child);
        componentList.add(childText);
        componentList.add(salary);
        componentList.add(salaryText);
        componentList.add(isStudent);
        componentList.add(isStudentText);
        componentList.add(positionMenu.getRole());
        componentList.add(position);
        componentList.add(genderMenu.getRole());
        componentList.add(gender);
        componentList.add(voiceMenu.getRole());
        componentList.add(voice);
        componentList.add(next);
        JFrame frame = ButtonMethods.setFrameParameters("Добавление работника", 500, 400, componentList);
        next.addActionListener((ActionEvent event) -> {
            int characteristicId =insertInto.insertCharacteristics(genderMenu.getName().equals("Мужской") ? 0 : 1, date_bdText.getText(), voiceMenu.getName(),
                    Integer.valueOf(heightText.getText()), start_workText.getText(), Integer.valueOf(childText.getText()),
                    Integer.valueOf(salaryText.getText()));
            int workerId = insertInto.insertWorker(nameText.getText(), characteristicId);
            InsertInto insertInto = new InsertInto(connection);
            switch (positionMenu.getName()) {
                case "Актёр" : {
                    insertInto.insertActor(workerId, isStudentText.getText().equals("Да") ? 1 : 0);
                    break;
                }
                case "Постановщик" : {
                    insertInto.insertProducer(workerId);
                    break;
                }
                case "Музыкант" : {
                    insertInto.insertMusician(workerId);
                    break;
                }
                case "Дирижёр" : {
                    insertInto.insertConductor(workerId);
                    break;
                }
                case "Художник-постановщик" : {
                    insertInto.insertDesigner(workerId);
                    break;
                }
            }
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }

    private void deleteWorkers() {
        JLabel inputLabel = new JLabel("Введите имя рабочего");
        JTextArea inputText = new JTextArea();
        JButton inputNext = new JButton("Далее");
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(inputText);
        componentList.add(inputNext);
        JFrame frame = ButtonMethods.setFrameParameters("Увольнение рабочего", 250, 100, componentList);
        inputNext.addActionListener((ActionEvent event) -> {
            connection.delete("DELETE FROM actors WHERE actors.worker_id IN " +
            "(SELECT workers.worker_id FROM workers WHERE workers.name LIKE ' " + inputText.getText() + "')");
            connection.delete("DELETE FROM producers WHERE producers.worker_id IN " +
                    "(SELECT workers.worker_id FROM workers WHERE workers.name LIKE ' " + inputText.getText() + "')");
            connection.delete("DELETE FROM conductors WHERE conductors.worker_id IN " +
                    "(SELECT workers.worker_id FROM workers WHERE workers.name LIKE ' " + inputText.getText() + "')");
            connection.delete("DELETE FROM productor_designers WHERE productor_designers.worker_id IN " +
                    "(SELECT workers.worker_id FROM workers WHERE workers.name LIKE ' " + inputText.getText() + "')");
            connection.delete("DELETE FROM musician WHERE musician.worker_id IN " +
                    "(SELECT workers.worker_id FROM workers WHERE workers.name LIKE ' " + inputText.getText() + "')");

            connection.delete("DELETE FROM workers WHERE workers.name LIKE '" + "'");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });
    }

    private void initPressWorkersControl() {
        JButton add = new JButton("Добавление работника");
        add.addActionListener((ActionEvent event) -> {
            addWorkers();
        });

        JButton delete = new JButton("Удаление работника");
        delete.addActionListener((ActionEvent e) -> {
            deleteWorkers();
        });

        java.util.List<Component> componentList = new LinkedList<>();
        componentList.add(add);
        componentList.add(delete);
        ButtonMethods.setFrameParameters("Контроль за работниками", 500, 400, componentList);
    }


    private void initPressPerformanceControl() {
        JButton add = new JButton("Добавление спектакля");
        add.addActionListener((ActionEvent event) -> {
            initPressAddPerformance();
        });

        JButton delete = new JButton("Удаление спектакля");
        delete.addActionListener((ActionEvent e) -> {
            initPressDeletePerformance();
        });

        JButton profit = new JButton("Прибыль со спектакля");
        profit.addActionListener((ActionEvent e) -> {
            initPressProfit();
        });

        JButton sold = new JButton("Количество проданных билетов");
        sold.addActionListener((ActionEvent e) -> {
            initPressSoldTickets();
        });

        java.util.List<Component> componentList = new LinkedList<>();
        componentList.add(add);
        componentList.add(delete);
        componentList.add(profit);
        componentList.add(sold);
        ButtonMethods.setFrameParameters("Контроль за постановками", 500, 400, componentList);
    }

    public void initPressDirector() {
        JButton performanceControl = new JButton("Контроль за постановками");
        performanceControl.addActionListener((ActionEvent e) -> {
            initPressPerformanceControl();
        });
        JButton workersControl = new JButton("Контроль за работниками");
        workersControl.addActionListener((ActionEvent e) -> {
            initPressWorkersControl();
        });

        List<Component> componentList = new LinkedList<>();
        componentList.add(performanceControl);
        componentList.add(workersControl);
        ButtonMethods.setFrameParameters("Директор", 500, 400, componentList);
    }
}
