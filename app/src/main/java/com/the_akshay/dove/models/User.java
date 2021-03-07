package com.the_akshay.dove.models;

public class User {
    String profilepic, uName, email, pwd, UID, lasrMsg;

    public User(String uName, String email, String pwd) {

        this.uName = uName;
        this.email = email;
        this.pwd = pwd;

    }

    public User() {
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getLasrMsg() {
        return lasrMsg;
    }

    public void setLasrMsg(String lasrMsg) {
        this.lasrMsg = lasrMsg;
    }


}
