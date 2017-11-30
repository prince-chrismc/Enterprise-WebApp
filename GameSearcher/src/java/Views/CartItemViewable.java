/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Gateway.GameGateway;
import Models.CartAction;
import Models.CartEntry;
import Models.Game;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author cmcarthur
 */
public class CartItemViewable implements WebViewable {
    private final CartEntry entry;
    private final Game game;
    
    public CartItemViewable(CartEntry entry) {
        this.entry = entry;
        game = GameGateway.FindGameByID(entry.getGame_id());
    }
    
    @Override
    public String toHTML() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return "<div class='row' style='margin: 3em 1em;'><div class='col-xs-3' style='min-height: 15em'>"
                + "<img src='" + game.getFront_box_art() + "' style='width: 100%;'>"
                + "</div><div class='col-xs-9'>"
                + "<h3>" + game.getName() + "</h3>"
                + "<p> Developer: " + game.getDeveloper() + "</p>"
                + "<p> Released: " + getDate() + " for " + game.getConsolesArrayAsString() + "</p>"
                + "<p> Quantity: " + String.valueOf(entry.getQty()) + " Price (sum): $" + String.valueOf(formatter.format(getPrice() - getDiscount())) + "</p>"
                + "<div>" + getMinusButton() + getPlusButton() + getRemoveButton() + "</div></div></div>";
    }
    
    private String getDate() {
        if(game.getRelease_date() == null) return "Unknow";
        else {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            return df.format(game.getRelease_date());
        }
    }
    
    private String getMinusButton() {
        return "<form action='cart' method='POST' style='display: inline'>"
                + "<button type='submit' class='btn btn-default btn-sm" + ((entry.getQty() <= 1) ? " disabled" : "") + "' style='width: 30px;'>-</button>"
                + "<input type='hidden' name='user_email' value='" + entry.getUse_email() + "'/>"
                + "<input type='hidden' name='game_id' value='" + String.valueOf(entry.getGame_id()) + "'/>"
                + "<input type='hidden' name='action' value='" + CartAction.ADD + "'/>"
                + "<input type='hidden' name='qty' value='-1'/>"
                + "</form>";
    }
    
    private String getPlusButton() {
        return "<form action='cart' method='POST' style='display: inline'>"
                + "<button type='submit' class='btn btn-default btn-sm' style='width: 30px;'>+</button>"
                + "<input type='hidden' name='user_email' value='" + entry.getUse_email() + "'/>"
                + "<input type='hidden' name='game_id' value='" + String.valueOf(entry.getGame_id()) + "'/>"
                + "<input type='hidden' name='action' value='" + CartAction.ADD + "'/>"
                + "<input type='hidden' name='qty' value='1'/>"
                + "</form>";
    }
    
    private String getRemoveButton() {
        return "<form action='cart' method='POST' style='display: inline'>"
                + "<button type='submit' class='btn btn-default btn-sm'>remove</button>"
                + "<input type='hidden' name='user_email' value='" + entry.getUse_email() + "'/>"
                + "<input type='hidden' name='game_id' value='" + String.valueOf(entry.getGame_id()) + "'/>"
                + "<input type='hidden' name='action' value='" + CartAction.REMOVE + "'/>"
                + "</form>";
    }
    
    public double getPrice() {
        return entry.getQty() * game.getPrice();
    }
    
    public double getDiscount() {
        return entry.getQty() * Math.abs(game.getDiscount());
    }
}
