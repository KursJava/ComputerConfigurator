package panels;

import daoimpl.ComputerSetDAOImpl;
import frame.MainFrame;
import model.ComputerSet;
import model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class ComputerSetPanel extends JPanel {

    private JButton addSet;
    private JButton deleteSet;
    private JButton back;
    private JToolBar toolBar;
    private JTable tableSet;
    private JScrollPane jScrollPane;

    public ComputerSetPanel() {
        createComponent();
        createTable();
        createToolBarButton();
        createActionListner();

    }

    private void createComponent() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    private void createTable() {
        String[] columnName = {"id", "Nazwa", "Opis", "Cena", "Klient"};
        DefaultTableModel model = new DefaultTableModel(columnName, 0);
        ComputerSetDAOImpl dao = new ComputerSetDAOImpl();
        List<ComputerSet> computerSetList = dao.getAllComputerSets();
        for (int i = 0; i<computerSetList.size();i++){
            Integer id = computerSetList.get(i).getId();
            String computerSetName = computerSetList.get(i).getComputerSetName();
            String computerSetDescribe = computerSetList.get(i).getComputerSetDescribe();
            BigDecimal computerPrice = computerSetList.get(i).getComputerPrice();
            Customer customer = computerSetList.get(i).getCustomer();
            Object [] obj={id,computerSetName, computerSetDescribe,computerPrice,customer.getName()};
            model.addRow(obj);
        }
        tableSet = new JTable(model);
        tableSet.setBackground(Color.YELLOW);
        tableSet.setPreferredScrollableViewportSize(new Dimension(300, 300));
        jScrollPane = new JScrollPane(tableSet);
        this.add(jScrollPane);

    }

    private void createActionListner() {
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainFrame mainFrame = new MainFrame();
                } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e1) {
                    e1.printStackTrace();
                }

            }
        });


    }

    private void createToolBarButton() {
        addSet = new JButton("Dodaj zestaw");
        deleteSet = new JButton("Usuń zestaw");
        back = new JButton("Wstecz");
        toolBar = new JToolBar();
        toolBar.add(back);
        toolBar.add(addSet);
        toolBar.add(deleteSet);
        this.add(toolBar);

    }

}
