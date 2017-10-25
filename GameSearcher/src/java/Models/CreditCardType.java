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
public enum CreditCardType {
    VISA("VISA"),
    MASTERCARD("MASTERCARD");
    
    private final String credit_card;
    
    CreditCardType(String type) {
        this.credit_card = type;
    }
    
    public String getType() {
        return this.credit_card;
    }
    
    /* Iteration Eample
        for (CreditCardType type : CreditCardType.values()) {
            System.out.println(type);
        }
    */
}
