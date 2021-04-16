package com.thevirtualx.mvcApp.Entity;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.File;
import java.io.FileInputStream;

@Embeddable
public class Comment {
//account

    private String text;
    private String username;
    @Lob
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

    public Long getCurrentChallengeId() {
        return currentChallengeId;
    }


    public void setCurrentChallengeId(Long currentChallengeId) {
        this.currentChallengeId = currentChallengeId;
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
