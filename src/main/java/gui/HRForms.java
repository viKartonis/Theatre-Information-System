package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HRForms {

    public void allWorkers(){
            JButton actors, musician, years, experience, hasChild, salary, gender;
            actors = new JButton("Список всех актёров");
            musician = new JButton("Список всех музыкантов");
            years = new JButton("Список работников по году рождения");
            experience = new JButton("Список работников по стажу работы");
            hasChild = new JButton("Список работников по наличию детей");
            salary = new JButton("Список работников по зарплате");
            gender = new JButton("Список работников по полу");
            List<Component> componentList = new LinkedList<>();
            componentList.add(actors);
            componentList.add(musician);
            componentList.add(years);
            componentList.add(experience);
            componentList.add(hasChild);
            componentList.add(salary);
            componentList.add(gender);
            ButtonMethods.setFrameParameters("Получить списки всех работников", 500, 400, componentList);

            actors.addActionListener((ActionEvent e) -> ButtonMethods.selectFromDb("Списки всех актёров",
                    "SELECT workers.name FROM workers JOIN actors ON workers.worker_id = actors.worker_id"));

            musician.addActionListener((ActionEvent e) -> ButtonMethods.selectFromDb("Списки всех музыкантов",
                    "SELECT workers.name FROM workers JOIN musician ON workers.worker_id = musician.worker_id"));

            years.addActionListener((ActionEvent e) -> ButtonMethods.selectByTextField("Введите год рождения работника", years.getText(),
                    "SELECT workers.name FROM workers JOIN characteristics" +
                            " ON workers.characteristic_id = characteristics.characteristic_id" +
                            " WHERE to_char(characteristics.date_bd, 'yyyy') LIKE ", false));

            experience.addActionListener((ActionEvent e) -> ButtonMethods.selectByTextField("Введите стаж работника", "Списки работников по стажу",
                    "SELECT workers.name FROM workers JOIN characteristics" +
                            " ON workers.characteristic_id = characteristics.characteristic_id " +
                            "WHERE TRUNC(months_between(sysdate, characteristics.start_work)/12) = ", false));

            hasChild.addActionListener((ActionEvent e) ->{
                JLabel inputLabel = new JLabel("Есть дети?");
                JButton yes = new JButton("Да");
                yes.addActionListener((ActionEvent event) -> {
                    ButtonMethods.selectFromDb("Списки работников c детьми",
                            "SELECT workers.name, characteristics.child  FROM workers JOIN characteristics" +
                                    " ON workers.characteristic_id = characteristics.characteristic_id" +
                                    " WHERE characteristics.child > 0", (resultSet -> {
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
                JButton no = new JButton("Нет");
                no.addActionListener((ActionEvent event) -> {
                    ButtonMethods.selectFromDb("Списки работников без детей",
                            "SELECT workers.name FROM workers JOIN characteristics" +
                                    " ON workers.characteristic_id = characteristics.characteristic_id" +
                                    " WHERE characteristics.child = 0");
                });
                List<Component> components = new LinkedList<>();
                components.add(inputLabel);
                components.add(yes);
                components.add(no);
                ButtonMethods.setFrameParameters("Списки работников с детьми", 250, 300, components);
            });
            salary.addActionListener((ActionEvent e) -> ButtonMethods.selectByTextField("Введите заработную плату работника",
                    "Список работников по заработной плате", "SELECT workers.name FROM workers JOIN characteristics " +
                            "ON workers.characteristic_id = characteristics.characteristic_id " +
                            "WHERE characteristics.salary = ", false));

            gender.addActionListener((ActionEvent e) ->{
                JLabel inputLabel = new JLabel("Пол");
                JButton yes = new JButton("Мужчина");

                yes.addActionListener((ActionEvent event) -> ButtonMethods.selectFromDb("Списки работников мужчин",
                        "SELECT workers.name FROM workers JOIN characteristics" +
                                " ON workers.characteristic_id = characteristics.characteristic_id" +
                                " WHERE characteristics.gender = 0"));

                JButton no = new JButton("Женщина");
                no.addActionListener((ActionEvent event) -> ButtonMethods.selectFromDb("Списки работников c детьми",
                        "SELECT workers.name, characteristics.child  FROM workers JOIN characteristics" +
                                " ON workers.characteristic_id = characteristics.characteristic_id" +
                                " WHERE characteristics.gender = 1"));

                List<Component> components = new LinkedList<>();
                components.add(inputLabel);
                components.add(yes);
                components.add(no);
                ButtonMethods.setFrameParameters("Список работников по полу", 250, 300, components);
            });
        }



    public void actorReward(){
        JButton period, competition, gender, age;
        period = new JButton("Список актёров, имеющих звания, за указанный период");
        competition = new JButton("Список актёров, имеющих звания, полученные на указанных конкурсах");
        age = new JButton("Список работников по возрасту");
        gender = new JButton("Список работников по полу");

        List<Component> components = new LinkedList<>();
        components.add(period);
        components.add(competition);
        components.add(age);
        components.add(gender);
        ButtonMethods.setFrameParameters("Список актёров, имеющих награды", 500, 400, components);

        period.addActionListener((ActionEvent e) -> ButtonMethods.initPeriodAndGetActorsName(
                "Список актёров, получивших нагады за указанный период",
                "SELECT workers.name FROM workers JOIN actors " +
                "ON workers.worker_id = actors.worker_id " +
                "JOIN rewards ON actors.reward_id = rewards.reward_id " +
                "WHERE rewards.date_b BETWEEN "));

        competition.addActionListener((ActionEvent e) -> ButtonMethods.selectByTextField("Введите название конкурса",
                "Список актёров с наградами, полученными на данном конкурсе",
                "SELECT workers.name FROM workers " +
                        "JOIN actors ON workers.worker_id = actors.worker_id " +
                        "JOIN rewards ON actors.reward_id = rewards.reward_id " +
                        "WHERE rewards.name LIKE ", false));

        age.addActionListener((ActionEvent e) ->{
            ButtonMethods.selectByTextField("Введите возраст",
                    "Список актёров с данным возрастом, имеющие награды",
                    "SELECT workers.name FROM workers " +
                            "JOIN actors ON workers.worker_id = actors.worker_id " +
                            "JOIN rewards ON actors.reward_id = rewards.reward_id " +
                            "JOIN characteristics ON characteristics.characteristic_id = workers.characteristic_id " +
                            "WHERE TRUNC(months_between(SYSDATE, characteristics.date_bd)/12) = ", false);
        });
        gender.addActionListener((ActionEvent e) ->{
            JLabel inputLabel = new JLabel("Пол");
            JButton yes = new JButton("Мужчина");

            yes.addActionListener((ActionEvent event) -> ButtonMethods.selectFromDb("Списки актёров мужчин, имеющих награды",
                    "SELECT workers.name FROM workers " +
                            "JOIN actors ON workers.worker_id = actors.worker_id " +
                            "JOIN rewards ON actors.reward_id = rewards.reward_id  " +
                            "JOIN characteristics ON characteristics.characteristic_id = workers.characteristic_id " +
                            " WHERE characteristics.gender = 0"));

            JButton no = new JButton("Женщина");
            no.addActionListener((ActionEvent event) -> ButtonMethods.selectFromDb("Списки актёров женщин, имеющих награды",
                    "SELECT workers.name FROM workers " +
                            "JOIN actors ON workers.worker_id = actors.worker_id " +
                            "JOIN rewards ON actors.reward_id = rewards.reward_id " +
                            "JOIN characteristics ON characteristics.characteristic_id = workers.characteristic_id " +
                            "WHERE characteristics.gender = 1"));

            List<Component> genderComponents = new LinkedList<>();
            genderComponents.add(inputLabel);
            genderComponents.add(yes);
            genderComponents.add(no);
            ButtonMethods.setFrameParameters("Список работников по полу, имеющих награды", 500, 400, genderComponents);
        });
    }

    public void selectPerformanceByName(){
            ButtonMethods.selectByTextField("Введите имя актёра", "Список спектакей, в которых " +
                    "играет данный актёр",
                    "SELECT performances.name " +
                            "FROM roles JOIN performances ON roles.performance_is = performances.performance_id " +
                            "WHERE roles.actor_id = (SELECT actors.actor_id " +
                            "FROM workers JOIN actors ON workers.worker_id = actors.worker_id " +
                            "WHERE workers.name LIKE ", true);
    }

    private void selectWorkersByPeriodInTour(String sqlFile){
        ButtonMethods.initPeriodAndGetActorsName("Введите период",
                ButtonMethods.loadResourceFile(sqlFile), (resultSet -> {
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
    }

    public void actorProducer(){
        JButton here, there;
        here = new JButton("Приезжавшие когда-либо на гастроли в театр");
        there = new JButton("Уезжавшие на гастроли");

        List<Component> components = new LinkedList<>();
        components.add(here);
        components.add(there);
        ButtonMethods.setFrameParameters("", 500, 400, components);

        here.addActionListener((ActionEvent e) -> selectWorkersByPeriodInTour("selects/tours.sql"));

        there.addActionListener((ActionEvent e) -> selectWorkersByPeriodInTour("selects/noLocalTour.sql"));
    }
}
