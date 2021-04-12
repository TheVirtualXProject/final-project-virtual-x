package com.thevirtualx.mvcApp.Controller;


import com.thevirtualx.mvcApp.Storage.AccountStorage;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private AccountStorage accountStorage;

    public MainController(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }

}
