package com.thevirtualx.mvcApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {







    @GetMapping("/")
    public String displayHomeView() {

        return "homeView";
    }
}
