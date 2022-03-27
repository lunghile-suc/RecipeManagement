package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.Recipe;

public class RecipeDAO {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/recipe_management";
    private String dbUsername = "root";
    private String dbPassword = "";

    private Connection connection;
    private PreparedStatement InsertRecipe;
    private PreparedStatement SelectRecipe;
    private PreparedStatement SelectAllRecipes;
    private PreparedStatement SelectAllRecipesbyUser;
    private PreparedStatement DeleteRecipe;
    private PreparedStatement UpdateRecipe;

    // sql statements for recipes table
    public String insertRecipe = "INSERT INTO recipes"
            + "(userID, foodID, categoryID, recipeName, recipeIngredients, recipeInstructions, recipeDuration, recipeImage,recipeServings)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public String selectRecipe = "SELECT * FROM recipes WHERE recipeID = ?";
    public String selectAllRecipesbyUser = "SELECT * FROM recipes WHERE userID = ?";
    public String selectAllRecipes = "SELECT * FROM recipes";
    public String deleteRecipe = "DELETE FROM recipes WHERE recipeID = ?";

    //recipeDAO constractor
    public RecipeDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            InsertRecipe = connection.prepareStatement(insertRecipe);
            SelectRecipe = connection.prepareStatement(selectRecipe);
            SelectAllRecipes = connection.prepareStatement(selectAllRecipes);
            SelectAllRecipesbyUser = connection.prepareStatement(selectAllRecipesbyUser);
            DeleteRecipe = connection.prepareStatement(deleteRecipe);
//            UpdateRecipe = connection.prepareStatement(updateRecipe);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // add a new recipe method
    public void addRecipe(Recipe recipe) {
        try {
            InsertRecipe.setInt(1, recipe.getUserID());
            InsertRecipe.setInt(2, recipe.getFoodID());
            InsertRecipe.setInt(3, recipe.getCategoryID());
            InsertRecipe.setString(4, recipe.getRecipeName());
            InsertRecipe.setString(5, recipe.getRecipeIngredients());
            InsertRecipe.setString(6, recipe.getRecipeInstructions());
            InsertRecipe.setString(7, recipe.getRecipeDuration());
            InsertRecipe.setString(8, recipe.getRecipeImage());
            InsertRecipe.setString(9, recipe.getRecipeServings());
            InsertRecipe.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //select all recipes
    public List< Recipe> getAllRecipes() {
        List<Recipe> results = null;
        try {
            ResultSet resultSet = SelectAllRecipes.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()) {
                results.add(new Recipe(
                        resultSet.getInt("recipeID"),
                        resultSet.getInt("userID"),
                        resultSet.getInt("foodID"),
                        resultSet.getInt("categoryID"),
                        resultSet.getString("recipeName"),
                        resultSet.getString("recipeIngredients"),
                        resultSet.getString("recipeInstructions"),
                        resultSet.getString("recipeDuration"),
                        resultSet.getString("recipeImage"),
                        resultSet.getString("recipeServings")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    //select recipe by id method
    public Recipe getRecipeById(int id) {
        Recipe recipe = null;
        try {
            SelectRecipe.setInt(1, id);
            ResultSet resultSet = SelectRecipe.executeQuery();
            recipe = new Recipe();

            while (resultSet.next()) {
                recipe = new Recipe(
                        resultSet.getInt("recipeID"),
                        resultSet.getInt("userID"),
                        resultSet.getInt("foodID"),
                        resultSet.getInt("categoryID"),
                        resultSet.getString("recipeName"),
                        resultSet.getString("recipeIngredients"),
                        resultSet.getString("recipeInstructions"),
                        resultSet.getString("recipeDuration"),
                        resultSet.getString("recipeImage"),
                        resultSet.getString("recipeServings")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recipe;
    }

    public List< Recipe> getRecipeByUser(int id) {
        List<Recipe> results = null;
        try {
            SelectAllRecipesbyUser.setInt(1, id);
            ResultSet resultSet = SelectAllRecipesbyUser.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()) {
                results.add(new Recipe(
                        resultSet.getInt("recipeID"),
                        resultSet.getInt("userID"),
                        resultSet.getInt("foodID"),
                        resultSet.getInt("categoryID"),
                        resultSet.getString("recipeName"),
                        resultSet.getString("recipeIngredients"),
                        resultSet.getString("recipeInstructions"),
                        resultSet.getString("recipeDuration"),
                        resultSet.getString("recipeImage"),
                        resultSet.getString("recipeServings")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    //delete recipe
    public void deleteRecipe(int id) {
        try {
            DeleteRecipe.setInt(1, id);
            DeleteRecipe.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("problem deleting row" + ex);
        }
    }

    //update recipe method
    
}
