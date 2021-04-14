package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Entity.Comment;
import com.thevirtualx.mvcApp.Entity.UploadFile;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

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
    public String displayAllChallenges(Model model){
        model.addAttribute("challenges", challengeStorage.getAllChallenges());
        return "challengePage";
    }


    @GetMapping("/challenge/{id}")
    public String displaySingleChallenge(@PathVariable Long id, Model model){
        model.addAttribute("challenge", challengeStorage.retrieveChallengeById(id));
        return "singleChallengePage";
    }

    @PostMapping("/challenge/{id}/addComment")
    public String addCommentToChallenge(@PathVariable Long id, String body, Principal principal, MultipartFile file){

        UploadFile uFile;

        try {
            String name = file.getOriginalFilename();
            uFile = new UploadFile(name, file.getBytes(), file.getContentType());


        } catch (Exception e) {
            System.out.println("Failed");
            return "redirect:/challenge/" + id;
        }






        String username = principal.getName();
        Challenge challenge = challengeStorage.retrieveChallengeById(id);
        Comment commentToAdd = new Comment(body, username, uFile, id);
        challenge.addComment(commentToAdd);
        challengeStorage.addChallenge(challenge);

        Account account = accountStorage.retrieveAccountByUsername(username);
        account.addComment(commentToAdd);
        accountStorage.addAccount(account);
        return "redirect:/challenge/" + id;
    }





}
