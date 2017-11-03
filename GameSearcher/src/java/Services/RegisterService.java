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
    private LoginService login;
    
    public RegisterService(String email, String password, String first,String last) {
        login = new LoginService();
        try
        {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            statement.executeUpdate("INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail) VALUES" +
            " ('" + password + "', '" + first + "', '" + last + "', '" + email +"');");
            
            if(login.isValidUser(email, password))
            {
                
            }
            
            statement.close();
        }
        catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public User getUser(){
        return login.getUser();
    }
    
}
