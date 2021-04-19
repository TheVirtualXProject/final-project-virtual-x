package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AccountController {

    private AccountStorage accountStorage;

    public AccountController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }



    @GetMapping("/account")
    public String displayAccountPage(Model model, Principal principal) {
        Account user = accountStorage.retrieveAccountByUsername(principal.getName());
        model.addAttribute("account", user);
        return  "accountPage";
    }
}
//retrieve accounts

//retrieve account by id
