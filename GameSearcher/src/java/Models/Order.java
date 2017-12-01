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
