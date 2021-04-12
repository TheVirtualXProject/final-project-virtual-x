package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Friend {



    private String account;

    public Friend(Account account) {
        this.account = account.getUsername();
    }

    protected Friend(){

    }

 


}
