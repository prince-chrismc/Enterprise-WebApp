/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Gateway.GameGateway;
import Models.Game;
import Models.Order;

/**
 *
 * @author cmcarthur
 */
public class OrderViewable implements WebViewable{
    private final Order order;

    public OrderViewable(Order order) {
        this.order = order;
    }

    @Override
    public String toHTML() {
        Game game = GameGateway.FindGameByID(order.getGameID());
        return "<tr><td>" + order.getUser_email() + "<td>" + game.getName() + 
               "</td><td>" + String.valueOf(order.getQty()) + "</td><td>" + order.getPurchaseDate() + "</td></tr>";
    }
    
    
}
