package web.recipeServlets;

import database.RecipeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-recipe")
public class DeleteRecipeServlet extends HttpServlet {

    private final RecipeDAO recipeDAO;
    
    public DeleteRecipeServlet(){
        this.recipeDAO = new RecipeDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        recipeDAO.deleteRecipe(id);
        
        response.sendRedirect("my-recipes");     
    }
}
