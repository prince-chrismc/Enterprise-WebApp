/*
    MIT License

    Copyright (c) 2017 Chris Mc, prince.chrismc(at)gmail(dot)com

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
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
                return HandleSuccess();
            } else {
                HandleFail();
            }
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    private boolean HandleSuccess() {
        LoginFailedGateway logger = LoginFailedGateway.FindAttemptForUser(user.getEmail());
        logger.Delete(); // delete any unsuccessful attempts
        UserGateway gateway = new UserGateway(user);
        return gateway.UpdateLastLogin();
    }
    
    private void HandleFail() {
        LoginFailedGateway attempt = LoginFailedGateway.FindAttemptForUser(user.getEmail());
        attempt.Update();
        if (attempt.getQty() >= 3 && !user.isLocked()) {
            LockingService locker = new LockingService(user.getEmail());
            locker.Lock();
        }
    }
}
