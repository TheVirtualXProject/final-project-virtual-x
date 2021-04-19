package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Embeddable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Embeddable
public class GameHash {

    private Long playerId;
    private String playerName;
    private String secretKey;
    private String hash;


    public GameHash(Long playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.secretKey = "y9nSMeknkt7tgOIegoDMuCMgYKPzb8Cs";
        this.hash = calculatePlayerHash();
    }

    protected GameHash() {}


    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String calculatePlayerHash() {
        byte[] temp = (playerId + playerName + secretKey).getBytes(StandardCharsets.UTF_8);
        byte[] md5 = null;


        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md5 = md.digest(temp);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("rest in peace");
        }

        String string = new String(md5);
        return string;

    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof GameHash) {
            GameHash gameHash = (GameHash)o;
            return this.playerName == gameHash.getPlayerName();
        }
        return false;
    }

}
