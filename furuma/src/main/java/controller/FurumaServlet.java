package controller;

import model.facility.Facility;
import model.facility.RentType;
import model.facility.ServiceType;
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
import java.util.Map;

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
            case "list_facility":
                showListFacility(request, response);
                break;
            case "create_facility":
                showCreateFacility(request, response);
                break;
            case "show_edit_facility":
                showEditFacility(request, response);
                break;
            default:
                home(request, response);
        }
    }

    private void showEditFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.findById(id);
        List<ServiceType> serviceTypes = facilityService.getServiceTypeList();
        List<RentType> rentTypes = facilityService.getRentalTypeList();
        request.setAttribute("facility1", facility);
        request.setAttribute("facilityType", serviceTypes);
        request.setAttribute("rentType", rentTypes);
        RequestDispatcher rq = request.getRequestDispatcher("view/facility/edit.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("view/home.jsp");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "insert_facility":
                insertFacility(request, response);
                break;
            case "list_facility":
                showListFacility(request, response);
                break;
            case "delete_facility":
                deleteFacility(request, response);
                break;
            case "edit_facility":
                EditFacility(request, response);
                break;
        }
    }

    private void EditFacility(HttpServletRequest request, HttpServletResponse response) {
        Facility facility;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double deposit = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        int typeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int facilityType = Integer.parseInt(request.getParameter("create"));
        String standardRoom = request.getParameter("standard_room");
        String description = request.getParameter("description_other_convenience");
        String poolArea1 = request.getParameter("pool_area");
        double poolArea;
        if (poolArea1.equals("")){
            poolArea = 0;
        }else {
            poolArea = Double.parseDouble(poolArea1);
        }
        String numberFloor1 = request.getParameter("number_of_floors");
        int numberFloor;
        if (numberFloor1.equals("")){
            numberFloor = 0;
        }else {
            numberFloor = Integer.parseInt(numberFloor1);
        }
        String free = request.getParameter("facility_free");
        facility = new Facility(id, name, area, deposit, maxPeople, typeId, facilityType, standardRoom, description, poolArea, numberFloor,free);
        facilityService.editFacility(facility, id);
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

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        facilityService.deleteFacility(id);
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

    private void insertFacility(HttpServletRequest request, HttpServletResponse response) {
        Facility facility;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double deposit = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        int typeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int facilityType = Integer.parseInt(request.getParameter("create"));
        String standardRoom = request.getParameter("standard_room");
        String description = request.getParameter("description_other_convenience");
        String poolArea1 = request.getParameter("pool_area");
        double poolArea;
        if (poolArea1.equals("")){
            poolArea = 0;
        }else {
            poolArea = Double.parseDouble(poolArea1);
        }
        String numberFloor1 = request.getParameter("number_of_floors");
        int numberFloor;
        if (numberFloor1.equals("")){
            numberFloor = 0;
        }else {
            numberFloor = Integer.parseInt(numberFloor1);
        }
        String free = request.getParameter("facility_free");
        facility = new Facility(id, name, area, deposit, maxPeople, typeId, facilityType, standardRoom, description, poolArea, numberFloor,free);
        Map<String, String> mapError = facilityService.CreateFacility(facility);
        RequestDispatcher dispatcher;
        if (mapError.size() > 0){
            request.setAttribute("message", "insert error");
            request.setAttribute("mapError", mapError);
            dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
        }else {
            List<Facility> facilityList = facilityService.findAllFacility();
            request.setAttribute("facility", facilityList);
            dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
