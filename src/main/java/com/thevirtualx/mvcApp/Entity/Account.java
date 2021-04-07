package com.thevirtualx.mvcApp.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
    private String username;
    private String password;
    private String realName;
    private int contributionPoints;
    private Collection<Comment> comments;
    private String profilePicture;
    private boolean statusServerSide;
    private Collection<Long> friends;

    public Account(String username, String password, String realName, int contributionPoints, String profilePicture, boolean statusServerSide) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.contributionPoints = contributionPoints;
        this.comments = new ArrayList<>();
        this.profilePicture = profilePicture;
        this.statusServerSide = statusServerSide;
        this.friends = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public int getContributionPoints() {
        return contributionPoints;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public boolean isStatusServerSide() {
        return statusServerSide;
    }

    public Collection<Long> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", contributionPoints=" + contributionPoints +
                ", comments=" + comments +
                ", profilePicture='" + profilePicture + '\'' +
                ", statusServerSide=" + statusServerSide +
                ", friends=" + friends +
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