package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialBlob;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;

@RestController
public class ControllerAPI {


    private ChallengeStorage challengeStorage;
    private AccountStorage accountStorage;

    public ControllerAPI(ChallengeStorage challengeStorage, AccountStorage accountStorage) {
        this.challengeStorage = challengeStorage;
        this.accountStorage = accountStorage;
    }


    @GetMapping("/api/challenges")
    public Iterable<Challenge> getAllChallenges() {
        return challengeStorage.getAllChallenges();
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



}
