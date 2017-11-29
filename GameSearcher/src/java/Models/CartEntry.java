/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author cmcarthur
 */
public class CartEntry {

    private final String use_email;
    private final int game_id;
    private int qty;

    public CartEntry(String use_email, int game_id) {
        this.use_email = use_email;
        this.game_id = game_id;
        qty = 1;
    }

    public CartEntry(String use_email, int game_id, int qty) {
        this.use_email = use_email;
        this.game_id = game_id;
        this.qty = qty;
    }

    public int getGame_id() {
        return game_id;
    }

    public int getQty() {
        return qty;
    }

    public String getUse_email() {
        return use_email;
    }

    public void addQuantity(int qty) {
        this.qty += qty;
    }
}
