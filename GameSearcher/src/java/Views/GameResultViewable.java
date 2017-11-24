/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Game;

/**
 *
 * @author cmcarthur
 */
public class GameResultViewable implements WebViewable {
    private final Game game;
    
    public GameResultViewable(Game game) {
        this.game = game;
    }
    
    @Override
    public String toHTML() {
        return "<tr'><td>" + game.getGame_id() + "</td><td>" + game.getName() + 
               "</td><td>" + game.getConsolesArrayAsString() + "</td><td><a href='game?id=" + game.getGame_id() + 
               "'>Details</a></td></tr>";
    }
}
