package com.thevirtualx.mvcApp.Entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private long id;
    @ManyToMany
    private Collection<Account> accounts;
    private String creatorName;
    @ElementCollection
    private Collection<Comment> comments;
    @ElementCollection
    private Collection<Rated> hasRated;
    private String title;
    @Lob
    private String description;
    @Lob
    private String image;
    private int rating;
    private int popularity;
    private String challenges;
    private String duration;
    private int joinedPlayers;
    private int maxPlayers;
    private boolean isPublic;

    protected Challenge() {

    }


    public Challenge( String title, String description, String image, int rating, int popularity,
                       String challenges, String duration, int joinedPlayers, int maxPlayers, boolean isPublic, String creatorName) {
        this.title = title;
        this.accounts = new ArrayList<Account>();
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.popularity = popularity;
        this.comments = new ArrayList<>();
        this.hasRated = new ArrayList<>();
        this.challenges = challenges;
        this.duration = duration;
        this.joinedPlayers = joinedPlayers;
        this.maxPlayers = maxPlayers;
        this.isPublic = isPublic;
        this.creatorName = creatorName;
    }


    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Collection<Account> getAccounts() {
        return accounts;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public int getRating() {
        return rating;
    }
    public int getPopularity() {
        return popularity;
    }
    public Collection<Comment> getComments() {
        return comments;
    }
    public String getChallenges() {
        return challenges;
    }

    public String getCreatorName() {
        return creatorName;
    }
    public Collection<Rated> getHasRated() {
        return hasRated;
    }


    public String getDuration() {
        return duration;
    }
    public int getJoinedPlayers() {
        return joinedPlayers;
    }
    public int getMaxPlayers() {
        return maxPlayers;
    }
    public boolean isPublic() {
        return isPublic;
    }

    public void addAccount(Account accountToAdd) {
        accounts.add(accountToAdd);
        joinedPlayers++;
        accountToAdd.addToContributionCount();
    }

    public void addUserToRated(Rated rated) {
        hasRated.add(rated);
    }
    public void addComment(Comment commentToAdd) {
        comments.add(commentToAdd);
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setChallenges(String challenges) {
        this.challenges = challenges;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
//    public void printAccounts() {
//        for (int i: accounts) {
//            System.out.print(i);
//        }
//    }

    public void replaceUserRating(Rated rated) {
        if(hasRated.contains(rated)) {
            hasRated.remove(rated);
            hasRated.add(rated);
        }
    }

    public void findAverageRating() {
        rating = 0;
        for(Rated rated: hasRated) {
            rating += rated.getRating();
        }
        rating /= hasRated.size();
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", accounts=" + accounts +
                ", comments=" + comments +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", popularity=" + popularity +
                ", challenges='" + challenges + '\'' +
                ", duration='" + duration + '\'' +
                ", joinedPlayers=" + joinedPlayers +
                ", maxPlayers=" + maxPlayers +
                ", isPublic=" + isPublic +
                '}';
    }



}
