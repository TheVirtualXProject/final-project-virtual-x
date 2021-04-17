package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Entity.Rated;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialBlob;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
public class ControllerAPI {


    private ChallengeStorage challengeStorage;
    private AccountStorage accountStorage;

    public ControllerAPI(ChallengeStorage challengeStorage, AccountStorage accountStorage) {
        this.challengeStorage = challengeStorage;
        this.accountStorage = accountStorage;
    }


    @GetMapping("/api/challenges")
    public ArrayList<Challenge> getAllChallenges() {
        return sortByRecent();
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



    public ArrayList<Challenge> sortByRecent() {
        ArrayList<Challenge> temp = new ArrayList<>();
        Iterable<Challenge> challenges = challengeStorage.getAllChallenges();
        for(Challenge challenge: challenges) {
            temp.add(0, challenge);
        }
        return temp;
    }

    public ArrayList<Challenge> sortByPopular() {
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
