/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import Models.CartEntry;
import java.util.ArrayList;

/**
 *
 * @author cmcarthur
 */
public class CartEntryGateway {
    public static ArrayList<CartEntry> FindEntriesToUser(String user_email) {
        
        // "SELECT * FROM gamesearcher.carts WHERE carts.userEmail = '" + user_email + "';"
        return null;
    }
    
    // Beginning of non-static 
    private CartEntry entry;
    
    public CartEntryGateway(CartEntry entry) {
        this.entry = entry;
    }
    
    public boolean Insert() {
        return false;
    }
    
    public boolean Update(int add_quanty) {
        Fetch();
        entry.addQuantity(add_quanty);
        
        
        return false;
    }
    
    private void Fetch() {
        // "SELECT * FROM gamesearcher.carts WHERE carts.userEmail = '" + entry.getUse_email() + "' AND carts.gameID = "+ entry.getGame_id() +";"
    }
}
