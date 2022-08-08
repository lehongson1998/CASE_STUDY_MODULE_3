package service;

import model.person.customer.Customer;
import model.person.customer.TypeCustomer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAll();
    List<Customer> findByName(String name);
    Customer findById(int id);
    Map<String, String> create(Customer customer);
    boolean edit(int id, Customer customer);
    boolean delete(int id);
    List<TypeCustomer> findAllType();
}
