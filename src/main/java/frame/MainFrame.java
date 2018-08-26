package frame;

import panels.ComputerComponentPanel;
import panels.ComputerSetPanel;
import panels.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton customer;
    private JButton component;
    private JButton computerSet;
    private JButton aboutProgram;
    private JLabel label;
    private JPanel panel;
    private ImageIcon imageIcon;


    public MainFrame() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        createFrame();
        createComponent();
        actionListner();
        setVisible(true);

    }

    private void createFrame() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        setSize(600, 580);
        setTitle("Computer Configurator");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/images/images.jpg")).getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        panel = new JPanel();
        customer = new JButton("Klienci");
        component = new JButton("Podzespoły");
        computerSet = new JButton("Zamówienia");
        aboutProgram = new JButton("Info");
        label = new JLabel();
        imageIcon = new ImageIcon(MainFrame.class.getResource("/images/konfiguator.jpg"));
        label.setIcon(imageIcon);

        panel.setLayout(new BorderLayout());
        JPanel panels = new JPanel();
        panels.add(customer);
        panels.add(component);
        panels.add(computerSet);

        JPanel about = new JPanel();
        about.add(aboutProgram);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(panels, BorderLayout.CENTER);
        panel2.add(about, BorderLayout.EAST);

        panel.add(panel2, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);

        add(panel);

    }

    public void actionListner() {
        customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new CustomerPanel());
                pack();
            }
        });
        component.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new ComputerComponentPanel());
                pack();
            }
        });
        computerSet.addActionListener((e) -> {
            setContentPane(new ComputerSetPanel());
            pack();
        });
        aboutProgram.addActionListener((e ->
        JOptionPane.showMessageDialog(this, "     Computer Configurator \n Wersja demonstracyjna: v1.0" +
                "\n Development by: Karol Sidor")));
    }
}
