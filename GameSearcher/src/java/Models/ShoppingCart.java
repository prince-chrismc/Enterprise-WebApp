/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Gateway.CartEntryGateway;
import java.util.AbstractMap;

/**
 *
 * @author cmcarthur
 */
public class ShoppingCart {
    private AbstractMap entries; // <int, CartEntryGateway>
    private final String user_email;
    
    public ShoppingCart(String user_email) {
        this.user_email = user_email;
        
        CartEntryGateway.FindEntriesToUser(user_email).forEach((entry) -> {
            entries.put(entry.getGame_id(), new CartEntryGateway(entry));
        });
    }
    
    public boolean addToCart(int game_id, int qty) {
        boolean retval;
        if(entries.containsKey(game_id)) {
            retval =((CartEntryGateway)entries.get(game_id)).Update(qty);
        }
        else {
            entries.put(game_id, new CartEntryGateway(new CartEntry(user_email, game_id, qty)));
            retval =((CartEntryGateway)entries.get(game_id)).Insert();
        }
        return retval;
    }

    public AbstractMap getEntries() {
        return entries;
    }

    public String getUser_email() {
        return user_email;
    }
    
}
