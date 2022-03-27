package web.userServlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import database.UserDAO;
import beans.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

@WebServlet("/account")
public class UpdateUserServlet extends HttpServlet {
    
    private final UserDAO userDAO;

    public UpdateUserServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User userID = (User) session.getAttribute("user");
        
        User user = userDAO.getUser(userID.getUserID());
        request.setAttribute("singleUser", user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("my-account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User userID = (User) session.getAttribute("user");
        
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String photo = request.getParameter("photoUpload");
        
        User user = new User(userID.getUserID(), firstName, surname, email, phoneNo, gender, address, photo);
        userDAO.updateUser(user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("my-account.jsp");
        dispatcher.forward(request, response);
    }
}
