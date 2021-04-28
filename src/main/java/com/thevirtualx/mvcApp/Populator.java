package com.thevirtualx.mvcApp;

import com.thevirtualx.mvcApp.Entity.*;
import com.thevirtualx.mvcApp.Repo.StaticGameRepository;
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
    private StaticGameRepository staticGameRepository;

    public Populator(AccountStorage accountStorage, ChallengeStorage challengeStorage,
                     ChatroomStorage chatroomStorage,  GameStorage gameStorage, StaticGameRepository staticGameRepository) {
        this.accountStorage = accountStorage;
        this.challengeStorage = challengeStorage;
        this.chatroomStorage = chatroomStorage;
        this.gameStorage = gameStorage;
        this.staticGameRepository = staticGameRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Account lani = new Account("TurboJay", "GoWeiwei", "Jelanie Starks", 0,
                "https://static.wikia.nocookie.net/dragonball/images/5/58/GokuSuperSaiyanTransformedAtLast.png/revision/latest/scale-to-width-down/200?cb=20191103030051", true, "USER");
        accountStorage.addAccount(lani);

        Account connor = new Account("Ronnoc", "GoWeiwei", "Connor Chambers", 1,
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






        Challenge mileWalk = new Challenge("Walk a mile during lunch!",
                "Eating is overrated, be a plant and soak up some sunshine!",
                "https://www.thestatesman.com/wp-content/uploads/2017/12/WALKING00.jpg", 4, 10,
                "Walk one mile every day this week.", "7 days", 1, 5,true, connor.getRealName());

//        Comment mileCom1 = new Comment("I don't walk, I lift weights.");
//        mileWalk.addComment(mileCom1);
        mileWalk.addAccount(connor);
        challengeStorage.addChallenge(mileWalk);

        Challenge flowerHunt = new Challenge("Lunch hour flower hunt",
                "Spring is finally here!!! Have you told yourself “Outside is so nice, I want to go outside today.” But as time goes by, you never make it outside.\n" +
                        "This lunch hour flower hunt will give you a chance to go outside, and snip pictures of the flowers that you see in your yard, or on the way of your walk.\n" +
                        "Enjoy the sun and get moving by doing this challenge.",
                "https://www.thestatesman.com/wp-content/uploads/2017/12/WALKING00.jpg", 5, 10,
                "Pick flowers every lunch break", "30 mins", 1,5, true, weiwei.getRealName());

//        Comment gigitygigity = new Comment("oh right");
//        flowerHunt.addComment(gigitygigity);
        flowerHunt.addAccount(weiwei);
        challengeStorage.addChallenge(flowerHunt);

        Challenge drinkWater = new Challenge("Water Bottle Challenge!",
                "Drink a bottle of water in under 1 minute!",
                "https://i.ytimg.com/vi/OB2yQLOLVck/maxresdefault.jpg", 4, 10,
                "Drink a bottle of water in 1 minute.", "1 min", 1,5, true, bishnu.getRealName());
        drinkWater.addAccount(bishnu);
        challengeStorage.addChallenge(drinkWater);

        Challenge floorIsLava = new Challenge("The Floor is Lava!",
                "Lava has breached the main floor! Jump from desk to desk to stay alive!",
                "https://i.ytimg.com/vi/OB2yQLOLVck/maxresdefault.jpg", 4, 10,
                "Floor is lava, Jumping", "30 min", 2,6, true, lani.getRealName());
        floorIsLava.addAccount(lani);
        challengeStorage.addChallenge(floorIsLava);

        Challenge pushUp = new Challenge("60 Second Pushup Challenge", "See how many pushups you can do in 1 minute!",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Liegestuetz02_ani_fcm.gif/220px-Liegestuetz02_ani_fcm.gif",
                4, 10, "Try to get more than 10 pushups!", "1 min", 1, 10,
                true, jon.getRealName());
        pushUp.addAccount(jon);
        challengeStorage.addChallenge(pushUp);

        Challenge kindergatenCode = new Challenge("Complete Code.org", "See how fast you can finish the first 'hour' of Code.org",
                "https://code.org/images/logo.svg", 4, 10, "Are you smarter than a 5th grader?",
                "1 week", 1, 10, true,branden.getRealName());
        kindergatenCode.addAccount(branden);
        challengeStorage.addChallenge(kindergatenCode);

        Chatroom chadsOnly = new Chatroom("Lunch Time Chat!", connor.getRealName());
        chatroomStorage.addChatroom(chadsOnly);

        StaticGame sixteenMusashi = new StaticGame("Sixteen Musashi", "sixteenmusashi", 2);
        StaticGame parchis = new StaticGame("Multiplayer Parchis", "mpparchis", 4);
        StaticGame irishSnap = new StaticGame("Irish Snap", "irishsnap", 4);
        StaticGame shutTheBox = new StaticGame("Shut The Box", "mpshutbox", 4);
        StaticGame pebbles = new StaticGame("Pebbles", "mppebbles", 2);
        StaticGame guessWhat = new StaticGame("Guess What", "guesswhat", 4);
        StaticGame dominoes = new StaticGame("Dominoes", "mpdominoes", 2);
        StaticGame reversi = new StaticGame("Reversi", "mpreversi", 2);
        StaticGame honlok = new StaticGame("Honlok", "honlok", 2);
        StaticGame darts = new StaticGame("Darts", "mpdarts", 4);
        StaticGame snakesAndLadders = new StaticGame("Snakes and Ladders", "snakesladders", 8);
        StaticGame chess = new StaticGame("Chess", "chess", 2);
        StaticGame eightBall = new StaticGame("8 Ball Pool", "eightball", 2);
        StaticGame mancala = new StaticGame("Mancala", "mpmancala", 2);
        StaticGame warShip = new StaticGame("Battle Ship", "mpbattleship", 2);
        StaticGame mineSweepingRace = new StaticGame("Mine Sweeping Race", "minesweeping", 8);
        StaticGame ticTacToe = new StaticGame("Tic Tac Toe", "mptictactoe", 2);

        staticGameRepository.save(sixteenMusashi);
        staticGameRepository.save(parchis);
        staticGameRepository.save(irishSnap);
        staticGameRepository.save(shutTheBox);
        staticGameRepository.save(pebbles);
        staticGameRepository.save(guessWhat);
        staticGameRepository.save(dominoes);
        staticGameRepository.save(reversi);
        staticGameRepository.save(honlok);
        staticGameRepository.save(darts);
        staticGameRepository.save(snakesAndLadders);
        staticGameRepository.save(chess);
        staticGameRepository.save(eightBall);
        staticGameRepository.save(mancala);
        staticGameRepository.save(warShip);
        staticGameRepository.save(mineSweepingRace);
        staticGameRepository.save(ticTacToe);


        Game testGame = new Game(ticTacToe.getName(), ticTacToe.getShortName(), ticTacToe.getMaxSize(),"Branden Webb", ticTacToe);
        gameStorage.addGame(testGame);



    }

}
