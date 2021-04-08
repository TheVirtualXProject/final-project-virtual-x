package com.thevirtualx.mvcApp.Service;

import com.thevirtualx.mvcApp.Entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountStorage implements AccountRepository{
    private AccountRepository accountRepo;
    public AccountStorage (AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }

    public void addAccount(Account accountToAdd) {
        accountRepo.save(accountToAdd);
    }
}
