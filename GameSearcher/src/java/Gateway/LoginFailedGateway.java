/*
    MIT License

    Copyright (c) 2017 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
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

    public int getQty() {
        return qty;
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
        } else {
            return Update();
        }
        return false;
    }

    public boolean Update() {
        if (Fetch()) { // make sure it exists
            try {
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                int retval = statement.executeUpdate("UPDATE gamesearcher.loginfails SET qty = " + String.valueOf(++qty) + ", attemptDate = current_timestamp WHERE loginfails.userEmail = '" + user_email + "';");
                statement.close();

                if (retval == 1) { // if only 1 row was affected
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
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
