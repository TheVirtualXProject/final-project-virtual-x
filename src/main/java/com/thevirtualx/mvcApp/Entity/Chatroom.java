package com.thevirtualx.mvcApp.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Chatroom {

    @Id
    @GeneratedValue
    private Long id;
//    private Collection<Account> accounts;
    @Lob
    private String channelName;
    @ManyToMany
    private Collection<Account> accounts;
    private String author;
    private String description;
    private int currentSize;
    private int maxSize;

    private Instant creation;


    public Chatroom(String channelName, String author) {
        this.channelName = channelName;
        this.author = author;
        this.description = "";
        this.maxSize = 4;
        this.currentSize = 1;
        this.creation = Instant.now();
        this.accounts = new ArrayList<>();
    }
    public Chatroom(String channelName, String author,int maxSize, String description) {
        this.channelName = channelName;
        this.maxSize = maxSize;
        this.author = author;
        this.description = description;
        this.currentSize = 0;
        this.creation = Instant.now();
        this.accounts = new ArrayList<>();
    }

    protected Chatroom() {

    }

//    public Collection<Account> getAccounts() {
//        return accounts;
//    }

    public void addAccount(Account accountToAdd) {
        accounts.add(accountToAdd);
        currentSize++;
        accountToAdd.addToContributionCount();
    }


    public String getChannelName() {
        return channelName;
    }
    public Long getId(){
        return id;
    }
    public Instant getCreation(){
        return creation;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
