/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cmcarthur
 * @inspiration https://stackoverflow.com/a/10916633/8480874
 */
public class DatabaseConnection {
    private static final String urlstring = "jdbc:mysql://localhost:3306/gamesearcher";    
    private static final String driverName = "com.mysql.jdbc.Driver";   
    private static final String username = "root";   
    private static final String password = "Acertuba";
    
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
