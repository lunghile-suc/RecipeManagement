package web.recipeServlets;

import beans.Recipe;
import database.RecipeDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/recipes")
public class GetAllRecipes extends HttpServlet {
    private final RecipeDAO recipeDAO;
    
    public GetAllRecipes(){
        this.recipeDAO = new RecipeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List< Recipe > recipes = recipeDAO.getAllRecipes();
        request.setAttribute("recipes", recipes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
