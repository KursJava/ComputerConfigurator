package dao;

import model.Adres;
import model.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer getById(Integer id);

    List<Customer> allCustomer();

    void addCustomer(Customer customer);

    void mergeCustomer(Customer customer);

    void removeCustomer(Customer customer);

    void removeById(Integer id);
}
