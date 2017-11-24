/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cmcarthur
 */
public class CheckoutResult {
    public enum Outcome {
        SUCCESS,
        ERROR;
    }
    
    private final Outcome result;
    private final String desc;
    private final ArrayList<CartEntry> entries;
    private final double final_price;
    private final Date eta;

    // When in error
    public CheckoutResult(String desc) {
        result = Outcome.ERROR;
        this.desc = desc;
        entries = null;
        final_price = 0.0;
        eta = null;
    }
    
    // When successful
    public CheckoutResult(ArrayList<CartEntry> entries, double final_price) {
        result = Outcome.SUCCESS;
        desc = "Checkout Successful!";
        this.entries = entries;
        this.final_price = final_price;
        eta = new Date(new Date().getTime() + 5*(1000*60*60*24));
    }    
    
    public boolean isSuccess() {
        return result == Outcome.SUCCESS;
    }
}
