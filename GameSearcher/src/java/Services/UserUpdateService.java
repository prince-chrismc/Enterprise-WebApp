/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Gateway.UserGateway;
import Models.CreditCardType;
import Models.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cmcarthur
 */
public class UserUpdateService {

    private HttpServletRequest request;

    public UserUpdateService(HttpServletRequest request) {
        this.request = request;
    }

    public boolean UpdateAllFeilds() {
        int uid = Integer.parseInt(request.getParameter("uid"));
        String email = request.getParameter("email");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String number = request.getParameter("number");
        String cvv = request.getParameter("cvv");
        String exp = request.getParameter("exp");

        User user = new User(uid, "", first, last, email, addr1, addr2, city, state, zip, country, CreditCardType.MASTERCARD, number, cvv, exp, "");
        UserGateway user_gateway = new UserGateway(user);

        return user_gateway.Update();
    }
}
