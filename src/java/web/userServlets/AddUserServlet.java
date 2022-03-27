package web.userServlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import beans.User;
import database.UserDAO;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/register")
public class AddUserServlet extends HttpServlet {
    
    private final UserDAO userDAO;

    public AddUserServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String photo = request.getParameter("photoUpload");
        
        User user = new User(firstName, surname, email, phoneNo, gender, address, password, photo);
        userDAO.AddUser(user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("signin");
        dispatcher.forward(request, response);
    }

}
