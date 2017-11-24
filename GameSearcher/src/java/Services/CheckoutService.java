/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.CheckoutResult;
import Models.ShoppingCart;

/**
 *
 * @author cmcarthur
 */
public class CheckoutService {
    private final ShoppingCart cart;
    
    public CheckoutService(ShoppingCart cart) {
        this.cart = cart;
    }
    
    public CheckoutResult performCheckout() {
        MailMachine mailer = new MailMachine();
        mailer.sendMessage();
        return new CheckoutResult(cart.getEntries(), 0.0);
    }
}
