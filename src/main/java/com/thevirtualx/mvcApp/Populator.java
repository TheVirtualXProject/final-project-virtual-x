package com.thevirtualx.mvcApp;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChallengeStorage;
import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import com.thevirtualx.mvcApp.Storage.GameStorage;
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

        Account weiwei = new Account("iewiew", "GoWeiwei", "Weiwei Jiang", 100000,
                "https://i.pinimg.com/originals/22/fd/a9/22fda9d0f11b8d86296d96b021062c90.jpg", true, "USER");
        accountStorage.addAccount(weiwei);

        Account bishnu = new Account("shnushnu", "GoWeiwei", "Bishnu Dahal", 1,
                "https://i.pinimg.com/564x/9b/ed/cf/9bedcfb37de32251e932268d3141597a.jpg", true, "USER");
        accountStorage.addAccount(bishnu);

        Account branden = new Account("lynxBob", "GoWeiwei", "Branden Webb", 100,
                "https://www.testbytes.net/wp-content/uploads/2019/06/Untitled-53-300x300.png", true, "USER");
        accountStorage.addAccount(branden);

        Account jon = new Account("jonnyboi", "GoWeiwei", "Jonathan Abrams", 100,
                "https://media.zigcdn.com/media/content/2020/Mar/whatsappimage2020-03-28at12_39_27pm_560x420.jpg", true, "USER");
        accountStorage.addAccount(jon);






        Challenge mileWalk = new Challenge("Walk a mile during lunch!", connor,
                "Eating is overrated, be a plant and soak up some sunshine!",
                "https://www.thestatesman.com/wp-content/uploads/2017/12/WALKING00.jpg", 4, 10,
                "Walk one mile every day this week.", "7 days", 1, 5,true);

//        Comment mileCom1 = new Comment("I don't walk, I lift weights.");
//        mileWalk.addComment(mileCom1);
//        challengeStorage.addChallenge(mileWalk);

        Challenge flowerHunt = new Challenge("Lunch hour flower hunt", weiwei,
                "Spring is finally here!!! Have you told yourself “Outside is so nice, I want to go outside today.” But as time goes by, you never make it outside.\n" +
                        "This lunch hour flower hunt will give you a chance to go outside, and snip pictures of the flowers that you see in your yard, or on the way of your walk.\n" +
                        "Enjoy the sun and get moving by doing this challenge.",
                "https://www.thestatesman.com/wp-content/uploads/2017/12/WALKING00.jpg", 5, 10,
                "Pick flowers every lunch break", "30 mins", "10", true);

//        Comment gigitygigity = new Comment("oh right");
//        flowerHunt.addComment(gigitygigity);
//        challengeStorage.addChallenge(flowerHunt);

        Challenge drinkWater = new Challenge("Water Bottle Challenge!", bishnu,
                "Drink a bottle of water in under 1 minute!",
                "https://i.ytimg.com/vi/OB2yQLOLVck/maxresdefault.jpg", 4, 10,
                "Drink a bottle of water in 1 minute.", "1 min", "5", true);

        Challenge floorIsLava = new Challenge("The Floor is Lava!", bishnu,
                "Lava has breached the main floor! Jump from desk to desk to stay alive!",
                "https://i.ytimg.com/vi/OB2yQLOLVck/maxresdefault.jpg", 4, 10,
                "Floor is lava, Jumping", "30 min", "everyone", true);

//        how do comments know where to go and who they belong to at the same time
    }

}
