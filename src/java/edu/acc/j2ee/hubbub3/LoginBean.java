package edu.acc.j2ee.hubbub3;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginBean implements java.io.Serializable {
    private String username;
    private String password;
    private String error = "No error.";
    
    public LoginBean() {}
    
    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean validates() {
        if (username == null || password == null) {
            error = "No form data was received.";
            return false;
        }
        if (username.length() < 4 || password.length() < 4 ||
            username.length() > 10 || password.length() > 10 ){
            error = "User name and password must both be 4 to 10 characters.";
            return false;
        }
        try {
            username = URLEncoder.encode(username, "UTF-8");
            password = URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException uee){
            error = "Form validation error due to programmer stupidity.";
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getError() {
        return error;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
