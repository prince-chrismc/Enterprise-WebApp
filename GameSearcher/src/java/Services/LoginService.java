/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.UserGateway;
import Models.User;

/**
 *
 * @author cmcarthur
 */
public class LoginService {
    private User user;

    public LoginService(){
        
    }

    public boolean isValidUser(String email, String password) {
        user = UserGateway.FindUserByEmail(email);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(){
        return user;
    }
}
