package com.thevirtualx.mvcApp.Entity;



import javax.persistence.*;
import java.util.Collection;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private Long id;
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


    public Challenge(Long id, String title, Account account, String description, String image, int rating, int popularity, Collection<Comment> comments, String challenges, String duration, String size, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.account = account;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.popularity = popularity;
        this.comments = comments;
        this.challenges = challenges;
        this.duration = duration;
        this.size = size;
        this.isPublic = isPublic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getChallenges() {
        return challenges;
    }

    public void setChallenges(String challenges) {
        this.challenges = challenges;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
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
