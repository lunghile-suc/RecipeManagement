package database;

import beans.Categories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriesDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/recipe_management";
    private String dbUsername = "root";
    private String dbPassword = "";
    
    private Connection connection;
    private PreparedStatement SelectAllCategories;
    private PreparedStatement SelectById;

    public String selectAllCategories = "SELECT * FROM categories";
    public String selectById = "SELECT * FROM categories WHERE categoryID = ?";
    
    public CategoriesDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            SelectAllCategories = connection.prepareStatement(selectAllCategories);
            SelectById = connection.prepareStatement(selectById);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // select category by id
    public List< Categories > getCategoryById(int id){
        List< Categories > results = new ArrayList< >();
        try {
            SelectById.setInt(1, id);
            ResultSet resultSet = SelectAllCategories.executeQuery();
            
            while(resultSet.next()){
                results.add(new Categories(
                        resultSet.getInt("categoryID"),
                        resultSet.getString("categoryName")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }
    
    public List< Categories > getCategories(){
        List< Categories > results = new ArrayList< >();
        try {
            ResultSet resultSet = SelectAllCategories.executeQuery();
            
            while(resultSet.next()){
                results.add(new Categories(
                        resultSet.getInt("categoryID"),
                        resultSet.getString("categoryName")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }
}
