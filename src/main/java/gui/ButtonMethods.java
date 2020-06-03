package gui;

import dao.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class ButtonMethods {

    private static Connection connection;

    static {
        try {
            connection = new Connection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void init(JFrame frame, int rows, int cols){
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            GridLayout gridLayout = new GridLayout(rows, cols, 0, 1);
            panel.setLayout(gridLayout);
            frame.setLayout(gridLayout);
            frame.setBackground(Color.WHITE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }

    public static void selectFromDb(String title, String query){
        createFrame(title, connection.select(query));
    }

    public static void selectFromDb(String title, String query, Function<ResultSet, List<String>> toString){
        createFrame(title, connection.select(query, toString));
    }

    public static void createFrame(String title, List<List<String>> data){
        JFrame frame = new JFrame(title);
        frame.setSize(500, 400);

        init(frame,1, 1);
        Box box = new Box(BoxLayout.PAGE_AXIS);
        box.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        for (List<String> list : data) {
            Box innerBox = new Box(BoxLayout.LINE_AXIS);
            for(String s : list) {
                //frame.add(new Label(s));
                innerBox.add(new Label(s));
            }
            box.add(innerBox);
        }
        //frame.getContentPane().add(box);
        JScrollPane scrollPane1 = new JScrollPane(box);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollPane1);
    }

    public static JFrame setFrameParameters(String title, int width, int height, List<Component> componentList) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        for (Component component : componentList) {
            frame.getContentPane().add(component);
        }
        ButtonMethods.init(frame, componentList.size(), 1);
        return frame;
    }

    public static void selectByTextField(String labelText, String frameTitle, String query,
                                         Function<ResultSet, List<String>> toString, boolean scope){
        JLabel inputLabel = new JLabel(labelText);
        JTextArea inputText = new JTextArea();
        JButton inputNext = new JButton("Далее");
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(inputText);
        componentList.add(inputNext);
        setFrameParameters(frameTitle, 250, 100, componentList);
        inputNext.addActionListener((ActionEvent event) -> {
            selectFromDb(frameTitle,
                    query +  "'" + inputText.getText() + "'" + (scope ? ")" : ""), toString);
        });
    }

    public static void selectByTextField(String labelText, String frameTitle, String query, boolean scope){
        selectByTextField(labelText, frameTitle, query, resultSet -> {
            try {
                return Collections.singletonList(resultSet.getString(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }, scope);
    }

    public static void initPeriodAndGetActorsName(String frameTitle, String query, Function<ResultSet, List<String>> toString){
        JLabel inputLabel = new JLabel("Введите период");
        JTextArea before = new JTextArea();
        JTextArea after = new JTextArea();
        JButton inputNext = new JButton("Далее");
        List<Component> componentList = new LinkedList<>();
        componentList.add(inputLabel);
        componentList.add(before);
        componentList.add(after);
        componentList.add(inputNext);
        setFrameParameters(frameTitle, 250, 300, componentList);
        inputNext.addActionListener((ActionEvent event) -> selectFromDb(frameTitle,
                 query + " TO_DATE('" + before.getText() +"', 'yyyy/mm/dd')" +
                         " AND TO_DATE('" + after.getText() + "', 'yyyy/mm/dd')", toString));
    }

    public static void initPeriodAndGetActorsName(String frameTitle, String query){
        initPeriodAndGetActorsName(frameTitle, query, (resultSet -> {
            try {
                return Collections.singletonList(resultSet.getString(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }));
    }

    public static String loadResourceFile(String relativePath){
        try {
            return new String(Files.readAllBytes(Paths.get(
                    "/Users/kartonis/Projects/NetworkAndCommunication/dbProject/src/main/resources/" + relativePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
