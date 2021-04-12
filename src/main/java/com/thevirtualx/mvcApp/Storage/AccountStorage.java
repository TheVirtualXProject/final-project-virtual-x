package com.thevirtualx.mvcApp.Storage;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Repo.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountStorage{
    private AccountRepository accountRepo;
    public AccountStorage (AccountRepository accountRepo){
        this.accountRepo = accountRepo;

    }

    public void addAccount(Account accountToAdd) {
        accountRepo.save(accountToAdd);
    }
    public Account retrieveAccountById(Long id) { return accountRepo.findById(id).get();}
    public void deleteAccountById(Long id) {accountRepo.deleteById(id);}

}
