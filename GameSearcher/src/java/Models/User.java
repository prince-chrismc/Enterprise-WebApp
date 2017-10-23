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
    private String m_UserID;
    private String m_Password;
    
    private String m_FirstName;
    private String m_LastName;
    private String m_Email;
    private String m_Address1;
    private String m_Address2;
    private String m_City;
    private String m_State;

    private String m_Zip;
    private String Country;
    
    private String m_CreditCardType;
    private String m_CreditCardNumber;
    private String m_CreditCardCvv;
    private String m_CreditCardExpiry;
            
    private String m_LastLogin;
    
    
    public String getUserID() {
        return m_UserID;
    }

    public void setUserID(String m_UserID) {
        this.m_UserID = m_UserID;
    }

    public String getPassword() {
        return m_Password;
    }

    public void setPassword(String m_Password) {
        this.m_Password = m_Password;
    }

    public String getFirstName() {
        return m_FirstName;
    }

    public void setFirstName(String m_FirstName) {
        this.m_FirstName = m_FirstName;
    }

    public String getLastName() {
        return m_LastName;
    }

    public void setLastName(String m_LastName) {
        this.m_LastName = m_LastName;
    }

    public String getEmail() {
        return m_Email;
    }

    public void setEmail(String m_Email) {
        this.m_Email = m_Email;
    }

    public String getAddress1() {
        return m_Address1;
    }

    public void setAddress1(String m_Address1) {
        this.m_Address1 = m_Address1;
    }

    public String getAddress2() {
        return m_Address2;
    }

    public void setAddress2(String m_Address2) {
        this.m_Address2 = m_Address2;
    }

    public String getCity() {
        return m_City;
    }

    public void setCity(String m_City) {
        this.m_City = m_City;
    }

    public String getState() {
        return m_State;
    }

    public void setState(String m_State) {
        this.m_State = m_State;
    }

    public String getZip() {
        return m_Zip;
    }

    public void setZip(String m_Zip) {
        this.m_Zip = m_Zip;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCreditCardType() {
        return m_CreditCardType;
    }

    public void setCreditCardType(String m_CreditCardType) {
        this.m_CreditCardType = m_CreditCardType;
    }

    public String getCreditCardNumber() {
        return m_CreditCardNumber;
    }

    public void setCreditCardNumber(String m_CreditCardNumber) {
        this.m_CreditCardNumber = m_CreditCardNumber;
    }

    public String getCreditCardCvv() {
        return m_CreditCardCvv;
    }

    public void setCreditCardCvv(String m_CreditCardCvv) {
        this.m_CreditCardCvv = m_CreditCardCvv;
    }

    public String getCreditCardExpiry() {
        return m_CreditCardExpiry;
    }

    public void setCreditCardExpiry(String m_CreditCardExpiry) {
        this.m_CreditCardExpiry = m_CreditCardExpiry;
    }

    public String getLastLogin() {
        return m_LastLogin;
    }

    public void setLastLogin(String m_LastLogin) {
        this.m_LastLogin = m_LastLogin;
    }
}
