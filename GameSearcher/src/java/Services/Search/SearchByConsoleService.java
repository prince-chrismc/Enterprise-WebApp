/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Search;

import Models.Console;
import Models.Game;
import Services.DatabaseConnection;
import Services.DatabaseConsoleConverter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class SearchByConsoleService {
    private ArrayList<Game> games;
    
    public SearchByConsoleService(String console_criteria) {
        games = new ArrayList<Game>();
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            
            String console_entry = "INVALID";
            for (Console console : Console.values()) {
                if(console.getConsole().equals(console_criteria)) console_entry = DatabaseConsoleConverter.getDatabaseEntry(console);
            }
            
            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.games WHERE gameConsoles LIKE '%" + console_entry + "%';"); // https://stackoverflow.com/a/4122201/8480874
            
            while(results.next()) {
                Game game = new Game();
                
                game.setGame_id(results.getInt("gameID"));
                game.setName(results.getString("gameName"));
                
                DatabaseConsoleConverter console_converter = new DatabaseConsoleConverter(results.getString("gameConsoles"));
                game.setConsoles(console_converter.getConsoles());
                
                games.add(game);
            }
            
            statement.close();
            results.close();
            
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
