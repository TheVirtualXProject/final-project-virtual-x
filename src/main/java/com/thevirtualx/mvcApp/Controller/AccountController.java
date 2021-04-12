package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.AccountStorage;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    private AccountStorage accountStorage;

    public AccountController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }
}
//retrieve accounts

//retrieve account by id
