/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Services.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cmcarthur
 */
public class LoginFailedGateway {

    public static LoginFailedGateway FindAttemptForUser(String user_email) {
        return new LoginFailedGateway(user_email, 0); // will be update by fetch
    }

    // Beginning of non-static section
    private String user_email;
    private int qty;

    public LoginFailedGateway(String user_email, int qty) {
        this.user_email = user_email;
        this.qty = qty;
        Fetch();
    }

    public boolean Insert() {
        if (!Fetch()) { // make sure it doesnt exists
            try {
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                int retval = statement.executeUpdate("INSERT INTO gamesearcher.loginfails(userEmail) VALUES('" + user_email + "');");
                statement.close();

                if (retval == 1) { // if only 1 row was affected
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
        {
            return Update();
        }
        return false;
    }

    public boolean Update() {
        if (Fetch()) { // make sure it exists
            try {
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                int retval = statement.executeUpdate("UPDATE gamesearcher.loginfails SET qty = " + ++qty + "WHERE loginfails.userEmail = '" + user_email + "';");
                statement.close();

                if (retval == 1) { // if only 1 row was affected
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
        {
            return Insert();
        }
        return false;
    }

    public boolean Delete() {
        if (Fetch()) { // make sure it exists
            try {
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                int retval = statement.executeUpdate("DELETE FROM gamesearcher.loginfails WHERE loginfails.userEmail = '" + user_email + "';");
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
        return true;
    }

    /// @return true if it exists
    private boolean Fetch() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.loginfails WHERE loginfails.userEmail = '" + user_email + "';");

            if (results.first()) {
                qty = results.getInt("qty");
                return true;
            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
