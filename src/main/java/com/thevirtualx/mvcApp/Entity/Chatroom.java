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

    public Chatroom(String channelName) {
//       this.accounts = accounts;
        this.channelName = channelName;
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
