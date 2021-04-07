package com.thevirtualx.mvcApp.Entity;

import java.util.Collection;

public class Chatroom {
    private Collection<Account> accounts;
    private String title;

    public Chatroom(Collection<Account> accounts, String title) {
        this.accounts = accounts;
        this.title = title;
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
