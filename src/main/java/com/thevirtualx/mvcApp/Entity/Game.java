package com.thevirtualx.mvcApp.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
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
    @ElementCollection
    private Collection<GameHash> joinedPlayerHashes;


    public Game(String title, String shortName, int maxPlayers, String creatorName) {
        this.title = title;
        this.shortName = shortName;
        this.memberId = "ng54172493";
        this.timeLimitScale = 0;
        this.joinedPlayerHashes = new ArrayList<>();
        this.creatorName = creatorName;
        this.joinedPlayers = 0;
        this.maxPlayers = maxPlayers;

    }


    public void addHash(GameHash hash) {
        joinedPlayerHashes.add(hash);
        joinedPlayers++;
    }
}
