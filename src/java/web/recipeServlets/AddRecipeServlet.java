package web.recipeServlets;

import beans.Recipe;
import database.RecipeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-recipe")
public class AddRecipeServlet extends HttpServlet {
    
    private final RecipeDAO recipeDAO;
    
    public AddRecipeServlet(){
        this.recipeDAO = new RecipeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int userID = Integer.parseInt( request.getParameter("userID"));
        String RecipeName = request.getParameter("recipeName");
        String recipeIngredients = request.getParameter("recipeIngredients");
        String recipeInstructions = request.getParameter("recipeInstructions");
        String recipeDuration = request.getParameter("recipeDuration");
        String recipeServings = request.getParameter("recipeServings");
        int CategoryID = Integer.parseInt(request.getParameter("recipeCategory"));
        int FoodTypeID = Integer.parseInt(request.getParameter("recipeFoodType"));
        String recipeImage = request.getParameter("recipeImage");
        
        Recipe recipe = new Recipe(userID, FoodTypeID, CategoryID, RecipeName, recipeIngredients, recipeInstructions, recipeDuration, recipeImage, recipeServings);
        recipeDAO.addRecipe(recipe);
        
        response.sendRedirect("recipes");
    }
}
