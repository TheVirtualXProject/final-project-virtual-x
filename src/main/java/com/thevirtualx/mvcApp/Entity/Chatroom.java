package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Collection;

@Entity
public class Chatroom {

    @Id
    @GeneratedValue
    private Long id;
//    private Collection<Account> accounts;
    @Lob
    private String channelName;
    private String author;
    private String description;
    private int currentSize;
    private int maxSize;


    public Chatroom(String channelName, String author) {
        this.channelName = channelName;
        this.author = author;
        this.description = "";
        this.maxSize = 4;
        this.currentSize = 1;
    }
    public Chatroom(String channelName, String author,int maxSize, String description) {
        this.channelName = channelName;
        this.maxSize = maxSize;
        this.author = author;
        this.description = description;
        this.currentSize = 1;
    }

    protected Chatroom() {

    }

//    public Collection<Account> getAccounts() {
//        return accounts;
//    }

    public String getChannelName() {
        return channelName;
    }
    public Long getId(){
        return id;
    }
}
