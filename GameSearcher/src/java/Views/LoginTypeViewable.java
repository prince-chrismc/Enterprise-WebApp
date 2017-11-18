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
            case LOGIN: return "<h2>You have successfully logged in!</h2>";
            case REGISTER: return "<h2>You have successfully registered in!</h2>";
            case ERROR: 
            default: return "<h2>Oh no! There was an error.</h2>";
        }
    }
}
