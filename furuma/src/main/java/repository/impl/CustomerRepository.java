package repository.impl;

import connect.DatabaseConnect;
import model.person.customer.Customer;
import model.person.customer.TypeCustomer;
import repository.ICustomerRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_CUSTOMER = "CALL find_all_customer();";
    private final String SELECT_CUSTOMER_BY_ID = "CALL find_customer_by_id(?);";
    private final String ADD_NEW_CUSTOMER = "CALL insert_new_customer(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String EDIT_CUSTOMER = "CALL edit_customer(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String DELETE_CUSTOMER = "CALL delete_customer(?);";
    private final String FIND_BY_NAME_CUSTOMER = "CALL find_by_name_customer(?);";
    private final String FIND_ALL_TYPE_CUSTOMER = "CALL find_all_type_customer();";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        Connection connection = DatabaseConnect.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_CUSTOMER);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_khach_hang");
                int typeId = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                LocalDate date = LocalDate.parse(resultSet.getString("ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int gender = resultSet.getInt("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(id, name, date, idCard, phoneNumber, email, address, typeId, gender);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        Connection connection = DatabaseConnect.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_BY_NAME_CUSTOMER);
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_khach_hang");
                int typeId = resultSet.getInt("ma_loai_khach");
                String name1 = resultSet.getString("ho_ten");
                LocalDate date = LocalDate.parse(resultSet.getString("ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int gender = resultSet.getInt("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(id, name1, date, idCard, phoneNumber, email, address, typeId, gender);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = DatabaseConnect.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_CUSTOMER_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int typeId = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_ten");
                LocalDate date = LocalDate.parse(resultSet.getString("ngay_sinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int gender = resultSet.getInt("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer = new Customer(id, name, date, idCard, phoneNumber, email, address, typeId, gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = DatabaseConnect.getConnectDB();
        int check;
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_CUSTOMER);
            callableStatement.setInt(1, customer.getId());
            callableStatement.setInt(2, customer.getTypeCustomerId());
            callableStatement.setString(3, customer.getName());
            callableStatement.setDate(4, Date.valueOf(customer.getDateOfBirth()));
            callableStatement.setInt(5, customer.getGender());
            callableStatement.setString(6, customer.getIdCard());
            callableStatement.setString(7, customer.getPhoneNumber());
            callableStatement.setString(8, customer.getEmail());
            callableStatement.setString(9, customer.getAddress());
            check = callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean edit(int id, Customer customer) {
        Connection connection = DatabaseConnect.getConnectDB();
        int check;
        try {
            CallableStatement callableStatement = connection.prepareCall(EDIT_CUSTOMER);
            callableStatement.setInt(1, id);
            callableStatement.setInt(2, customer.getTypeCustomerId());
            callableStatement.setString(3, customer.getName());
            callableStatement.setDate(4, Date.valueOf(customer.getDateOfBirth()));
            callableStatement.setInt(5, customer.getGender());
            callableStatement.setString(6, customer.getIdCard());
            callableStatement.setString(7, customer.getPhoneNumber());
            callableStatement.setString(8, customer.getEmail());
            callableStatement.setString(9, customer.getAddress());
            check = callableStatement.executeUpdate();
            return check > 0? true: false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DatabaseConnect.getConnectDB();
        int check;
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_CUSTOMER);
            callableStatement.setInt(1, id);
            check = callableStatement.executeUpdate();
            return check > 0? true: false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TypeCustomer> findAllType() {
        List<TypeCustomer> typeCustomersList = new ArrayList<>();
        TypeCustomer typeCustomer;
        Connection connection = DatabaseConnect.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL_TYPE_CUSTOMER);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ma_loai_khach");
                String name = rs.getString("ten_loai_khach");
                typeCustomer = new TypeCustomer(id, name);
                typeCustomersList.add(typeCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeCustomersList;
    }
}
