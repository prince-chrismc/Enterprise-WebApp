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

        for (CartEntry entry : CartEntryGateway.FindEntriesToUser(user_email)) {
            entries.put(entry.getGame_id(), new CartEntryGateway(entry));
        }
    }

    public boolean addToCart(int game_id, int qty) {
        boolean retval = false;
        if (entries.containsKey(game_id)) {
            retval = ((CartEntryGateway) entries.get(game_id)).Update(qty);
        } else {
            entries.put(game_id, new CartEntryGateway(new CartEntry(user_email, game_id, qty)));
            retval = ((CartEntryGateway) entries.get(game_id)).Insert();
        }
        return retval;
    }

    public boolean removeFromCart(int game_id) {
        return ((CartEntryGateway) entries.remove(game_id)).Delete();
    }

    public boolean clearCart() {
        boolean retval = true;
        Iterator it = entries.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            retval &= ((CartEntryGateway) pair.getValue()).Delete();
            it.remove();
        }
        return retval;
    }

    public ArrayList<CartEntry> getEntries() {
        ArrayList<CartEntry> temp = new ArrayList<>();
        Iterator it = entries.entrySet().iterator();          // https://stackoverflow.com/a/1066603/8480874
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            temp.add(((CartEntryGateway) pair.getValue()).getEntry());
        }
        return temp;
    }

    public String getUser_email() {
        return user_email;
    }

}
