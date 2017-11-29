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
public class UserActionButton implements WebViewable{
    private UserAction action;

    public UserActionButton(UserAction action) {
        this.action = action;
    }
    
    @Override
    public String toHTML() {
        switch(action)
        {
            case EDIT:
                return "<div class='col-xs-offset-2 col-xs-10'>"
                        + "<input type='hidden' name='action' value='"+ UserAction.UPDATE+"'/>" +
                            "<div class='row'><input type='submit' value='Update' class='btn  btn-block' style='margin-bottom: 1em;'/></div>" +
                        "</div>";
            default: 
                return "";
        }
    }
    
}
