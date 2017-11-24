/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Gateway.GameGateway;
import Models.CartEntry;
import Models.Game;

/**
 *
 * @author cmcarthur
 */
public class CartItemViewable implements WebViewable {
    private CartEntry entry;
    
    public CartItemViewable(CartEntry entry) {
        this.entry = entry;
    }
    
    @Override
    public String toHTML() {
        Game game = GameGateway.FindGameByID(entry.getGame_id());
        return "<div class='row'  style='margin: 3em 1em'><div class='col-xs-3'>"
                + "<img src='" + game.getFront_box_art() + "' style='width: 100%;' style='height: 15em'>"
                + "</div><div class='col-xs-9'>"
                + "<h3>" + game.getName() + "</h3>"
                + "</div></div>";
    }
    
}
