package com.thevirtualx.mvcApp.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;
    @ElementCollection
    private Collection<Comment> comments;
    @ElementCollection
    private Collection<String> friends;
    @OneToMany(mappedBy="account")
    private Collection<Challenge> challenges;
    private String username;
    private String password;
    private String realName;
    private int contributionPoints;
    private String profilePicture;
    private String roles;
    private boolean statusServerSide;

    protected Account(){

    }

    public Account(String username, String password, String realName, int contributionPoints, String profilePicture, boolean statusServerSide, String roles) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.contributionPoints = contributionPoints;
        this.comments = new ArrayList<>();
        this.profilePicture = profilePicture;
        this.friends = new ArrayList<>();
        this.statusServerSide = statusServerSide;
        this.roles = roles;

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

    public Collection<String> getFriends() {
        return friends;
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