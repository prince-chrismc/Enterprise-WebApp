/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Models.CartEntry;
import Models.Order;
import Services.DatabaseConnection;
import Views.OrderViewable;
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
    
    public static ArrayList<OrderViewable> GetMostRecentOrders() {
        ArrayList<OrderViewable> orders = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.orders LIMIT 10;");

            while (results.next()) {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                orders.add(new OrderViewable(new Order(results.getInt("orderID"), results.getString("userEmail"), results.getInt("gameID"),
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
