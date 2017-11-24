/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.CheckoutResult;

/**
 *
 * @author cmcarthur
 */
public class CheckoutView implements WebViewable {
    private final CheckoutResult result;

    public CheckoutView(CheckoutResult result) {
        this.result = result;
    }
       
    @Override
    public String toHTML() {
        if(result.isSuccess())
            return "<h1>You have received email confirmation about your order.</h1>";
        else
            return "<h1>There was an issue processing your order due to: " + result.getDesc() + ".</h1>";
    }
    
}
