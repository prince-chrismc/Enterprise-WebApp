/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.AdminAction;
import Models.Game;

/**
 *
 * @author cmcarthur
 */
public class DiscountedGameResultView implements WebViewable{
    private final Game game;
    
    public DiscountedGameResultView(Game game) {
        this.game = game;
    }
    
    @Override
    public String toHTML() {
        return "<tr'><td>" + game.getGame_id() + "</td><td>" + game.getName() + 
               "</td><td>" + game.getConsolesArrayAsString() + "</td><td><a href='admin?action=" + AdminAction.GAME_TOGGLE_DISC +"&id=" + game.getGame_id() + 
               "'>" + GetToggleTo() + "</a></td></tr>";
    }
    
    private String GetToggleTo() {
        if(game.getDiscount() < 0.0)
            return "Public";
        else
            return "Users Only";
    }
}
