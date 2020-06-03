package gui.menuItems;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuRole implements ActionListener, ItemListener {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu role = new JMenu("Роль");
    private String roleName = new String();

    public MenuRole() {
        JMenuItem hr  = new JCheckBoxMenuItem("Работник отдела кадров");
        JMenuItem manager  = new JCheckBoxMenuItem("Менеджер расписания");
        JMenuItem brochure = new JCheckBoxMenuItem("Составитель брошюр");
        JMenuItem producer = new JCheckBoxMenuItem("Постановщик");
        JMenuItem director = new JCheckBoxMenuItem("Директор");
        role.add(hr);
        role.add(manager);
        role.add(brochure);
        role.add(producer);
        role.add(director);
        hr.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = hr.getText();
                //System.out.println(roleName);
            }
        });
        manager.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = manager.getText();
            }
        });
        brochure.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = brochure.getText();
            }
        });
        producer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = producer.getText();
            }
        });
        director.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                roleName = director.getText();
            }
        });
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
    public String getRoleName() {
        return roleName;
    }
}
