package com.thevirtualx.mvcApp.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
    private String username;
    private String password;
    private String realName;
    private int contributionPoints;
    private Collection<String> friends;
    private String profilePicture;
    private boolean statusServerSide;

    public Account(String username, String password, String realName, int contributionPoints, String profilePicture, boolean statusServerSide) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.contributionPoints = contributionPoints;
        this.friends = new ArrayList<>();
        this.profilePicture = profilePicture;
        this.statusServerSide = statusServerSide;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(int contributionPoints) {
        this.contributionPoints = contributionPoints;
    }

    public Collection<String> getFriends() {
        return friends;
    }

    public void setFriends(Collection<String> friends) {
        this.friends = friends;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isStatusServerSide() {
        return statusServerSide;
    }

    public void setStatusServerSide(boolean statusServerSide) {
        this.statusServerSide = statusServerSide;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", contributionPoints=" + contributionPoints +
                ", friends=" + friends +
                ", profilePicture='" + profilePicture + '\'' +
                ", statusServerSide=" + statusServerSide +
                '}';
    }
}
//Username
//Password
//Real name
//Contribution points
//Friends
//profile picture
//Status(serverside)
//Login