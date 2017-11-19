/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Models.User;
import Services.CookieHandler;
import Services.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cmcarthur
 */
public class UserGateway {
    public static User FindUserByEmail(String email) {
        User user = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.users WHERE users.userEmail LIKE '" + email + "';");

            if (results.first()) {
                user = new User();

                user.setUser_id(results.getInt("userID"));
                user.setPassword(results.getString("userPassword"));
                user.setFirst_name(results.getString("userFirstName"));
                user.setLast_name(results.getString("userLastName"));
                user.setEmail(email);

            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return user;
    }
    
    // Beginning of non static section
    
    private User user;
    public UserGateway(User user) {
        this.user = user;
    }
    
    public boolean InsertBasic() {
        try
        {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            int retval = statement.executeUpdate("INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail) VALUES" +
            " ('" + user.getPassword() + "', '" + user.getFirst_name() + "', '" + user.getLast_name() + "', '" + user.getEmail() +"');");
            
            if(retval == 1) { // if only 1 raw was affected
                if(FindUserByEmail(user.getEmail()) != null) { // make sure its really there and valid
                    return true;
                }
            }            
                       
            statement.close();
        }
        catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean InsertComplete() {
        try
        {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            int retval = statement.executeUpdate("INSERT INTO gamesearcher.users(userPassword,userFirstName,userLastName,userEmail,userAddress1,userAddress2,userCity,userState,userZip,userCountry,userCreditCardType,userCreditCardNumber,userCreditCardCVV,userCreditCardExpiry)VALUES"
                +"('" + user.getPassword() + "', '" + user.getFirst_name() + "', '" + user.getLast_name() + "', '" + user.getEmail() + "', '" + 
                user.getAddress1()  + "', '" + user.getAddress2() + "', '" + user.getCity() + "', '" + user.getState() + "', '" +  user.getZip() + "', '" + user.getCountry() + "', '" + 
                user.getCredit_card_type() + "', '" + user.getCredit_card_number() + "', '" + user.getCredit_card_cvv() + "', '" + user.getCredit_card_expiry() +"');");
            
            if(retval == 1) { // if only 1 raw was affected
                if(FindUserByEmail(user.getEmail()) != null) { // make sure its really there and valid
                    return true;
                }
            }            
                       
            statement.close();
        }
        catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}




