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
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cmcarthur
 */
public class CheckoutResult {

    public enum Outcome {
        SUCCESS,
        ERROR;
    }

    private final Outcome result;
    private final String desc;
    private final ArrayList<CartEntry> entries;
    private final double final_price;
    private final Date eta;

    // When in error
    public CheckoutResult(String desc) {
        result = Outcome.ERROR;
        this.desc = desc;
        entries = null;
        final_price = 0.0;
        eta = null;
    }

    // When successful
    public CheckoutResult(ArrayList<CartEntry> entries, double final_price) {
        result = Outcome.SUCCESS;
        desc = "Checkout Successful!";
        this.entries = entries;
        this.final_price = final_price;
        eta = new Date(new Date().getTime() + 5 * (1000 * 60 * 60 * 24));
    }

    public boolean isSuccess() {
        return result == Outcome.SUCCESS;
    }

    public String getDesc() {
        return desc;
    }

    public Date getEta() {
        return eta;
    }

    public double getFinal_price() {
        return final_price;
    }

}
