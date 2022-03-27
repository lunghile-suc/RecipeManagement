package database;

import beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/recipe_management";
    private String dbUsername = "root";
    private String dbPassword = "";
    
    private Connection connection;
    private PreparedStatement Select;
    
    public String selectUser = "SELECT * FROM users WHERE email = ? and passwod = ?";
    
    public LoginDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            Select = connection.prepareStatement(selectUser); 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User login(String email, String password){
        
        User user = null;
        
        try {
            Select.setString(1, email);
            Select.setString(2, password);
            
            ResultSet resultSet = Select.executeQuery();
            
            if(resultSet.next()){
                user = new User();
                user.setEmail(email);
                user.setUserID(resultSet.getInt("userID"));
                user.setFirstName(resultSet.getString("firstName"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
}
