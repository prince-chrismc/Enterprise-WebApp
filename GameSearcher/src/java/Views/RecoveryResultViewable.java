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
package Views;

import Models.RecoveryResult;

/**
 *
 * @author cmcarthur
 */
public class RecoveryResultViewable implements WebViewable {

    private final RecoveryResult result;

    public RecoveryResultViewable(RecoveryResult result) {
        this.result = result;
    }

    @Override
    public String toHTML() {
        switch (result) {
            case SUCCESS:
                return "<h1>Check you emails for a temp password</h1>";
            case USER_DNE:
                return "<h1>The email specified does not belong to a user, try registering</h1>";
            case SYS_ERR:
                return "<h1>there was a system error, try contating the admin for help</h1>";
            default:
                return "";
        }
    }

}
