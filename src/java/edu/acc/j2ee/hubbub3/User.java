package edu.acc.j2ee.hubbub3;

public class User implements java.io.Serializable {
    private String username;
    private java.util.Date joinDate;
    private int profileId;
    
    public User() {}
    public User(String username) {
        this.username = username;
        this.joinDate = new java.util.Date();
    }

    public String getUsername() {
        return username;
    }

    public java.util.Date getJoinDate() {
        return joinDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setJoinDate(java.util.Date joinDate) {
        this.joinDate = joinDate;
    }
    
    @Override
    public String toString() {
        return username;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

}
