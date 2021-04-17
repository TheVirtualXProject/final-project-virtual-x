package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.AccountStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    private AccountStorage accountStorage;

    public AccountController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }



    @GetMapping("/account")
    public String displayAccountPage() {
        return  "accountPage";
    }
}
//retrieve accounts

//retrieve account by id
