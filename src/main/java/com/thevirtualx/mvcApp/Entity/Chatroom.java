package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class Chatroom {

    @Id
    @GeneratedValue
    private Long id;
    private Collection<Account> accounts;
    private String title;

    public Chatroom(Collection<Account> accounts, String title) {
        this.accounts = accounts;
        this.title = title;
    }

    protected Chatroom() {

    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "accounts=" + accounts +
                ", title='" + title + '\'' +
                '}';
    }
}
