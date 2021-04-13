package com.thevirtualx.mvcApp.Entity;
import javax.persistence.Embeddable;

@Embeddable
public class Comment {
//account

    private String text;
    private String username;
    private String importMedia;
    private Long currentChallengeId;

    public Comment(String text, String username, String importMedia, Long currentChallengeId) {
        this.text = text;
        this.username = username;
        this.importMedia = importMedia;
        this.currentChallengeId = currentChallengeId;
    }

    protected Comment() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImportMedia() {
        return importMedia;
    }

    public void setImportMedia(String importMedia) {
        this.importMedia = importMedia;
    }

    public Long getChallengeId() {
        return currentChallengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.currentChallengeId = challengeId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", username='" + username + '\'' +
                ", importMedia='" + importMedia + '\'' +
                ", challengeId=" + currentChallengeId +
                '}';
    }
}
