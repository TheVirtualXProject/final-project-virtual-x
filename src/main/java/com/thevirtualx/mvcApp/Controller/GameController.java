package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.GameStorage;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private GameStorage gameStorage;

    public GameController (GameStorage gameStorage){
        this.gameStorage = gameStorage;
    }
}
