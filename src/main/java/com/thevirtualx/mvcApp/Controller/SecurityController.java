package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Service.AccountStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private AccountStorage accountStorage;

    public SecurityController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @GetMapping("/create-account")
    public String showCreateAccountPage() {
        return "createAccount";
    }

    @PostMapping("/create-account")
    public String createAccount(String username, String password, String realName) {
        Account account = new Account(username, password, realName, 0, null, true, "USER");
        accountStorage.saveAccount(account);
        //TODO eventually have this return a success page
        return "loginPage";
    }
}
