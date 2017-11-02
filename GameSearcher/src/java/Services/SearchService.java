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
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author cmcarthur
 */
public class SearchService {
    ArrayList<Game> games; // https://stackoverflow.com/a/2986307/8480874
    
    public SearchService(String name_criteria) {
        
        games = new ArrayList<Game>();
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.games WHERE gameName LIKE '%" + name_criteria + "%';"); // https://stackoverflow.com/a/4122201/8480874
            
            while(results.next()) {
                Game game = new Game();
                
                game.setGame_id(results.getInt("gameID"));
                game.setName(results.getString("gameName"));
                
                
                
                games.add(game);
            }
            
            /*Game test = new Game();
            test.setName("test game");
            games.add(test);*/
            
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public ArrayList<Game> getGames() {
        return games;
    }
}
