package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Friend {

    @Id
    @GeneratedValue
    private Long id;

    private String account;

    public Friend(Account account) {
        this.account = account.getUsername();
    }

    protected Friend(){

    }
}
