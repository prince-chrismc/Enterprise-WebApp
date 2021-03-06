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

import Models.Game;
import Services.DatabaseConnection;
import Services.DatabaseConsoleConverter;
import Services.DatabaseGenreConverter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cmcarthur
 */
public class GameGateway {

    static public Game FindGameByID(int id_criteria) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.games WHERE gameID = " + id_criteria + ";");

            Game game = null;
            if (results.first()) {
                game = new Game();

                game.setGame_id(results.getInt("gameID"));
                game.setName(results.getString("gameName"));
                game.setDescription(results.getString("gameDesc"));
                DatabaseConsoleConverter console_converter = new DatabaseConsoleConverter(results.getString("gameConsoles"));
                game.setConsoles(console_converter.getConsoles());
                game.setNum_players(results.getInt("gamePlayers"));
                game.setCoop(results.getBoolean("gameCoop"));
                DatabaseGenreConverter genre_converter = new DatabaseGenreConverter(results.getString("gameGenres"));
                game.setGenres(genre_converter.getGenres());
                game.setRelease_date(results.getDate("gameReleaseDate")); // https://stackoverflow.com/a/24737131/8480874
                game.setDeveloper(results.getString("gameDeveloper"));
                game.setPublisher(results.getString("gamePublisher"));
                game.setFront_box_art(results.getString("gameFrontArtUrl"));
                game.setBack_box_art(results.getString("gameBackArtUrl"));
                game.setLogo(results.getString("gameLogoArtUrl"));
                game.setDeveloper_logo(results.getString("gameDevLogoArtUrl"));
                game.setPrice(results.getDouble("gamePrice"));
                game.setDiscount(results.getDouble("gameDiscount"));
            }

            statement.close();
            results.close();

            return game;

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    // beginning of none static section
    private Game game;

    public GameGateway(Game game) {
        this.game = game;
        Fetch();
    }

    public GameGateway(int id) {
        this.game = FindGameByID(id);
    }

    public boolean Update() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            int retval = statement.executeUpdate("UPDATE gamesearcher.games "
                    + "SET "
                    + "gameName = '" + game.getName() + "', "
                    + "gameDesc = \"" + game.getDescription() + "\", "
                    + "gamePlayers = " + String.valueOf(game.getNum_players()) + ", "
                    + "gameCoop = " + String.valueOf(game.isCoop()) + ", "
                    + "gameDeveloper = \"" + game.getDeveloper() + "\", "
                    + "gamePublisher = '" + game.getPublisher() + "', "
                    + "gamePrice = " + String.valueOf(game.getPrice()) + ", "
                    + "gameDiscount = " + String.valueOf(game.getDiscount()) + " "
                    + "WHERE gameID = " + String.valueOf(game.getGame_id()) + ";"
            );

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

    // @return ture is the game exists
    private boolean Fetch() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM gamesearcher.games WHERE gameID = " + String.valueOf(game.getGame_id()) + ";");

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

    public boolean ToogleDiscount() {
        game.setDiscount(game.getDiscount() * -1);
        return Update();
    }

}
