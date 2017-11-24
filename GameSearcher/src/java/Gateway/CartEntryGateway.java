/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            
            
            while(results.next()) {
                cart.add(new CartEntry(results.getString("userEmail"), results.getInt("gameID"), results.getInt("qty")));
            }
            
            statement.close();
            results.close();            
            
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
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
            
            if(retval == 1) { // if only 1 row was affected
                return Fetch(); // make sure it exists
            }
            
            statement.close();
            
        } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
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

            int retval = statement.executeUpdate("UPDATE gamesearcher.carts SET qty = " + entry.getQty() + " WHERE carts.userEmail = '" + entry.getUse_email() + 
                    "' AND carts.gameID = " + entry.getGame_id() +";");
            
            if(retval == 1) { // if only 1 row was affected
                return true;
            }
            
            statement.close();
            
        } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    /// @return true if it exists
    private boolean Fetch() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.carts WHERE carts.userEmail = '" + entry.getUse_email() + "' AND carts.gameID = " + entry.getGame_id() +";");
            
            if (results.first()) {
                if(results.getInt("qty") != entry.getQty())
                {
                    entry = new CartEntry(results.getString("userEmail"), results.getInt("gameID"), results.getInt("qty"));
                }
                return true;
            }
            
            statement.close();
            results.close();
            
        } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public CartEntry getEntry() {
        Fetch();
        return entry;
    }
    
}
