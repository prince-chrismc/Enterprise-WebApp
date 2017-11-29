/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.LoginFailedGateway;
import Gateway.UserGateway;
import Models.User;

/**
 *
 * @author cmcarthur
 */
public class LockingService {
    private String user_email;

    public LockingService(String user_email) {
        this.user_email = user_email;
    }
    
    public boolean Lock() {
        User user = UserGateway.FindUserCompleteByEmail(user_email);
        if(user.isAdmin()) return false; // cant lock an admin
        
        user.setIsLocked(true);
        UserGateway user_gateway = new UserGateway(user);
        return user_gateway.Update();
    }
    
    public boolean Unlock() {
        LoginFailedGateway log = new LoginFailedGateway(user_email, 0);
        log.Delete();
        User user = UserGateway.FindUserCompleteByEmail(user_email);
        user.setIsLocked(false);
        UserGateway user_gateway = new UserGateway(user);
        return user_gateway.Update();
        
    }
}
