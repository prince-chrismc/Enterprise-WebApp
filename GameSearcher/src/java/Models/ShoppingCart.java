/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Gateway.CartEntryGateway;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author cmcarthur
 */
public class ShoppingCart {
    private final HashMap entries; // <int, CartEntryGateway>
    private final String user_email;
    
    public ShoppingCart(String user_email) {
        this.user_email = user_email;
        entries = new HashMap();
        
        for(CartEntry entry : CartEntryGateway.FindEntriesToUser(user_email)) {
            entries.put(entry.getGame_id(), new CartEntryGateway(entry));
        }
    }
    
    public boolean addToCart(int game_id, int qty) {
        boolean retval = false;
        if(entries.containsKey(game_id)) {
            retval =((CartEntryGateway)entries.get(game_id)).Update(qty);
        }
        else {
            entries.put(game_id, new CartEntryGateway(new CartEntry(user_email, game_id, qty)));
            retval =((CartEntryGateway)entries.get(game_id)).Insert();
        }
        return retval;
    }
    
    public boolean removeFromCart(int game_id) {
        return ((CartEntryGateway)entries.remove(game_id)).Delete();
    }
    
    public boolean clearCart() {
        boolean retval = true;
        Iterator it = entries.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            retval &= ((CartEntryGateway)pair.getValue()).Delete();
            it.remove();
        }
        return retval;
    }
    
    public ArrayList<CartEntry> getEntries() {
        ArrayList<CartEntry> temp = new ArrayList<>();
        Iterator it = entries.entrySet().iterator();          // https://stackoverflow.com/a/1066603/8480874
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            temp.add(((CartEntryGateway)pair.getValue()).getEntry());
            it.remove();
        }
        return temp;
    }

    public String getUser_email() {
        return user_email;
    }
    
}
