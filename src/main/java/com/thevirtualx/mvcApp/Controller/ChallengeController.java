package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Entity.Comment;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Controller
//@RequestMapping("/challenge")
public class ChallengeController {

    private ChallengeStorage challengeStorage;
    private AccountStorage accountStorage;

    public ChallengeController (ChallengeStorage challengeStorage, AccountStorage accountStorage){
        this.challengeStorage = challengeStorage;
        this.accountStorage = accountStorage;
    }

    @GetMapping("/challenge")
    public String displayAllChallenges(Model model, Device device){
        model.addAttribute("challengesRecent", sortByRecent());
        model.addAttribute("challengesPopular", sortByPopular());
        if(!device.isNormal()) {
            return "challengePageMobile";
        }
        return "challengePage";
    }


    @GetMapping("/challenge/{id}")
    public String displaySingleChallenge(@PathVariable Long id, Model model){
        model.addAttribute("challenge", challengeStorage.retrieveChallengeById(id));
        return "singleChallengePage";
    }

    @PostMapping("/challenge/{id}/addComment")
    public String addCommentToChallenge(@PathVariable Long id, String comment, Principal principal, String addMedia){

        if(addMedia == null) {
            addMedia = "";
        }


        String username = principal.getName();
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        Comment commentToAdd = new Comment(comment, username, addMedia, id);
        challenge.addComment(commentToAdd);
        challengeStorage.addChallenge(challenge);

        Account account = accountStorage.retrieveAccountByUsername(username);
        account.addComment(commentToAdd);
        accountStorage.addAccount(account);
        return "redirect:/challenge/" + id;
    }

    @PostMapping("/challenge/add-challenge")
    public String addChallenge(String img, int capacity, String challengeName, String duration, String desc, Principal principal) throws IOException, URISyntaxException {

        boolean pub = capacity<=0;
        Account creator = accountStorage.retrieveAccountByUsername(principal.getName());

        Challenge challenge = new Challenge(challengeName,desc,img,
                0, 0, "",duration,0, capacity , pub, creator.getRealName());
        challenge.addAccount(creator);
        challengeStorage.addChallenge(challenge);
        return "redirect:/api/challenges/"+ challenge.getId() + "/url";
    }

    @PostMapping("/challenge/{id}/join-challenge")
    public String joinChallenge(@PathVariable Long id, Principal principal) {
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        challenge.addAccount(account);
        challengeStorage.addChallenge(challenge);
        return "redirect:/api/challenges/"+ challenge.getId() + "/url";
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
