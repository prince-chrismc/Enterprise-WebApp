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
public class GameResultViewable  {
    private Game game;
    
    public GameResultViewable(Game game) {
        this.game = game;
    }
    
    public String toHTML() {
        return "";
    }
}