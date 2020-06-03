package gui.menuItems;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuGender implements ActionListener, ItemListener {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu role = new JMenu("Пол");
    private String roleName = new String();
    private JLabel label;

    public MenuGender(JLabel label) {
        JMenuItem hr  = new JCheckBoxMenuItem("Мужской");
        JMenuItem manager  = new JCheckBoxMenuItem("Женский");
        role.add(hr);
        role.add(manager);
        hr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = hr.getText();
                label.setText(roleName);
            }
        });
        manager.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = manager.getText();
                label.setText(roleName);
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
        return roleName;
    }
}

