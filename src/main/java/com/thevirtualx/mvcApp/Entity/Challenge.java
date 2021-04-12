package com.thevirtualx.mvcApp.Entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Account account;
    @ElementCollection
    private Collection<Comment> comments;
    private String title;
    private String description;
    private String image;
    private int rating;
    private int popularity;
    private String challenges;
    private String duration;
    private String size;
    private boolean isPublic;

    protected Challenge() {

    }


    public Challenge( String title, Account account, String description, String image, int rating, int popularity,
                       String challenges, String duration, String size, boolean isPublic) {
        this.title = title;
        this.account = account;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.popularity = popularity;
        this.comments = new ArrayList<>();
        this.challenges = challenges;
        this.duration = duration;
        this.size = size;
        this.isPublic = isPublic;
    }

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Account getAccount() {
        return account;
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
    public String getDuration() {
        return duration;
    }
    public String getSize() {
        return size;
    }
    public Boolean getPublic() {
        return isPublic;
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
    public void setSize(String size) {
        this.size = size;
    }



    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", account=" + account +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", popularity=" + popularity +
                ", comments=" + comments +
                ", challenges='" + challenges + '\'' +
                ", duration='" + duration + '\'' +
                ", size='" + size + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
