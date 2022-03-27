package database;

import beans.FoodType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/recipe_management";
    private String dbUsername = "root";
    private String dbPassword = "";
    
    private Connection connection;
    private PreparedStatement SelectAllFoodTypes;
    private PreparedStatement SelectFoodTypesById;

    public String selectAllFoodTypes = "SELECT * FROM foodtype";
    public String selectById = "SELECT * FROM foodtype WHERE foodID = ?";
    
    public FoodDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            SelectAllFoodTypes = connection.prepareStatement(selectAllFoodTypes);
            SelectFoodTypesById = connection.prepareStatement(selectById);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RecipeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List< FoodType > getFoodTypebyId(int id){
        List< FoodType > results = null;
        try {
            SelectFoodTypesById.setInt(1, id);
            ResultSet resultSet = SelectAllFoodTypes.executeQuery();
            results = new ArrayList< >();
            
            while(resultSet.next()){
                results.add(new FoodType(
                        resultSet.getInt("foodID"),
                        resultSet.getString("foodType")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }
    
    public List< FoodType > getFoodType(){
        List< FoodType > results = null;
        try {
            ResultSet resultSet = SelectAllFoodTypes.executeQuery();
            results = new ArrayList< >();
            
            while(resultSet.next()){
                results.add(new FoodType(
                        resultSet.getInt("foodID"),
                        resultSet.getString("foodType")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }

}
