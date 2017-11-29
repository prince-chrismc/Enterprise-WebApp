/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.OrderGateway;
import Gateway.UserGateway;
import Models.CartEntry;
import Models.CheckoutResult;
import Models.Order;
import Models.ShoppingCart;
import Models.User;
import Views.OrderViewable;
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

    public ArrayList<OrderViewable> getOrdersViewable() {
        ArrayList<OrderViewable> views = new ArrayList<>();
        
        for(Order order : orders) {
            views.add(new OrderViewable(order));
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
