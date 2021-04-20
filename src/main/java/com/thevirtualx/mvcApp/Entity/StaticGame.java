package com.thevirtualx.mvcApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class StaticGame {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String shortName;
    private int maxSize;
    @OneToMany(mappedBy = "staticGame")
    @JsonIgnore
    private Collection<Game> games;
    private int rating;

    public StaticGame(String name, String shortName, int maxSize) {
        this.name = name;
        this.shortName = shortName;
        this.maxSize = maxSize;
        this.games = new ArrayList<>();
        this.rating = 0;
    }

    public StaticGame() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Collection<Game> getGames() {
        return games;
    }

    public int getRating() {
        return rating;
    }

    public void addRatingPoint() {
        this.rating++;
    }
}
