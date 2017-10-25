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
public class LoginService {
    private User user;

    public LoginService(){
        user = new User();
        user.setUser_id(1);
        user.setPassword("admin");
    }

    public boolean isValidUser(int userID, String password){
        if(userID == user.getUser_id() && password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public User getUser(){
        return user;
    }
}
