package service.impl;

import model.person.customer.Customer;
import model.person.customer.TypeCustomer;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import unit.VnCharacterUnit;

import java.time.LocalDate;
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
        if (!customer.getName().isEmpty()) {
            String name = VnCharacterUnit.removeAccent(customer.getName());
            if (!name.matches(REGEX_NAME_CUSTOMER)) {
                mapErrors.put("name", "* Please input right format!");
            }
        } else {
            mapErrors.put("name", "* Please input name!");
        }

        if (!customer.getPhoneNumber().isEmpty()){
            String phone = customer.getPhoneNumber();
            if (!phone.matches(REGEX_PHONE_NUMBER)){
                mapErrors.put("phone", "* Please input phone format!");
            }
        }else {
            mapErrors.put("phone", "* Please input phone!");
        }

        if (!customer.getIdCard().isEmpty()){
            String idCard = customer.getIdCard();
            if (!idCard.matches(REGEX_ID_CARD)){
                mapErrors.put("idCard", "* please input 9-12 number!");
            }
        }else {
            mapErrors.put("idCard", "* Please input id card!");
        }

        try {
            LocalDate localDate= customer.getDateOfBirth();
        }catch (Exception e){
            mapErrors.put("date", "false format day!");
        }

        if (!customer.getEmail().isEmpty()){
            String email = customer.getEmail();
            if (!email.matches(REGEX_EMAIL)){
                mapErrors.put("email", "* please input email right format!");
            }
        }else {
            mapErrors.put("email", "* Please input email!");
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
