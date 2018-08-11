package frame;

import panels.ComputerComponentPanel;
import panels.ComputerSetPanel;
import panels.CustomerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton customer;
    private JButton component;
    private JButton computerSet;
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
        setTitle("Zmieniłem Tytuł ramk");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/images.jpg")).getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void createComponent() {
        panel = new JPanel();
        customer = new JButton("Klienci");
        component = new JButton("Podzespoły");
        computerSet = new JButton("Zamówienia");
        label = new JLabel();
        imageIcon = new ImageIcon(MainFrame.class.getResource("/konfiguator.jpg"));
        label.setIcon(imageIcon);

        panel.add(customer);
        panel.add(component);
        panel.add(computerSet);
        panel.add(label);
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
    }
}
