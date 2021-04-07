package com.thevirtualx.mvcApp.Entity;

public class Challenge {
    private Account account;
    private int rating;
    private int popularity;
    private String comment;
    private String challenges;

    public Challenge(Account account, int rating, int popularity, String comment, String challenges) {
        this.account = account;
        this.rating = rating;
        this.popularity = popularity;
        this.comment = comment;
        this.challenges = challenges;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getChallenges() {
        return challenges;
    }

    public void setChallenges(String challenges) {
        this.challenges = challenges;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "account=" + account +
                ", rating=" + rating +
                ", popularity=" + popularity +
                ", comment='" + comment + '\'' +
                ", challenges='" + challenges + '\'' +
                '}';
    }
}
//Add Challenges
//Rating
//Comment
//Account
//Popularity
