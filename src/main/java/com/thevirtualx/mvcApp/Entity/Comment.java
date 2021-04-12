package com.thevirtualx.mvcApp.Entity;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Comment {
//account
    @Id
    @GeneratedValue
    private Long id;
    private String text;


    public Comment(String text) {
        this.text = text;
    }

    public Comment() {

    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                '}';
    }
}
