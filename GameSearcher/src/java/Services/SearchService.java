/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Game;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author cmcarthur
 */
public class SearchService {
    Vector<Game> games;
    
    public SearchService(String name_criteria) {
        
        games = new Vector<Game>();
        
        /*try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            ResultSet results = statement.executeQuery("SELECT * FROM GAMES WHERE gameName LIKE '" + name_criteria + "';");
            
            while(results.next()) {
                Game game = new Game();
                
                
                games.add(game);
            }*/
            
            Game test = new Game();
            test.setName("test game");
            games.add(test);
            
        /*} catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }*/
    }
    
    public Vector<Game> getGames() {
        return games;
    }
}
