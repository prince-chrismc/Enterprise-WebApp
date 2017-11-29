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
public class LoginService {

    private User user;

    public LoginService(String email) {
        user = UserGateway.FindUserBasicInfoByEmail(email);
    }

    public boolean isValidUser(String password) {
        if (user != null) {
            if(user.isLocked()) return false;
            
            if (user.getPassword().equals(password) ) {
                LoginFailedGateway logger = LoginFailedGateway.FindAttemptForUser(user.getEmail());
                logger.Delete(); // delete any unsuccessful attempts
                return true;
            } else {
                HandleLogging();
            }
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    private void HandleLogging() {
        LoginFailedGateway attempt = LoginFailedGateway.FindAttemptForUser(user.getEmail());
        attempt.Update();
        if (attempt.getQty() >= 3 && !user.isLocked()) {
            LockingService locker = new LockingService(user.getEmail());
            locker.Lock();
        }
    }
}
