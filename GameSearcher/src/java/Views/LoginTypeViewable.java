/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.LoginType;

/**
 *
 * @author cmcarthur
 */
public class LoginTypeViewable implements WebViewable{
    private LoginType type;
    
    public LoginTypeViewable(LoginType type) {
        this.type = type;
    }

    @Override
    public String toHTML() {
        switch(type)
        {
            case LOGIN: return "You have successfully logged in!";
            case REGISTER: return "You have successfully registered in!";
            case ERROR: 
            default: return "Oh no! There was an error.";
        }
    }
}
