package gui;

import dao.Connection;
import dao.inserts.InsertInto;
import gui.menuItems.MenuRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LogIn{

    private Connection connection;

    public LogIn(Connection connection) {
        this.connection = connection;
    }


    private void handlerRegistration(JButton register) {
        register.addActionListener((ActionEvent e) -> {
        JLabel emailLabel = new JLabel("Введите электронную почту");
        JLabel passwordLabel = new JLabel("Введите пароль");
        JTextField emailText = new JTextField();
        JPasswordField passwordText = new JPasswordField();
        MenuRole role = new MenuRole();
        JButton next = new JButton("Далее");
        List<Component> componentList = new LinkedList<>();
        componentList.add(emailLabel);
        componentList.add(emailText);
        componentList.add(passwordLabel);
        componentList.add(passwordText);
        componentList.add(role.getRole());
        componentList.add(next);
        ButtonMethods.setFrameParameters("Регистрация", 300, 200, componentList);

        next.addActionListener((ActionEvent nextEvent) -> {
            InsertInto insertInto = new InsertInto(connection);
            Menu menu = new Menu(connection);
            switch (role.getRoleName())
            {
                case "Работник отдела кадров" :
                {
                    insertInto.insertUser(emailText.getText(), String.copyValueOf(passwordText.getPassword()), 0);
                    menu.initPressHRWorkers();
                    break;
                }
                case "Менеджер расписания" :
                {
                    insertInto.insertUser(emailText.getText(), String.copyValueOf(passwordText.getPassword()), 1);
                    menu.initPressSchedule();
                    break;
                }
                case "Составитель брошюр" :
                {
                    insertInto.insertUser(emailText.getText(), String.copyValueOf(passwordText.getPassword()), 2);
                    menu.initPressBrochure();
                    break;
                }
                case "Постановщик" :
                {
                    insertInto.insertUser(emailText.getText(), String.copyValueOf(passwordText.getPassword()), 3);
                    menu.initPressProducer();
                    break;
                }
                case "Директор" :
                {
                    insertInto.insertUser(emailText.getText(), String.copyValueOf(passwordText.getPassword()), 4);
                    menu.initPressDirector();
                    break;
                }
            }
        });
        });
    }

    private void handlerLogin(JButton login){
        login.addActionListener((ActionEvent e) -> {
            JLabel emailLabel = new JLabel("Введите электронную почту");
            JLabel passwordLabel = new JLabel("Введите пароль");
            JTextField emailText = new JTextField();
            JPasswordField passwordText = new JPasswordField();
            JButton next = new JButton("Далее");
            List<Component> componentList = new LinkedList<>();
            componentList.add(emailLabel);
            componentList.add(emailText);
            componentList.add(passwordLabel);
            componentList.add(passwordText);
            componentList.add(next);
            ButtonMethods.setFrameParameters("Вход в приложение", 300, 200, componentList);
            next.addActionListener((ActionEvent nextEvent) -> {
                System.out.println(emailText.getText());
                List<List<String>> passwordFromDb = connection.select("SELECT users.password, users.user_role_id FROM " +
                                "users WHERE users.email LIKE '" +
                                emailText.getText() + "'",
                        (resultSet -> {
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
                String userRoleId = passwordFromDb.get(0).get(1);
                Menu menu = new Menu(connection);
                switch (Integer.valueOf(userRoleId)) {
                    case 0: {
                        menu.initPressHRWorkers();
                        break;
                    }
                    case 1: {
                        menu.initPressSchedule();
                        break;
                    }
                    case 2: {
                        menu.initPressBrochure();
                        break;
                    }
                    case 3: {
                        menu.initPressProducer();
                        break;
                    }
                    case 4: {
                        menu.initPressDirector();
                    }
                }
            });
        }) ;
    }

    public void loginInApplication(){
        JButton regButton = new JButton("Зарегистрироваться");
        JButton loginButton = new JButton("Войти");
        JButton exit = new JButton("Выйти");
        List<Component> componentList = new LinkedList<>();
        componentList.add(regButton);
        componentList.add(loginButton);
        componentList.add(exit);
        ButtonMethods.setFrameParameters("Вход в приложение", 300, 200, componentList);
        handlerRegistration(regButton);
        handlerLogin(loginButton);
    }
}
