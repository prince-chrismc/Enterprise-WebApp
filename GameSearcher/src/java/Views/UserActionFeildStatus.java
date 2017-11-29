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
public class UserActionFeildStatus implements WebViewable{
    private UserAction action;

    public UserActionFeildStatus(UserAction action) {
        this.action = action;
    }
        
    @Override
    public String toHTML() {
        switch(action)
        {
            case VIEW:
                return "disabled";
            case EDIT:
                return "";
            default: 
                return "disabled";
        }
    }
}
