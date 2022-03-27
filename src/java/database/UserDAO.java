package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/recipe_management";
    private String dbUsername = "root";
    private String dbPassword = "";
    
    private Connection connection;
    private PreparedStatement InsertUser;
    private PreparedStatement SelectUser;
    private PreparedStatement SelectAllUsers;
    private PreparedStatement UpdateUser;
    
    public String insert = "INSERT INTO users"
            + "(firstName, surname, email, phoneNo, gender, address, passwod, Image)" 
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"; 
    public String selectUser = "SELECT * FROM users WHERE userID = ?";
    public String selectAllUsers = "SELECT * FROM users";
    public String update = "UPDATE users SET"
            + "firstName = ?, surname = ?, email = ?, phoneNo = ?, gender = ?, address = ?, Image = ?" + 
            "WHERE userID = ?";
    
    
    public UserDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            InsertUser = connection.prepareStatement(insert);
            SelectUser = connection.prepareStatement(selectUser);
            SelectAllUsers = connection.prepareStatement(selectAllUsers);
            UpdateUser = connection.prepareStatement(update);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Insert User method
    public void AddUser(User user){
        try {
            InsertUser.setString(1, user.getFirstName());
            InsertUser.setString(2, user.getSurname());
            InsertUser.setString(3, user.getEmail());
            InsertUser.setInt(4, user.getPhoneNo());
            InsertUser.setString(5, user.getGender());
            InsertUser.setString(6, user.getAddress());
            InsertUser.setString(7, user.getPassword());
            InsertUser.setString(8, user.getProfilePhoto());
            InsertUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // select all users method
    public List< User> getAllUsers(){
        List< User> results = null;
        
        try {
            ResultSet resultSet = SelectAllUsers.executeQuery();
            
            results = new ArrayList<>();
            
            while(resultSet.next()){
                results.add(new User(
                        resultSet.getInt("userID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getInt("phoneNo"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("password"),
                        resultSet.getString("Image")
                ));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }
    
    // select user method
    public User getUser(int id){
         User user = null;       
        try {
            SelectUser.setInt(1, id);
            ResultSet resultSet = SelectUser.executeQuery();
            
            user = new User();
            
            while(resultSet.next()){
                user = (new User(
                        resultSet.getInt("userID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getInt("phoneNo"),
                        resultSet.getString("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("Image")
                ));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    //update user method
    public void updateUser(User user){
        try {
            UpdateUser.setString(1, user.getFirstName());
            UpdateUser.setString(2, user.getSurname());
            UpdateUser.setString(3, user.getEmail());
            UpdateUser.setInt(4, user.getPhoneNo());
            UpdateUser.setString(5, user.getGender());
            UpdateUser.setString(6, user.getAddress());
            UpdateUser.setString(7, user.getProfilePhoto());
            UpdateUser.setInt(8, user.getUserID());            
            UpdateUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
