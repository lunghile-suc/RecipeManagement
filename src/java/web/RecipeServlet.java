package web;

import beans.Categories;
import beans.FoodType;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import database.CategoriesDAO;
import database.FoodDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/recipe")
public class RecipeServlet extends HttpServlet {
    
    private final CategoriesDAO categoriesDAO;
    private final FoodDAO foodDAO;
    
    public RecipeServlet(){
        this.categoriesDAO = new CategoriesDAO();
        this.foodDAO = new FoodDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //get all list of food categories
        List< Categories > categories = categoriesDAO.getCategories();
        request.setAttribute("categories", categories);
        
        //get all list of food types
        List< FoodType > foodTypes = foodDAO.getFoodType();
        request.setAttribute("foodTypes", foodTypes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-recipe.jsp");
        dispatcher.forward(request, response);
        
        
    }
    
    
}
