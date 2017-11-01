/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Game;
import Views.GameViewable;
import java.util.Vector;

/**
 *
 * @author cmcarthur
 */
public class ResultsFormatting {
    static public Vector<GameViewable> CreateViewableGames(Vector<Game> games) {
        Vector<GameViewable> gameViews = new Vector<GameViewable>();
        
        for (int index = 0; index < games.size(); index += 1) {
            gameViews.add(new GameViewable(games.get(index)));
        }
        
        return gameViews;
    }
}
