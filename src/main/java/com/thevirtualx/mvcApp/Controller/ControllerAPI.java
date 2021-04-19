package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.*;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import com.thevirtualx.mvcApp.Storage.GameStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
public class ControllerAPI {


    private ChallengeStorage challengeStorage;
    private AccountStorage accountStorage;
    private ChatroomStorage chatroomStorage;
    private GameStorage gameStorage;

    public ControllerAPI(ChallengeStorage challengeStorage, AccountStorage accountStorage,
                         ChatroomStorage chatroomStorage, GameStorage gameStorage) {
        this.challengeStorage = challengeStorage;
        this.accountStorage = accountStorage;
        this.chatroomStorage = chatroomStorage;
        this.gameStorage = gameStorage;
    }


    @GetMapping("/api/challenges")
    public ArrayList<Challenge> getAllChallenges() {
        return sortChallengeByRecent();
    }


    @GetMapping("/api/challenges/{id}/check-users")
    public boolean checkIfUserExistsInChallenge(Principal principal, @PathVariable Long id) {
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        return challenge.getAccounts().contains(account);

    }


    @GetMapping("/api/challenges/{id}")
    public Challenge retrieveChallengeInfo(@PathVariable Long id) {
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        return challenge;
    }

    @GetMapping("/api/challenges/{id}/url")
    public String returnChallengeUrl(@PathVariable Long id) {
        return "/challenge/" +id;
    }

    @PostMapping("/api/challenges/{id}/rate")
    public int rateChallenge(int rate, @PathVariable Long id, Principal principal) {
        Rated rated  = new Rated(principal.getName(), rate);
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        if(!challenge.getHasRated().contains(rated)) {
            challenge.addUserToRated(rated);
        }
        else {
            challenge.replaceUserRating(rated);

        }
        challenge.findAverageRating();
        challengeStorage.addChallenge(challenge);

        return challenge.getRating();

    }

    @GetMapping("/api/chatrooms")
    public ArrayList<Chatroom> getAllChatrooms() {
        Instant rightNow = Instant.now();
        for (Chatroom chatroom:chatroomStorage.retrieveAll()) {
            if ((Duration.between(chatroom.getCreation(), rightNow).getSeconds() / 60) >= 30) {
                chatroomStorage.deleteChatroomById(chatroom.getId());
            }
        }
        
        return sortChatroomByRecent();
    }

    @GetMapping("/api/games/playerHash")
    public GameHash getPlayerData(Principal principal) {
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        GameHash gameHash = new GameHash(account.getId(), account.getUsername());
        return gameHash;
    }

    @GetMapping("/api/games/{id}")
    public Game retrieveGameInfo(@PathVariable Long id) {
        Game game = gameStorage.retrieveGameById(id);
        return game;
    }


    @GetMapping("/api/chatrooms/{id}/url")
    public String returnChatroomUrl(@PathVariable Long id) {
        return "/chat/" + id;
    }



    public ArrayList<Challenge> sortChallengeByRecent() {
        ArrayList<Challenge> temp = new ArrayList<>();
        Iterable<Challenge> challenges = challengeStorage.getAllChallenges();
        for(Challenge challenge: challenges) {
            temp.add(0, challenge);
        }
        return temp;
    }

    public ArrayList<Chatroom> sortChatroomByRecent() {
        ArrayList<Chatroom> temp = new ArrayList<>();
        Iterable<Chatroom> chatrooms = chatroomStorage.retrieveAll();
        for(Chatroom chatroom: chatrooms) {
            temp.add(0, chatroom);
        }
        return temp;
    }

    public ArrayList<Challenge> sortChallengeByPopular() {
        ArrayList<Challenge> temp = new ArrayList<>();
        for(Challenge challenge: challengeStorage.getAllChallenges()) {
            temp.add(challenge);
        }
        Collections.sort(temp, new Comparator<Challenge>() {
            @Override
            public int compare(Challenge o1, Challenge o2) {
                Integer int1 = o1.getRating();
                Integer int2 = o2.getRating();
                return int2.compareTo(int1);
            }
        });
        return temp;
    }

}
