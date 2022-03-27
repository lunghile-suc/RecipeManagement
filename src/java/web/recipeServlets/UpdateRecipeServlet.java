package web.recipeServlets;

import beans.Categories;
import beans.FoodType;
import beans.Recipe;
import beans.User;
import database.CategoriesDAO;
import database.FoodDAO;
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

@WebServlet("/update-recipe")
public class UpdateRecipeServlet extends HttpServlet {

    private final RecipeDAO recipeDAO;
    private final CategoriesDAO categoriesDAO;
    private final FoodDAO foodDAO;

    public UpdateRecipeServlet() {
        this.recipeDAO = new RecipeDAO();
        this.categoriesDAO = new CategoriesDAO();
        this.foodDAO = new FoodDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // recipe id
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = recipeDAO.getRecipeById(id);
        request.setAttribute("recipe", recipe);

        //get all list of food categories
        List< Categories> categories = categoriesDAO.getCategories();
        request.setAttribute("categories", categories);

        //get all list of food types
        List< FoodType> foodTypes = foodDAO.getFoodType();
        request.setAttribute("foodTypes", foodTypes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("update-recipe.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int recipeID = Integer.parseInt(request.getParameter("recipeID"));
    }
}
