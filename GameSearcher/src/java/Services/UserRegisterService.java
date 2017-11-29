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
public final class UserRegisterService {

    private HttpServletRequest request;
    private User user;

    public UserRegisterService(HttpServletRequest request) {
        this.request = request;
        user = new User();
    }

    public boolean RegisterData() {
        AddBasicInformation();
        if (ShouldUsePartialRegister(request)) {
            UserGateway user_gateway = new UserGateway(user);
            return user_gateway.InsertBasic();
        }
        AddLocationInformation();
        AddCardInformation();

        UserGateway user_gateway = new UserGateway(user);
        return user_gateway.InsertComplete();
    }

    private void AddBasicInformation() {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first = request.getParameter("first");
        String last = request.getParameter("last");

        user.setPassword(password);
        user.setFirst_name(first);
        user.setLast_name(last);
        user.setEmail(email);
    }

    void AddLocationInformation() {
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");

        user.setAddress1(addr1);
        user.setAddress2(addr2);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setCountry(country);
    }

    void AddCardInformation() {
        String number = request.getParameter("number");
        String cvv = request.getParameter("cvv");
        String exp = request.getParameter("exp");

        user.setCredit_card_type(CreditCardType.VISA);
        user.setCredit_card_number(number);
        user.setCredit_card_cvv(cvv);
        user.setCredit_card_expiry(exp);
    }

    private boolean ShouldUsePartialRegister(HttpServletRequest request) {
        return request.getParameter("addr1").isEmpty()
                && request.getParameter("addr2").isEmpty()
                && request.getParameter("city").isEmpty()
                && request.getParameter("state").isEmpty()
                && request.getParameter("zip").isEmpty()
                && request.getParameter("country").isEmpty()
                && request.getParameter("type").isEmpty()
                && request.getParameter("number").isEmpty()
                && request.getParameter("cvv").isEmpty()
                && request.getParameter("exp").isEmpty();
    }

    public User getUser() {
        return user;
    }
}
