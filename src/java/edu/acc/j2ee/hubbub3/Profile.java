package edu.acc.j2ee.hubbub3;

public class Profile implements java.io.Serializable {
    private String biography;
    private String email;
    private byte[] picture;
    
    public Profile() {}
    
    public Profile(String biography, String email, byte[] picture) {
        this.biography = biography;
        this.email = email;
        this.picture = picture;
    }

    public String getBiography() {
        return biography;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
    
}
