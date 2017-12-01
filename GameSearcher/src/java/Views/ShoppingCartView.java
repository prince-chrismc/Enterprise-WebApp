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

import Models.CartAction;
import Models.CartEntry;
import Models.ShoppingCart;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author cmcarthur
 */
public class ShoppingCartView implements WebViewable {

    private final ShoppingCart cart;

    public ShoppingCartView(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toHTML() {
        NumberFormat formatter = new DecimalFormat("#0.00");

        String output = "<div class='row'>"
                + "<div class='col-xs-8'>";

        double sum_price = 0.0;
        double sum_discount = 0.0;
        double num = 0.0;
        for (CartEntry item : cart.getEntries()) {
            CartItemViewable item_view = new CartItemViewable(item);
            output += item_view.toHTML();
            sum_price += item_view.getPrice();
            sum_discount += item_view.getDiscount();
            num += 1.0;
        }
        double taxes = 0.18 * (sum_price - sum_discount);
        double snh = 1.57 * num;
        output += "</div><div class='col-xs-4'><div class='row'>"
                + "<h3><b>Cost: $" + String.valueOf(formatter.format(sum_price)) + "</b></h3>"
                + "<h4>  Savings: $" + String.valueOf(formatter.format(sum_discount)) + "</h4>"
                + "<h4>  Taxes: $" + String.valueOf(formatter.format(taxes)) + "</h4>"
                + "<h4>  S & H: $" + String.valueOf(formatter.format(snh)) + "</h4>"
                + "<hr>"
                + "<h2><b>Total: $" + String.valueOf(formatter.format(sum_price - sum_discount + taxes + snh)) + "</b></h2></div>"
                + "<div class='row' style='margin: 0.5em -15px;'><form action='index.jsp' method='post'><input type='submit' value='Continue Shopping' class='btn btn-block'/></form></div>"
                + "<div class='row' style='margin: 0.5em -15px;'><form action='cart' method='post'><input type='hidden' name='user_email' value='" + cart.getUser_email() + "'/><input type='hidden' name='action' value='" + CartAction.CHECKOUT + "'/><input type='submit' value='Checkout' class='btn btn-block'/></form></div>"
                + "<div class='row' style='margin: 0.5em -15px;'><form action='cart' method='post'><input type='hidden' name='user_email' value='" + cart.getUser_email() + "'/><input type='hidden' name='action' value='" + CartAction.CLEAR + "'/><input type='submit' value='Clear Cart' class='btn btn-block btn-warning'/></form></div>"
                + "</div></div>";

        return output;
    }

}
