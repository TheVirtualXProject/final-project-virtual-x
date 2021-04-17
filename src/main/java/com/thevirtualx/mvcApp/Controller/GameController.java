package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.GameStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    private GameStorage gameStorage;

    public GameController (GameStorage gameStorage){
        this.gameStorage = gameStorage;
    }
    @GetMapping("/game")
    public String displayGamePage() {
        return  "gamePage";
    }
}
