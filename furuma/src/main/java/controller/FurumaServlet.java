package controller;

import model.facility.Facility;
import model.person.customer.Customer;
import service.impl.CustomerService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "FurumaServlet", value = "/furuma")
public class FurumaServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    FacilityService facilityService = new FacilityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "list_customer":
                showListCustomer(request, response);
                break;
            case "list_employee":
                showListEmployee(request, response);
                break;
            case "list_facility":
                showListFacility(request, response);
                break;
            case "list_contract":
                showListContract(request, response);
                break;
            case "create_customer":
                showCreateCustomer(request, response);
                break;
            case "create_employee":
                showCreateEmployee(request, response);
                break;
            case "create_facility":
                showCreateFacility(request, response);
                break;
            case "create_contract":
                showCreateContract(request, response);
                break;
            case "show_edit_facility":
                showEditFacility(request, response);
                break;
            case "show_edit_customer":
                showEditCustomer(request, response);
                break;
            case "search_by_id":
                showCustomerById(request, response);
                break;
            default:
                home(request, response);
        }
    }

    private void showCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.findByName(name);
        request.setAttribute("customer", customerList);
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerById(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("cus" , customer);
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFacility(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/facility/edit.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreatFacility(HttpServletRequest request, HttpServletResponse response) {
        String select = request.getParameter("select");
        RequestDispatcher rq = null;
        if (select.equals("villa")){
            request.setAttribute("villas", "villa nè");
            rq = request.getRequestDispatcher("view/facility/create.jsp");
        }
        if (select.equals("house")){
            request.setAttribute("houses", "house nè");
            rq = request.getRequestDispatcher("view/facility/create.jsp");
        }
        if (select.equals("room")){
            request.setAttribute("room", "room nè");
            rq = request.getRequestDispatcher("view/facility/create.jsp");
        }
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customer", customerList);
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/list.jsp");

        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListFacility(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.findAllFacility();
        request.setAttribute("facility", facilityList);
        RequestDispatcher rq = request.getRequestDispatcher("view/facility/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/contract/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFacility(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/facility/create.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/contract/create.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "insert_customer":
                insertCustomer(request, response);
                break;
            case "edit_customer":
                editCustomer(request, response);
                break;
            case "insert_employee":
                insertEmployee(request, response);
                break;
            case "insert_facility":
                insertFacility(request, response);
                break;
            case "insert_contract":
                insertContract(request, response);
                break;
            case "delete_customer":
                deleteCustomer(request, response);
                break;
            case "search_by_name":
                showCustomerByName(request, response);
                break;
            case "list_facility":
                showListFacility(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customer", customerList);
        RequestDispatcher rq = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, dateOfBirth, idCard, phone, email, address, typeId, gender);
        boolean flag = customerService.edit(id, customer);

        if (flag){
            request.setAttribute("message", "edit success");
        }else {
            request.setAttribute("message", "edit error");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertFacility(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, dateOfBirth, idCard, phone, email, address, typeId, gender);
        boolean flag = customerService.create(customer);
        if (flag){
            request.setAttribute("message", "insert success");
        }else {
            request.setAttribute("message", "insert error");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
