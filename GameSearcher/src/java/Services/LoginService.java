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
            if (user.getPassword().equals(password) && !user.isLocked()) {
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
        if (attempt.getQty() > 3) {
            LockingService locker = new LockingService(user.getEmail());
            locker.Lock();
        }
        attempt.Update();
    }
}
