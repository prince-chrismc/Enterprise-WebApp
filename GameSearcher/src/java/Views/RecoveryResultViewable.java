/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.RecoveryResult;

/**
 *
 * @author cmcarthur
 */
public class RecoveryResultViewable implements WebViewable {
    private final RecoveryResult result;

    public RecoveryResultViewable(RecoveryResult result) {
        this.result = result;
    }
        
    @Override
    public String toHTML() {
        switch(result)
        {
            case SUCCESS:
                return "<h1>Check you emails for a temp password</h1>";
            case USER_DNE:
                return "<h1>The email specified does not belong to a user, try registering</h1>";
            case SYS_ERR:
                return "<h1>there was a system error, try contating the admin for help</h1>";
            default:
                return "";
        }
    }
    
    
}
