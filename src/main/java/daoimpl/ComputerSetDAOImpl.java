package daoimpl;


import dao.ComputerSetDAOTemp;
import model.ComputerComponent;
import model.ComputerSet;
import model.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerSetDAOImpl implements ComputerSetDAOTemp {

    Map<Integer, ComputerSet> computerSets = new HashMap<Integer, ComputerSet>();
    List<ComputerSet> computerSetList = new ArrayList<>();
    Customer customer = new Customer();


    public ComputerSetDAOImpl() {
        ComputerSet set1 = new ComputerSet(1, "Zestaw1", "Tani",
                new BigDecimal(3000), new Customer(), new ArrayList<ComputerComponent>());
        ComputerSet set2 = new ComputerSet(2, "Zestaw2", "Drogi",
                new BigDecimal(4000),
                new Customer(), new ArrayList<ComputerComponent>());
        ComputerSet set3 = new ComputerSet(3, "Zestaw 3", "Najdroższy",
                new BigDecimal(6000), new Customer(),
                new ArrayList<ComputerComponent>());

    }

    public Map<Integer, ComputerSet> getAllComputerSet() {
        return computerSets;
    }

    public List<ComputerSet> getAllComputerSets() {
        ComputerSet set1 = new ComputerSet(1, "Zestaw1", "Tani",
                new BigDecimal(3000), new Customer(1,"Janina","Kowalska","Lublin"), new ArrayList<ComputerComponent>());
        ComputerSet set2 = new ComputerSet(2, "Zestaw2", "Drogi",
                new BigDecimal(4000),
                new Customer(2,"Pan","Kowalski","Warszawa"), new ArrayList<ComputerComponent>());
        ComputerSet set3 = new ComputerSet(3, "Zestaw 3", "Najdroższy",
                new BigDecimal(6000), new Customer(3,"Jan","Kowalski", "Lublin"),
                new ArrayList<ComputerComponent>());

        computerSetList.add(set1);
        computerSetList.add(set2);
        computerSetList.add(set3);

        return computerSetList;
    }

    public ComputerSet getComputerSet(Integer id) {
        return computerSets.get(id);

    }

    public void updateComputerSet(ComputerSet computerSet) {
        ComputerSet old = computerSets.get(computerSet.getId());
        old.setId(computerSet.getId());
        old.setComputerComponentList(computerSet.getComputerComponentList());
        old.setComputerPrice(computerSet.getComputerPrice());
        old.setComputerSetDescribe(computerSet.getComputerSetDescribe());
        old.setComputerSetName(computerSet.getComputerSetName());
        old.setCustomer(computerSet.getCustomer());
        computerSets.put(old.getId(), old);

    }

    public void deleteComputerSet(Integer id) {

        computerSets.remove(id);
    }
}
