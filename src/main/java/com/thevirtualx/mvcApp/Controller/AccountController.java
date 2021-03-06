package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class AccountController {

    private AccountStorage accountStorage;
    private ChallengeStorage challengeStorage;

    public AccountController(AccountStorage accountStorage, ChallengeStorage challengeStorage) {
        this.accountStorage = accountStorage;
        this.challengeStorage = challengeStorage;
    }



    @GetMapping("/account")
    public String displayAccountPage(Model model, Principal principal) {
        Account user = accountStorage.retrieveAccountByUsername(principal.getName());
        model.addAttribute("account", user);
        model.addAttribute("challengeStorage", challengeStorage);

        return  "accountPage";
    }
}
//retrieve accounts

//retrieve account by id
