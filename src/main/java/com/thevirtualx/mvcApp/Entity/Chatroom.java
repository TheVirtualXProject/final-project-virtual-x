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
    private int currentSize = 0;
    private int maxSize = 4;


    public Chatroom(String channelName, String author) {
        this.channelName = channelName;
        this.author = author;
    }
    public Chatroom(String channelName, String author,int maxSize) {
        this.channelName = channelName;
        this.maxSize = maxSize;
        this.author = author;
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
