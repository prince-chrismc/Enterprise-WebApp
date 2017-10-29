/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cmcarthur
 */
public class LoginService {
    private User user;

    public LoginService(){
        
    }

    public boolean isValidUser(String email, String password) {
        if(doesUserExistInDB(email, password) != null){
            return true;
        }
        return false;
    }
    
    User doesUserExistInDB(String email, String password) {
        try
        {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.users WHERE users.userEmail = '" + email + "';"); // https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
            
            if(!results.first()) return null; // This means the user DNE
            
            user = new User();
            user.setUser_id(results.getInt("userID"));
            user.setPassword(password);
            user.setFirst_name(results.getString("userFirstName"));
            user.setLast_name(results.getString("userLastName"));            
            user.setEmail(email);
            
            return user;
        }
        catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public User getUser(){
        return user;
    }
}
