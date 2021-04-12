package com.thevirtualx.mvcApp.Service;

import com.thevirtualx.mvcApp.Entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountStorage {

    private AccountRepo accountRepo;

    public AccountStorage(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void saveAccount(Account account) {
        accountRepo.save(account);
    }


}
