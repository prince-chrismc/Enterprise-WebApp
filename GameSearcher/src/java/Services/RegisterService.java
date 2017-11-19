/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.UserGateway;
import Models.CreditCardType;
import Models.User;

/**
 *
 * @author cmcarthur
 */
public final class RegisterService {

    private User user;

    public RegisterService(String email, String password, String first, String last) {
        user = new User();

        AddBasicInformation(email, password, first, last);
        
        if(!new UserGateway(user).InsertBasic())  // if insert fails
            user = null;                          // unset
    }
    
    public RegisterService(String email, String password, String first, String last, 
                           String addr1, String addr2, String city, String state, String zip, String country, 
                           String type, String number, String cvv, String exp) {
        user = new User();

        AddBasicInformation(email, password, first, last);
        AddLocationInformation(addr1, addr2, city, state, zip, country);
        AddCardInformation(type, number, cvv, exp);
        
        if(!new UserGateway(user).InsertComplete()) // if insert fails
            user = null;                             // unset
    }
    
    void AddBasicInformation(String email, String password, String first, String last) {
        user.setPassword(password);
        user.setFirst_name(first);
        user.setLast_name(last);
        user.setEmail(email);
    }
    
    void AddLocationInformation(String addr1, String addr2, String city, String state, String zip, String country) {
        if(!addr1.isEmpty()) user.setAddress1(addr1);
        if(!addr2.isEmpty()) user.setAddress2(addr2);
        if(!city.isEmpty()) user.setCity(city);
        if(!state.isEmpty()) user.setState(state);
        if(!zip.isEmpty()) user.setZip(zip);
        if(!country.isEmpty()) user.setCountry(country);

    }
    
    void AddCardInformation(String type, String number, String cvv, String exp) {
        // TODO is empty check
        user.setCredit_card_type(CreditCardType.VISA);
        user.setCredit_card_number(number);
        user.setCredit_card_cvv(cvv);
        user.setCredit_card_expiry(exp);
    }

    public User getUser() {
        return user;
    }

}
