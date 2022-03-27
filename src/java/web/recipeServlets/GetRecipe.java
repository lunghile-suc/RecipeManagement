package web.recipeServlets;

import beans.Recipe;
import beans.User;
import database.RecipeDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/my-recipes")
public class GetRecipe extends HttpServlet {
    
    private final RecipeDAO recipeDAO;
    
    public GetRecipe(){
        this.recipeDAO = new RecipeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User userID = (User) session.getAttribute("user");
        
        List< Recipe > recipes = recipeDAO.getRecipeByUser(userID.getUserID());
        request.setAttribute("recipesByUser", recipes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("my-recipes.jsp");
        dispatcher.forward(request, response);
    }
}
