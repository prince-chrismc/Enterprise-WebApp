/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Models.CreditCardType;
import Models.User;
import Services.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class UserGateway {

    public static User FindUserBasicInfoByEmail(String email) {
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
                
                user.setIsAdmin(results.getBoolean("userIsAdmin"));
                user.setIsLocked(results.getBoolean("userIsLocked"));
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

    public static User FindUserCompleteByEmail(String email) {
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

                user.setAddress1(results.getString("userAddress1"));
                user.setAddress2(results.getString("userAddress2"));
                user.setCity(results.getString("userCity"));
                user.setState(results.getString("userState"));
                user.setZip(results.getString("userZip"));
                user.setCountry(results.getString("userCountry"));

                user.setCredit_card_type(CreditCardType.VISA);
                user.setCredit_card_number(results.getString("userCreditCardNumber"));
                user.setCredit_card_cvv(results.getString("userCreditCardCVV"));
                user.setCredit_card_expiry(results.getString("userCreditCardExpiry"));
                
                user.setIsAdmin(results.getBoolean("userIsAdmin"));
                user.setIsLocked(results.getBoolean("userIsLocked"));
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
    
    public static ArrayList<User> FindAllLockedUsersBasicInfo() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.users WHERE users.userIsLocked = true;");

            while (results.next()) {
                User user = new User();

                user.setUser_id(results.getInt("userID"));
                user.setPassword(results.getString("userPassword"));
                user.setFirst_name(results.getString("userFirstName"));
                user.setLast_name(results.getString("userLastName"));
                user.setEmail(results.getString("userEmail"));
                
                user.setIsAdmin(results.getBoolean("userIsAdmin"));
                user.setIsLocked(results.getBoolean("userIsLocked"));
                
                users.add(user);
            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }
    
        public static ArrayList<User> FindAllUnlockedUsersBasicInfo() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.users WHERE users.userIsLocked = false;");

            while (results.next()) {
                User user = new User();

                user.setUser_id(results.getInt("userID"));
                user.setPassword(results.getString("userPassword"));
                user.setFirst_name(results.getString("userFirstName"));
                user.setLast_name(results.getString("userLastName"));
                user.setEmail(results.getString("userEmail"));
                
                user.setIsAdmin(results.getBoolean("userIsAdmin"));
                user.setIsLocked(results.getBoolean("userIsLocked"));
                
                users.add(user);
            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }

    // Beginning of non static section
    private User user;

    public UserGateway(User user) {
        this.user = user;
    }

    public boolean InsertBasic() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("INSERT INTO gamesearcher.users(userPassword, userFirstName, userLastName, userEmail) VALUES"
                    + " ('" + user.getPassword() + "', '" + user.getFirst_name() + "', '" + user.getLast_name() + "', '" + user.getEmail() + "');");

            if (retval == 1) { // if only 1 raw was affected
                if (FindUserBasicInfoByEmail(user.getEmail()) != null) { // make sure its really there and valid
                    return true;
                }
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean InsertComplete() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("INSERT INTO gamesearcher.users(userPassword,userFirstName,userLastName,userEmail,userAddress1,userAddress2,userCity,userState,userZip,userCountry,userCreditCardType,userCreditCardNumber,userCreditCardCVV,userCreditCardExpiry)VALUES"
                    + "('" + user.getPassword() + "', '" + user.getFirst_name() + "', '" + user.getLast_name() + "', '" + user.getEmail() + "', '"
                    + user.getAddress1() + "', '" + user.getAddress2() + "', '" + user.getCity() + "', '" + user.getState() + "', '" + user.getZip() + "', '" + user.getCountry() + "', '"
                    + user.getCredit_card_type() + "', '" + user.getCredit_card_number() + "', '" + user.getCredit_card_cvv() + "', '" + user.getCredit_card_expiry() + "');");

            if (retval == 1) { // if only 1 raw was affected
                if (FindUserBasicInfoByEmail(user.getEmail()) != null) { // make sure its really there and valid
                    return true;
                }
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage()); // https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html#executeQuery(java.lang.String)
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean Update() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("UPDATE gamesearcher.users"
                    + " SET "
                    + "userFirstName = '" + user.getFirst_name() + "',"
                    + "userLastName = '" + user.getLast_name() + "',"
                    + "userAddress1 = '" + user.getAddress1() + "',"
                    + "userAddress2 = '" + user.getAddress2() + "',"
                    + "userCity = '" + user.getCity() + "',"
                    + "userState = '" + user.getState() + "',"
                    + "userZip = '" + user.getZip() + "',"
                    + "userCountry = '" + user.getCountry() + "',"
                    + "userCreditCardType = 'VISA',"
                    + "userCreditCardNumber = '" + user.getCredit_card_number() + "',"
                    + "userCreditCardCVV = '" + user.getCredit_card_cvv() + "',"
                    + "userCreditCardExpiry = '" + user.getCredit_card_expiry() + "',"
                    + "userIsLocked = " + (user.isLocked() ? "true" : "false") + " "
                    + "WHERE userID = " + String.valueOf(user.getUser_id()) + " AND "
                    + "userEmail = '" + user.getEmail() + "';"
            );

            statement.close();

            if (retval == 1) { // if only 1 row was affected
                return true;
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}
