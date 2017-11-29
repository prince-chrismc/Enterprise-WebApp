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
public class Order {
    private final int orderID;
    private final String user_email;
    private final int gameID;
    private final int qty;
    private final String purchaseDate;

    public Order(int orderID, String user_email, int gameID, int qty, String purchaseDate) {
        this.orderID = orderID;
        this.user_email = user_email;
        this.gameID = gameID;
        this.qty = qty;
        this.purchaseDate = purchaseDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getQty() {
        return qty;
    }

    public String getUser_email() {
        return user_email;
    }  
}
