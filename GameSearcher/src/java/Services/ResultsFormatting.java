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

    static public ArrayList<GameResultViewable> CreateViewableGameResults(ArrayList<Game> games) {
        ArrayList<GameResultViewable> gameViews = new ArrayList<GameResultViewable>();

        games.forEach((game) -> {
            gameViews.add(new GameResultViewable(game));
        });

        return gameViews;
    }
}
