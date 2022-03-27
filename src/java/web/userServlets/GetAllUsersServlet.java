package web.userServlets;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import beans.User;
import database.UserDAO;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/users")
public class GetAllUsersServlet extends HttpServlet {
    
    private final UserDAO userDAO;

    public GetAllUsersServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List< User > getAllUsers = userDAO.getAllUsers();
        request.setAttribute("Users", getAllUsers);
    }
}
