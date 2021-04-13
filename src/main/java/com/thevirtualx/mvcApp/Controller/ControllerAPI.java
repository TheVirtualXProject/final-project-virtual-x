package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAPI {


    private ChallengeStorage challengeStorage;

    public ControllerAPI(ChallengeStorage challengeStorage) {
        this.challengeStorage = challengeStorage;
    }


    @GetMapping("/api/challenges")
    public Iterable<Challenge> getAllChallenges() {
        return challengeStorage.getAllChallenges();
    }

}
