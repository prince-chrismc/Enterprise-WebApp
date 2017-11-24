/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.CartEntry;
import Models.ShoppingCart;

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
        String output = "<div class='row'>" +
"                <div class='col-xs-8'>";
        
        for(CartEntry item : cart.getEntries()) {
            output += (new CartItemViewable(item)).toHTML();
        }
        
      output += "</div>" +
"                <div class='col-xs-4'>\n" +
"                    <div class='row'>\n" +
"                        <h3>Total: </h3>\n" +
"                        \n" +
"                        \n" +
"                    </div>\n" +
"                    \n" +
"                    \n" +
"                </div>\n" +
"            </div>";
        
        
        
        return output;
    }

    private Object CartItemViewable(CartEntry item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
