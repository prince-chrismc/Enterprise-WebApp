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
package Services;

import Gateway.OrderGateway;
import Gateway.UserGateway;
import Models.CartEntry;
import Models.CheckoutResult;
import Models.Order;
import Models.ShoppingCart;
import Models.User;
import Views.OrderView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cmcarthur
 */
public class CheckoutService {

    private final ShoppingCart cart;
    private ArrayList<Order> orders;

    public CheckoutService(ShoppingCart cart) {
        this.cart = cart;
        orders = new ArrayList<>();
    }

    public CheckoutResult performCheckout() {

        if (!doesUserHaveValidCreditcard()) {
            return new CheckoutResult("Invalid credit card information");
        }

        int counter = 0;
        for (CartEntry entry : cart.getEntries()) {
            OrderGateway new_order = new OrderGateway(entry);
            new_order.Insert();
            DateFormat dateFormat = new SimpleDateFormat();
            orders.add(new Order(0, cart.getUser_email(), entry.getGame_id(), entry.getQty(), dateFormat.format(new Date())));
            counter++;
        }

        CheckoutResult result = new CheckoutResult(cart.getEntries(), 0.0);

        MailMachine mailer = MailMachine.getInstance();
        mailer.sendMessage(cart.getUser_email(), "Your purchase receipt", "You bought " + String.valueOf(counter) + " games. Thank you very much for shopping at our E-Store! =)\n"
                + "Your order will arrive on: " + result.getEta().toString() + ".\n");

        cart.clearCart();
        return result;
    }

    public ArrayList<OrderView> getOrdersViewable() {
        ArrayList<OrderView> views = new ArrayList<>();

        for (Order order : orders) {
            views.add(new OrderView(order));
        }

        return views;
    }

    private boolean doesUserHaveValidCreditcard() {
        User user = UserGateway.FindUserCompleteByEmail(cart.getUser_email());

        if (user == null) {
            System.out.println("user is null =?");
            System.out.println(cart.getUser_email());
        }

        if (user.getCredit_card_number() == null
                || user.getCredit_card_cvv() == null
                || user.getCredit_card_expiry() == null) {
            return false;
        }

        if (user.getCredit_card_number().isEmpty()
                || user.getCredit_card_cvv().isEmpty()
                || user.getCredit_card_expiry().isEmpty()) {
            return false;
        }

        if (user.getCredit_card_number().length() < 10) {
            return false;
        }

        if (!user.getCredit_card_number().matches("[0-9]+")) {
            return false;
        }

        return true;
    }
}
