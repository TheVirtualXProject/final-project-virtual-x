package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String realName;
    private int contributionPoints;
//    private Collection<Comment> comments;
    private String profilePicture;
    private String roles;
    private boolean statusServerSide;
//    private Collection<Long> friends;

    public Account(String username, String password, String realName, int contributionPoints, String profilePicture, boolean statusServerSide, String roles) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.contributionPoints = contributionPoints;
//        this.comments = new ArrayList<>();
        this.profilePicture = profilePicture;
        this.statusServerSide = statusServerSide;
        this.roles = roles;
//        this.friends = new ArrayList<>();
    }

    protected Account() {}

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

//    public Collection<Comment> getComments() {
//        return comments;
//    }

    public long getId() {
        return id;
    }

    public String getRoles() {
        return roles;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public boolean isStatusServerSide() {
        return statusServerSide;
    }

//    public Collection<Long> getFriends() {
//        return friends;
//    }

}
//Username
//Password
//Real name
//Contribution points
//Friends
//profile picture
//Status(serverside)
//Login