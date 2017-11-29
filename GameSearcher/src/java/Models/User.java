/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author cmcarthur
 */
public class User {
    private int user_id;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    
    private CreditCardType credit_card_type;
    private String credit_card_number;
    private String credit_card_cvv;
    private String credit_card_expiry;
    
    private String last_login;

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = (address1 != null) ? address1 : "";
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = (address2 != null) ? address2 : "";
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = (city != null) ? city : "";
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = (state != null) ? state : "";
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = (zip != null) ? zip : "";
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = (country != null) ? country : "";
    }

    /**
     * @return the credit_card_type
     */
    public String getCredit_card_type() {
        return credit_card_type.toString();
    }

    /**
     * @param credit_card_type the credit_card_type to set
     */
    public void setCredit_card_type(CreditCardType credit_card_type) {
        this.credit_card_type = credit_card_type;
    }

    /**
     * @return the credit_card_number
     */
    public String getCredit_card_number() {
        return credit_card_number;
    }

    /**
     * @param credit_card_number the credit_card_number to set
     */
    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    /**
     * @return the credit_card_cvv
     */
    public String getCredit_card_cvv() {
        return credit_card_cvv;
    }

    /**
     * @param credit_card_cvv the credit_card_cvv to set
     */
    public void setCredit_card_cvv(String credit_card_cvv) {
        this.credit_card_cvv = credit_card_cvv;
    }

    /**
     * @return the credit_card_expiry
     */
    public String getCredit_card_expiry() {
        return credit_card_expiry;
    }

    /**
     * @param credit_card_expiry the credit_card_expiry to set
     */
    public void setCredit_card_expiry(String credit_card_expiry) {
        this.credit_card_expiry = credit_card_expiry;
    }

    /**
     * @return the last_login
     */
    public String getLast_login() {
        return last_login;
    }

    /**
     * @param last_login the last_login to set
     */
    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }
}