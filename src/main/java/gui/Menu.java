package gui;

import dao.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Menu
{
    private JButton humanResourcesWorker, exit, scheduleManager, brochureMaker, producer;
    private Connection connection;
    private HRForms hrForms;


    public Menu(Connection connection)
    {
        this.connection = connection;
        hrForms = new HRForms();
        JLabel title = new JLabel("Выберите свою роль");
        humanResourcesWorker = new JButton("Работник отдела кадров");
        exit = new JButton("Выход");
        scheduleManager = new JButton("Менеджер расписания");
        brochureMaker = new JButton("Составитель брошюр");
        producer = new JButton("Постановщик");
    }



    public void initPressHRWorkers(){
            JButton allWorkers = new JButton("Получить список всех сотрудников");
            allWorkers.addActionListener((ActionEvent action) -> hrForms.allWorkers());

            JButton allPerformance = new JButton("Получить список всех спектакле, в которых участвовал данный актёр");
            allPerformance.addActionListener((ActionEvent action) -> hrForms.selectPerformanceByName());

            JButton actorReward = new JButton("Получить список актёров, имеющих звания");
            actorReward.addActionListener((ActionEvent action) -> hrForms.actorReward());

            JButton actorProducer = new JButton("Получить список всех актёров и постановщиков");
            actorProducer.addActionListener((ActionEvent action) -> hrForms.actorProducer());

            List<Component> componentList = new LinkedList<>();
            componentList.add(allWorkers);
            componentList.add(allPerformance);
            componentList.add(actorReward);
            componentList.add(actorProducer);
            ButtonMethods.setFrameParameters("Работник отдела кадров", 500, 400, componentList);
    }

    private void initPressExit(){
        exit.addActionListener((ActionEvent e) -> {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });
    }

    public void initPressSchedule(){
            JButton allPerformance = new JButton("Даты спектаклей");
            allPerformance.addActionListener((ActionEvent action) -> {
                    ButtonMethods.selectFromDb(allPerformance.getText(),
                            "SELECT performances.name, performances.performance_date " +
                                    "FROM performances", (resultSet -> {
                                try {
                                    List<String> res = new LinkedList<>();
                                    res.add(resultSet.getString(1));
                                    res.add(resultSet.getString(2));
                                    return res;
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                                return null;
                            }));
            });
            JButton performancesCount = new JButton("Количество всех спектаклей");
            performancesCount.addActionListener((ActionEvent action) -> {
                ButtonMethods.selectFromDb(performancesCount.getText(),
                        "SELECT COUNT(*) FROM performances");
            });
            JButton lastPerformances = new JButton("Уже сыгранные спектакли");
            lastPerformances.addActionListener((ActionEvent e) -> {
                ButtonMethods.selectFromDb(lastPerformances.getText(),
                        "SELECT performances.name " +
                                "FROM performances " +
                                "WHERE performances.performance_date < sysdate");
            });

            JButton performanceByGenre = new JButton("Спектакли указанного жанра");
            performanceByGenre.addActionListener((ActionEvent e) -> {
                ButtonMethods.selectByTextField("Введите жанр", performanceByGenre.getText(),
                        "SELECT performances.name " +
                                "FROM performances JOIN genres ON performances.genre_id = genres.genres_id " +
                                "WHERE genres.name LIKE ", false);
            });

            JButton performancesPeriod = new JButton("Спектакли за указанный период");
            performancesPeriod.addActionListener((ActionEvent e) -> {
                ButtonMethods.initPeriodAndGetActorsName(performancesPeriod.getText(),
                        "SELECT performances.name " +
                                "FROM performances " +
                                "WHERE performances.performance_date BETWEEN ");
            });

            List<Component> componentList = new LinkedList<>();
            componentList.add(allPerformance);
            componentList.add(performancesCount);
            componentList.add(lastPerformances);
            componentList.add(performanceByGenre);
            componentList.add(performancesPeriod);
            ButtonMethods.setFrameParameters("Менеджер расписания", 500, 400, componentList);
    }

    private List<String> makeString(int num, ResultSet resultSet)
    {
        List<String> res = new LinkedList<>();
        for(int i = 1; i <= num; ++i)
        {
            try {
                res.add(resultSet.getString(i));
                   // return res;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    return null;
                }

        }
        return res;
    }

    public void initPressBrochure(){
            JButton allAuthor = new JButton("Список всех авторов");
            allAuthor.addActionListener((ActionEvent action) -> {
                ButtonMethods.selectFromDb("Список всех авторов", "SELECT author.name FROM author");
            });

            JButton authorCentury = new JButton("Список авторов по векам");
            authorCentury.addActionListener((ActionEvent action) -> {
            ButtonMethods.selectByTextField("Введите век", authorCentury.getText(),
                    "SELECT author.name FROM author WHERE author.century = ", false);
            });

            JButton authorCountry = new JButton("Список авторов по странам");
            authorCountry.addActionListener((ActionEvent action) -> {
            ButtonMethods.selectByTextField("Введите страну", authorCountry.getText(), "SELECT author.name " +
                    "FROM author JOIN countries ON countries.country_id = author.country_id " +
                    "WHERE countries.name LIKE ",false);
            });

            JButton authorGenre = new JButton("Список авторов с постановками указанного жанра");
            authorGenre.addActionListener((ActionEvent e) -> {
                ButtonMethods.selectByTextField("Введите жанр", authorGenre.getText(),
                        "SELECT author.name " +
                                "FROM author JOIN performances ON performances.author_id = author.author_id " +
                                "JOIN genres ON genres.genres_id = performances.genre_id " +
                                "WHERE genres.name LIKE ", false);
            });

            JButton allPerformance = new JButton("Список всех спектаклей");
            allPerformance.addActionListener((ActionEvent action) -> {
                ButtonMethods.selectFromDb("Список всех спектаклей",
                        "SELECT performances.name FROM performances");
            });

            JButton performanceInfo = new JButton("Информация о спектакле");
            performanceInfo.addActionListener((ActionEvent action) -> {
                ButtonMethods.selectByTextField("Введите название спектакля", "Информация о спектакле",
                        ButtonMethods.loadResourceFile("selects/selectAllPerformanceData.sql"),
                        (resultSet -> {
                            return makeString(9, resultSet);
                        }), false);
            });

            JButton authorPeriod = new JButton("Список авторов за указанный период");
            authorPeriod.addActionListener((ActionEvent e) -> {
                ButtonMethods.initPeriodAndGetActorsName(authorPeriod.getText(),
                        "SELECT author.name " +
                                "FROM author JOIN performances ON performances.author_id = author.author_id " +
                                "WHERE performances.performance_date BETWEEN ");
            });

            List<Component> componentList = new LinkedList<>();
            componentList.add(allPerformance);
            componentList.add(allAuthor);
            componentList.add(authorCentury);
            componentList.add(authorCountry);
            componentList.add(authorGenre);
            componentList.add(authorPeriod);
            componentList.add(performanceInfo);
            ButtonMethods.setFrameParameters("Составитель брошюр", 500, 400, componentList);
    }
    public void initPressProducer(){
            ButtonMethods.selectByTextField("Введите роль", "Подходящий актёр",
                    "SELECT workers.name " +
                    "FROM workers " +
                    "JOIN actors ON actors.worker_id = workers.worker_id " +
                    "JOIN roles ON roles.actor_id = actors.actor_id " +
                    "JOIN characteristics ON roles.characteristic_id = characteristics.characteristic_id " +
                    "WHERE roles.name LIKE ", false);
    }

    public void initPressDirector() {
        DirectorForm directorForm = new DirectorForm(connection);
        directorForm.initPressDirector();
    }

    public void initPress(){
        initPressExit();
        initPressHRWorkers();
        initPressSchedule();
        initPressBrochure();
        initPressProducer();
    }

}
