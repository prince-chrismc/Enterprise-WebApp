/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.UserGateway;
import Models.CheckoutResult;
import Models.ShoppingCart;
import Models.User;

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
    
    private boolean doesUserHaveValidCreditcard() {
        User user = UserGateway.FindUserCompleteByEmail(cart.getUser_email());
        
        if(user == null)
        {
            System.out.println("user is null =?");
            System.out.println(cart.getUser_email());
        }
        
        if(user.getCredit_card_number() == null ||
                user.getCredit_card_cvv() == null ||
                user.getCredit_card_expiry() == null )
            return false;
        
        if(user.getCredit_card_number().isEmpty() ||
                user.getCredit_card_cvv().isEmpty() ||
                user.getCredit_card_expiry().isEmpty() )
            return false;
        
        if(user.getCredit_card_number().length() < 10)
            return false;
        
        if(! user.getCredit_card_number().matches("[0-9]+"))
            return false;
        
        return true;
    }
}
