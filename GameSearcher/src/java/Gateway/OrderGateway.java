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
import Models.Order;
import Services.DatabaseConnection;
import Views.OrderView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class OrderGateway {

    public static ArrayList<CartEntry> FindEntriesToUser(String user_email) {
        ArrayList<CartEntry> cart = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.orders WHERE orders.userEmail = '" + user_email + "';");

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

    public static ArrayList<OrderView> GetMostRecentOrders() {
        ArrayList<OrderView> orders = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.orders LIMIT 10;");

            while (results.next()) {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                orders.add(new OrderView(new Order(results.getInt("orderID"), results.getString("userEmail"), results.getInt("gameID"),
                        results.getInt("qty"), df.format(results.getDate("purchaseDate")))));
            }

            statement.close();
            results.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return orders;
    }

    // Beginning of non-static section
    private CartEntry entry;

    public OrderGateway(CartEntry entry) {
        this.entry = entry;
    }

    public boolean Insert() {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("INSERT INTO gamesearcher.orders(userEmail,gameID,qty)VALUES('" + entry.getUse_email() + "'," + entry.getGame_id() + "," + entry.getQty() + ");");

            if (retval == 1) { // if only 1 row was affected
                return Fetch(); // make sure it exists
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    /// @return true if it exists
    private boolean Fetch() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.orders WHERE orders.userEmail = '" + entry.getUse_email() + "' AND orders.gameID = " + entry.getGame_id() + ";");

            if (results.first()) {
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
