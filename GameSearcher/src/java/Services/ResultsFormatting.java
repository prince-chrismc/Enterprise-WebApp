/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Game;
import Views.GameResultViewable;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class ResultsFormatting {
    static public ArrayList<GameResultViewable> CreateViewableGames(ArrayList<Game> games) {
        ArrayList<GameResultViewable> gameViews = new ArrayList<GameResultViewable>();
        
        for (int index = 0; index < games.size(); index += 1) {
            gameViews.add(new GameResultViewable(games.get(index)));
        }
        
        return gameViews;
    }
}
