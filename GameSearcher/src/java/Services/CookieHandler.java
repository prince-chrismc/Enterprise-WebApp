/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmcarthur
 */
public class CookieHandler {

    static public void ForwardUser(HttpServletRequest request, HttpServletResponse response) {
        SetNewCookie(response, GetUserEmail(request));
    }

    static public String GetUserEmail(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("gamesearcher_user")) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    static public void SetNewCookie(HttpServletResponse response, String email) {
        Cookie cookie = new Cookie("gamesearcher_user", email);
        cookie.setMaxAge(60 * 30);
        response.addCookie(cookie);
    }

    static public void DeleteCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("gamesearcher_user")) {
                    cookie.setMaxAge(0);
                }
            }
        }
    }

}
