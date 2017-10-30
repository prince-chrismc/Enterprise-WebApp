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
public class RegisterService {
    private User user;
    
    public RegisterService(String email, String password, String first,String last) {
        try
        {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            statement.execute("INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail) VALUES" +
            " ('" + password + "', '" + first + "', '" + last + "', '" + email +"');", Statement. RETURN_GENERATED_KEYS);
            ResultSet results = statement.getGeneratedKeys();
            
            if(results.first())
            {
                user = new User();
                user.setUser_id(results.getInt("userID"));
                user.setPassword(results.getString("userPassword"));
                user.setFirst_name(results.getString("userFirstName"));
                user.setLast_name(results.getString("userLastName"));            
                user.setEmail(results.getString("userEmail"));
            }
        }
        catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public User getUser(){
        return user;
    }
    
}
