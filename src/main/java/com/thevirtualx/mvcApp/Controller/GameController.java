package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Game;
import com.thevirtualx.mvcApp.Entity.GameHash;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.GameStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class GameController {

    private GameStorage gameStorage;
    private AccountStorage accountStorage;

    public GameController (GameStorage gameStorage, AccountStorage accountStorage){
        this.gameStorage = gameStorage;
        this.accountStorage = accountStorage;
    }
    @GetMapping("/game")
    public String displayGamePage() {
        return  "gamePage";
    }


    @GetMapping("/game/{id}")
    public String displayGameRoom(@PathVariable Long id, Principal principal) {
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        Game game = gameStorage.retrieveGameById(id);
        GameHash gameHash = new GameHash(account.getId(), account.getUsername());
        if(!game.getJoinedPlayerHashes().contains(gameHash)) {
            game.addHash(gameHash);
            gameStorage.addGame(game);

        }
        return "singleGame";
    }
}
