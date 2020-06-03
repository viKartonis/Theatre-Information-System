package gui.menuItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuPosition implements ActionListener, ItemListener {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu role = new JMenu("Должность");
    private String producerName = new String();
    private JLabel label;

    public MenuPosition(JLabel label) {
        JMenuItem hr  = new JCheckBoxMenuItem("Актёр");
        JMenuItem manager  = new JCheckBoxMenuItem("Постановщик");
        JMenuItem designer  = new JCheckBoxMenuItem("Художник-постановщик");
        JMenuItem conductor  = new JCheckBoxMenuItem("Дирижёр");
        JMenuItem musician  = new JCheckBoxMenuItem("Музыкант");

        role.add(hr);
        role.add(manager);
        role.add(designer);
        role.add(conductor);
        role.add(musician);
        hr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                producerName = hr.getText();
                label.setText(producerName);
            }
        });
        manager.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                producerName = manager.getText();
                label.setText(producerName);
            }
        });
        designer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                producerName = designer.getText();
                label.setText(producerName);
            }
        });
        conductor.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                producerName = conductor.getText();
            }
        });
        musician.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                producerName = musician.getText();
                label.setText(producerName);
            }
        });

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

