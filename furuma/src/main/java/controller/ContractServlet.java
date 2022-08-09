package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "list_contract":
                showListContract(request, response);
                break;
            case "show_create_contract":
                showCreateContract(request, response);
                break;
            case "show_edit_contract":
                showEditContract(request, response);
                break;
            default:
                home(request, response);
        }
    }

    private void showEditContract(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            switch (action) {
                case "insert_contract":
                    insertContract(request, response);
                    break;
                case "delete_contract":
                    deleteContract(request, response);
                    break;
                case "edit_contract":
                    editContract(request, response);
                    break;
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

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) {

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
}
