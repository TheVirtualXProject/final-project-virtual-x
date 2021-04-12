package com.thevirtualx.mvcApp;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Entity.Comment;
import com.thevirtualx.mvcApp.Storage.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private AccountStorage accountStorage;
    private ChallengeStorage challengeStorage;
    private ChatroomStorage chatroomStorage;
    private GameStorage gameStorage;

    public Populator(AccountStorage accountStorage, ChallengeStorage challengeStorage,
                     ChatroomStorage chatroomStorage,  GameStorage gameStorage) {
        this.accountStorage = accountStorage;
        this.challengeStorage = challengeStorage;
        this.chatroomStorage = chatroomStorage;
        this.gameStorage = gameStorage;
    }

    @Override
    public void run(String... args) throws Exception{
        Account lani = new Account("TurboJay", "GoWeiwei", "Jelanie Starks", 0,
                "https://static.wikia.nocookie.net/dragonball/images/5/58/GokuSuperSaiyanTransformedAtLast.png/revision/latest/scale-to-width-down/200?cb=20191103030051", true, "USER");
        accountStorage.addAccount(lani);

        Account connor = new Account("Ronnoc", "GoWeiwei", "Connor Chambers", 0,
                "https://4.bp.blogspot.com/-puG6A6cjmI8/VeDXT2if2bI/AAAAAAAAgnE/EIC6fuiO2NY/s1600/Blue%2BJay%252C%2B8-12-2015-3896-3.jpg", true, "USER");
        accountStorage.addAccount(connor);

        Challenge mileWalk = new Challenge("Walk a mile durring lunch!", connor,
                "Eating is overrated, be a plant and soak up some sunshine!",
                "https://www.thestatesman.com/wp-content/uploads/2017/12/WALKING00.jpg", 4, 10,
                "Walk one mile every day this week.", "7 days", "everyone", true);

        Comment mileCom1 = new Comment("I don't walk, I lift weights.");
        mileWalk.addComment(mileCom1);
        challengeStorage.addChallenge(mileWalk);


//        how do comments know where to go and who they belong to at the same time
    }

}
