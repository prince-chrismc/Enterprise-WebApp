/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.UserAction;

/**
 *
 * @author cmcarthur
 */
public class UserActionTitle implements WebViewable {
    private UserAction action;

    public UserActionTitle(UserAction action) {
        this.action = action;
    }
        
    @Override
    public String toHTML() {
        switch(action)
        {
            case VIEW:
                return "Here's you information below!";
            case EDIT:
                return "Edit your information below...";
            default: 
                return "Your information is below.";
        }
    }
}
