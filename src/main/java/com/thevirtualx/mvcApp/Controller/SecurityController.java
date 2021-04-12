package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Service.AccountStorage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private AccountStorage accountStorage;

    public SecurityController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }

    @GetMapping("/login/error")
    public String showLoginWithError(Model model) {
        if(checkForLogin())
            return "redirect:/";
        String error = "Incorrect username or password";
        model.addAttribute("error", error);
        return "loginPage";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        if(checkForLogin())
            return "redirect:/";
        model.addAttribute("error", "");
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
        return "redirect:/login";
    }


    public boolean checkForLogin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return true;
        }
        return false;
    }

}
