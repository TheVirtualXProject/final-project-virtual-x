package com.thevirtualx.mvcApp.Entity;

import com.thevirtualx.mvcApp.Controller.GameController;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Game {
//neeeds fleshed out
    //html codes, embedded in thymeleaf
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String shortName;
    private String memberId;
    private String creatorName;
    private int timeLimitScale;
    private int joinedPlayers;
    private int maxPlayers;
    private Instant creation;
    @ManyToOne
    private StaticGame staticGame;
    @ElementCollection
    private Collection<GameHash> joinedPlayerHashes;


    public Game(String title, String shortName, int maxPlayers, String creatorName, StaticGame staticGame) {
        this.title = title;
        this.shortName = shortName;
        this.memberId = "ng54172493";
        this.timeLimitScale = 0;
        this.joinedPlayerHashes = new ArrayList<>();
        this.creatorName = creatorName;
        this.joinedPlayers = 0;
        this.maxPlayers = maxPlayers;
        this.staticGame = staticGame;
        this.creation = Instant.now();

    }

    public Game() {}

    public void addHash(GameHash hash) {
        joinedPlayerHashes.add(hash);
        joinedPlayers++;
        staticGame.addRatingPoint();
    }

    public Instant getCreation() {
        return creation;
    }

    public Collection<GameHash> getJoinedPlayerHashes() {
        return joinedPlayerHashes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortName() {
        return shortName;
    }

    public String getMemberId() {
        return memberId;
    }

    public StaticGame getStaticGame() {
        return staticGame;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public int getTimeLimitScale() {
        return timeLimitScale;
    }


    public int getJoinedPlayers() {
        return joinedPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}
