/*
    MIT License

    Copyright (c) 2017 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
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
public class CartItemView implements WebViewable {

    private final CartEntry entry;
    private final Game game;

    public CartItemView(CartEntry entry) {
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
        if (game.getRelease_date() == null) {
            return "Unknow";
        } else {
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
