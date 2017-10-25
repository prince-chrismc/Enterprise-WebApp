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
        user.setUserName("admin");
        user.setPassword("admin");
    }

    public boolean isValidUser(String userName, String password){
        if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public User getUser(){
        return user;
    }
}
