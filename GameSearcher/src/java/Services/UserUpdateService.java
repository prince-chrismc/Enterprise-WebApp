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

import Gateway.UserGateway;
import Models.CreditCardType;
import Models.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author cmcarthur
 */
public class UserUpdateService {

    private final HttpServletRequest request;

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

        User user = new User(uid, "", first, last, email, addr1, addr2, city, state, zip, country, CreditCardType.VISA, number, cvv, exp, "", false, false);
        UserGateway user_gateway = new UserGateway(user);

        return user_gateway.Update();
    }
}
