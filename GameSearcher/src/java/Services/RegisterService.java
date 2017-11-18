/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;

/**
 *
 * @author cmcarthur
 */
public class RegisterService {

    private User user;

    public RegisterService(String email, String password, String first, String last) {
        user = new User();

        user.setPassword(password);
        user.setFirst_name(first);
        user.setLast_name(last);
        user.setEmail(email);
    }

    public User getUser() {
        return user;
    }

}
