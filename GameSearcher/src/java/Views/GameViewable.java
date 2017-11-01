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
public class GameViewable  {
    private Game game;
    
    public GameViewable(Game game) {
        this.game = game;
    }
    
    public String toHTML() {
        return "";
    }
}
