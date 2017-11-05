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
public enum SearchCriteria {
    INVALID(0),
    NAME(1),
    ID(2),
    CONSOLE(3),
    GENRE(4),
    YEAR(5),
    DISCOUNT(6);
    
    private final int val;
    
    SearchCriteria(int val) {
        this.val = val;
    }
    
    public int getValue() {
        return val;
    }
    
    public String getValueAsString() {
        return String.valueOf(val);
    }
    
    public static SearchCriteria convert(int val) {
        for(SearchCriteria cri : SearchCriteria.values()) {
            if(cri.getValue() == val) return cri;
        }
        return INVALID;
    }
}
