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
        MailMachine mailer = MailMachine.getInstance();
        mailer.sendMessage("prince.chrismc@gmail.com", "testing singleton", "this is the singleton test =)");
        return new CheckoutResult(cart.getEntries(), 0.0);
    }
}
