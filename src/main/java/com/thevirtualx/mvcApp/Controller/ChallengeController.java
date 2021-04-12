package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.stereotype.Controller;

@Controller
public class ChallengeController {

    private ChallengeStorage challengeStorage;

    public ChallengeController (ChallengeStorage challengeStorage){
        this.challengeStorage = challengeStorage;
    }
}
