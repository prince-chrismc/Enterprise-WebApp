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
            if (user.getPassword().equals(password)) {
                return true;
            }
            else {
                LoginFailedGateway attempt = LoginFailedGateway.FindAttemptForUser(user.getEmail());
                attempt.Update();
            }
        }
        return false;
    }

    public User getUser() {
        return user;
    }
}
