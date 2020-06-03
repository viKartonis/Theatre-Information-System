package gui.menuItems;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class MenuPerformanceCategory implements ActionListener, ItemListener {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu role = new JMenu("Категория");
    private String producerName = new String();
    private JLabel label;

    public MenuPerformanceCategory(List<String> names, JLabel label) {
        for(String name : names)
        {
            JMenuItem producer = new JCheckBoxMenuItem(name);
            role.add(producer);
            producer.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    producerName = producer.getText();
                    label.setText(producerName);
                }
            });
        }
        this.label = label;
        menuBar.add(role);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    public JMenuBar getRole() {
        return menuBar;
    }
    public String getName() {
        return producerName;
    }
}
