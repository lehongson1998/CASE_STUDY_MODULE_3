package service.impl;

import model.person.customer.Customer;
import model.person.customer.TypeCustomer;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import unit.VnCharacterUnit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private final String REGEX_NAME_CUSTOMER = "([A-Z][a-z]+\\s?)+";
    private final String REGEX_PHONE_NUMBER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$";
    private final String REGEX_ID_CARD = "^[0-9]{9,12}$";
    private final String REGEX_EMAIL = "^[a-z]+[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String, String> create(Customer customer) {
        Map<String, String> mapErrors = new HashMap<>();

        if (!customer.getName().isEmpty()
                && !customer.getPhoneNumber().isEmpty()
                && !customer.getIdCard().isEmpty()
                && !customer.getEmail().isEmpty())
        {
            String name = VnCharacterUnit.removeAccent(customer.getName());
            String phone = customer.getPhoneNumber();
            String idCard = customer.getIdCard();
            String email = customer.getEmail();
            if (!name.matches(REGEX_NAME_CUSTOMER)
                    || !phone.matches(REGEX_PHONE_NUMBER)
                    || !idCard.matches(REGEX_ID_CARD)
                    || email.matches(REGEX_EMAIL))
            {
                mapErrors.put("name", "Please input right format!");
            }
        } else {
            mapErrors.put("name", "Please input name!");
        }
        if (mapErrors.size() == 0) {
            customerRepository.create(customer);
        }
        return mapErrors;
    }

    @Override
    public boolean edit(int id, Customer customer) {
        return customerRepository.edit(id, customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<TypeCustomer> findAllType() {
        return null;
    }
}
