package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Game;
import com.thevirtualx.mvcApp.Entity.GameHash;
import com.thevirtualx.mvcApp.Entity.StaticGame;
import com.thevirtualx.mvcApp.Repo.StaticGameRepository;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.GameStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class GameController {

    private GameStorage gameStorage;
    private AccountStorage accountStorage;
    private StaticGameRepository staticGameRepository;

    public GameController(GameStorage gameStorage, AccountStorage accountStorage,
                          StaticGameRepository staticGameRepository) {
        this.gameStorage = gameStorage;
        this.accountStorage = accountStorage;
        this.staticGameRepository = staticGameRepository;
    }

    @GetMapping("/game")
    public String displayGamePage(Model model) {
        model.addAttribute("games", staticGameRepository.findAll());
        return "gamePage";
    }


    @GetMapping("/game/{id}")
    public String displayGameRoom(@PathVariable Long id, Principal principal, Model model) {
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        Game game = gameStorage.retrieveGameById(id);
        GameHash gameHash = new GameHash(account.getId(), account.getUsername());
        if (!game.getJoinedPlayerHashes().contains(gameHash)) {
            game.addHash(gameHash);
            gameStorage.addGame(game);

        }

        model.addAttribute("game", game);
        return "singleGame";
    }


    @GetMapping("/game/{id}/create-game")
    public String createGame(@PathVariable Long id, Principal principal) {
        StaticGame staticGame = staticGameRepository.findById(id).get();
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        GameHash gameHash = new GameHash(account.getId(), account.getUsername());


        for (Game game : staticGame.getGames()) {
            if (game.getJoinedPlayers() < game.getMaxPlayers() && !game.getJoinedPlayerHashes().contains(gameHash)) {
                game.addHash(gameHash);
                gameStorage.addGame(game);
                return "redirect:/game/" + game.getId();
            } else if (game.getJoinedPlayerHashes().contains(gameHash)) {
                return "redirect:/game/" + game.getId();
            }
        }
        Game game = new Game(staticGame.getName(), staticGame.getShortName(),
                staticGame.getMaxSize(), account.getRealName(), staticGame);
        game.addHash(gameHash);
        gameStorage.addGame(game);
        return "redirect:/game/" + game.getId();


    }


    @PostMapping("/game/{id}/join-game")
    public String joinGame(@PathVariable Long id, Principal principal) {
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        Game game = gameStorage.retrieveGameById(id);
        GameHash gameHash = new GameHash(account.getId(), account.getUsername());
        if(!game.getJoinedPlayerHashes().contains(gameHash)) {
            game.addHash(gameHash);
        }
        return "redirect:/api/games/" + id + "/url";
    }



}
