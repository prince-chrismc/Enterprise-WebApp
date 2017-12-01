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

import Models.CartEntry;
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
public class CartEntryGateway {

    public static ArrayList<CartEntry> FindEntriesToUser(String user_email) {
        ArrayList<CartEntry> cart = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.carts WHERE carts.userEmail = '" + user_email + "';");

            while (results.next()) {
                cart.add(new CartEntry(results.getString("userEmail"), results.getInt("gameID"), results.getInt("qty")));
            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cart;
    }

    // Beginning of non-static section
    private CartEntry entry;

    public CartEntryGateway(CartEntry entry) {
        this.entry = entry;
    }

    public boolean Insert() {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("INSERT INTO gamesearcher.carts(userEmail,gameID,qty)VALUES('" + entry.getUse_email() + "'," + entry.getGame_id() + "," + entry.getQty() + ");");

            statement.close();

            if (retval == 1) { // if only 1 row was affected
                return Fetch(); // make sure it exists
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public boolean Update(int add_quanty) {
        Fetch(); // make sure up to date with DB
        entry.addQuantity(add_quanty);

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("UPDATE gamesearcher.carts SET qty = " + entry.getQty() + " WHERE carts.userEmail = '" + entry.getUse_email()
                    + "' AND carts.gameID = " + entry.getGame_id() + ";");

            if (retval == 1) { // if only 1 row was affected
                return true;
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public boolean Delete() {
        if (Fetch()) { // make sure it exists
            try {
                Connection conn = DatabaseConnection.getConnection();
                Statement statement = conn.createStatement();

                int retval = statement.executeUpdate("DELETE FROM gamesearcher.carts WHERE carts.userEmail = '" + entry.getUse_email()
                        + "' AND carts.gameID = " + entry.getGame_id() + ";");

                if (retval == 1) { // if only 1 row was affected
                    return true;
                }

                statement.close();

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

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.carts WHERE carts.userEmail = '" + entry.getUse_email() + "' AND carts.gameID = " + entry.getGame_id() + ";");

            if (results.first()) {
                if (results.getInt("qty") != entry.getQty()) {
                    entry = new CartEntry(results.getString("userEmail"), results.getInt("gameID"), results.getInt("qty"));
                }
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

    public CartEntry getEntry() {
        Fetch();
        return entry;
    }

}
