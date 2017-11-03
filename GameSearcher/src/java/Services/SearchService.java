/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Game;
import Views.GameResultViewable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class SearchService {
    ArrayList<Game> games; // https://stackoverflow.com/a/2986307/8480874 for dynamic size
    
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
                
                DatabaseConsoleConverter console_converter = new DatabaseConsoleConverter(results.getString("gameConsoles"));
                game.setConsoles(console_converter.getConsoles());
                
                
                
                games.add(game);
            }
            
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
    public ArrayList<GameResultViewable> getViewableResults() {
        return ResultsFormatting.CreateViewableGameResults(games);
    }
}
